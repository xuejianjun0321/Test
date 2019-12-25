package com.中间件.hbase.query;

import com.中间件.hbase.annotation.HbaseField;
import com.中间件.hbase.annotation.HbaseQueryField;
import com.中间件.hbase.constant.HbaseFieldDefaultValueEnum;
import com.中间件.hbase.converter.Converter;
import com.中间件.hbase.exceptions.RestServiceException;
import com.中间件.hbase.mode.DateRange;
import com.中间件.hbase.utils.FilterUtils;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.filter.*;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * hbase 查询 query
 * 作用：构建filter，scan，
 */
public interface HbaseQuery {

    /**
     * 获取转换器
     *
     * @return
     */
    Converter getConverter();

    /**
     * setDefaultValue
     *
     * @throws IllegalAccessException
     */
    default void setDefaultValue() throws IllegalAccessException {
    }

    /**
     * 缓存默认设置100
     *
     * @return Integer
     */
    default Integer getCaching() {
        return 100;
    }

    /**
     * 禁止加载缓存
     *
     * @return
     */
    default boolean getCacheBlocks() {
        return false;
    }

    /**
     * getReversed
     *
     * @return
     */
    default boolean getReversed() {
        return true;
    }

    /**
     * getStartRow
     *
     * @return
     */
    String getStartRow();

    /**
     * getStopRow
     *
     * @return
     */
    String getStopRow();


    /**
     * 构建 Scan
     *
     * @param isPaging
     * @return
     * @throws IOException
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     * @ isAll 是否构建 分页查询条件
     */
    default Scan buildScan(boolean isPaging) throws IllegalArgumentException, IllegalAccessException {

        // 补充默认值
        setDefaultValue();
        Scan scan = new Scan();
        String startRow = getStartRow();
        String stopRow = getStopRow();
        if (startRow != null) {
            scan.setStartRow(Bytes.toBytes(startRow));
        }
        if (stopRow != null) {
            scan.setStopRow(Bytes.toBytes(stopRow));
        }

        FilterList rootFilter = buildFilter();
        if (isPaging) {
            PageFilter pageFilter = getPageFilter();
            if (pageFilter != null) {
                rootFilter.addFilter(pageFilter);
            }
        }

        if (rootFilter.getFilters().size() > 0) {
            scan.setFilter(rootFilter);
        }

        // 最后添加 pageFilter
        scan.setCaching(getCaching());

        scan.setCacheBlocks(getCacheBlocks());

        scan.setReversed(getReversed());

        return scan;

    }

    /**
     * 构建 过滤器
     *
     * @return FilterList
     * @throws RuntimeException
     * @throws IllegalAccessException
     */
    default FilterList buildFilter() throws RuntimeException, IllegalAccessException {

        FilterList rootFilter = new FilterList(FilterList.Operator.MUST_PASS_ALL);
        /**筛选 查询条件字段*/
        List<Field> fields = Stream.of(this.getClass().getDeclaredFields()).filter(f -> f.getAnnotation(HbaseQueryField.class) != null).filter(f -> f.getAnnotation(HbaseField.class) != null).collect(Collectors.toList());

        for (Field f : fields) {
            f.setAccessible(true);
            HbaseQueryField hbaseQueryField = f.getAnnotation(HbaseQueryField.class);
            HbaseField hbaseField = f.getAnnotation(HbaseField.class);
            Object objectValue = f.get(this);
            if (objectValue == null && hbaseField.isRequired()) {
                throw new RestServiceException("必填字段未填写");
            }
            switch (hbaseQueryField.fieldType()) {
                case SINGLE:
                    Filter filter = FilterUtils.buildQueryFilter(getConverter().convertToString(f, this), hbaseQueryField, hbaseField, getFamilyName());
                    if (filter != null) {
                        rootFilter.addFilter(filter);
                    }
                    break;
                case RANGE:

                    Object rangeValue = f.get(this);
                    // 如果日期区间类型 为空 ，也没设置默认值，直接跳出
                    if (rangeValue == null) {
                        break;
                    }
                    //处理日期区间类型
                    if (objectValue instanceof DateRange) {
                        // 日期区间 不为空 构建区间范围查询条件
                        if (rangeValue != null) {
                            List<Filter> rangeFilters = FilterUtils.buildQueryDateRangeFilterList((DateRange) rangeValue, hbaseQueryField, hbaseField, getFamilyName());
                            if (rangeFilters != null && !rangeFilters.isEmpty()) {
                                rangeFilters.stream().forEach(rf -> rootFilter.addFilter(rf));
                            }
                        }
                    }
                    break;
                case ROW_KEY_LIST:

                    Collection<String> rowKeyList = (Collection<String>) f.get(this);
                    if (rowKeyList == null || rowKeyList.size() == 0) {
                        break;
                    }
                    FilterList rowKeyFilteList = new FilterList(FilterList.Operator.MUST_PASS_ONE);
                    for (String rowKey : rowKeyList) {
                        rowKeyFilteList.addFilter(new RowFilter(CompareFilter.CompareOp.EQUAL, new BinaryComparator(Bytes.toBytes(rowKey))));
                    }
                    rootFilter.addFilter(rootFilter);
                    break;
                case LIST:

                    Collection values = (Collection) f.get(this);
                    //  如果字段为空 且  也没填默认值 直接跳出
                    if (values == null && hbaseField.defaultValue() == HbaseFieldDefaultValueEnum.NULL) {
                        break;
                    }
                    /**
                     * 如果value 依然为空，直接 跳出
                     */
                    if (values == null) {
                        break;
                    }
                    List<String> stringValues = new ArrayList<>(values.size());
                    for (Object v : values) {
                        stringValues.add(getConverter().convertToString(v, hbaseField));
                    }
                    if (!stringValues.isEmpty()) {
                        rootFilter.addFilter(FilterUtils.buildQueryFilterList(stringValues, hbaseQueryField, hbaseField, getFamilyName()));
                    }
                    break;
                default:
                    break;
            }
        }
        return rootFilter;
    }


    /**
     * getFamilyName
     *
     * @return String
     */
    String getFamilyName();

    /**
     * 构建分页过滤器
     *
     * @return PageFilter
     */

    PageFilter getPageFilter();

}
