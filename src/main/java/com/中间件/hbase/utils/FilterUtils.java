package com.中间件.hbase.utils;


import com.中间件.hbase.annotation.HbaseField;
import com.中间件.hbase.annotation.HbaseQueryField;
import com.中间件.hbase.constant.HbaseFieldDefaultValueEnum;
import com.中间件.hbase.mode.DateRange;
import org.apache.hadoop.hbase.filter.*;
import org.apache.hadoop.hbase.util.Bytes;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * hbase 过滤器操作工具类
 */
public class FilterUtils {

    /**
     * 构建查询过滤器
     *
     * @param value
     * @param hbaseQueryField
     * @param
     * @param familyName
     * @return
     */
    public static final Filter buildQueryFilter(String value, HbaseQueryField hbaseQueryField, HbaseField hbaseField, String familyName) {
        // 如果 使用默认值，直接 用 二进制比较器
        Class<? extends ByteArrayComparable> comparator = hbaseQueryField.comparator();
        //如果设置了默认值，直接使用默认值作为查询条件
        if (value == null && hbaseField.defaultValue() != HbaseFieldDefaultValueEnum.NULL) {
            comparator = BinaryComparator.class;
        } else if (value == null) {
            return null;
        }

        Filter filter = buildQueryFilter(
                hbaseField.fieldName(),
                value,
                hbaseQueryField.compareOp(),
                comparator,
                hbaseQueryField.filterIfMissing(),
                familyName
        );
        return filter;
    }

    /**
     * 构建 空值查询，
     * 解决  SQL  类似  where  field is null 查询条件
     * @param hbaseQueryField
     * @param hbaseField
     * @param familyName
     * @return
     */
    public static final Filter buildQueryNullFilter( HbaseQueryField hbaseQueryField, HbaseField hbaseField, String familyName) {
        Filter filter = buildQueryFilter(
                hbaseField.fieldName(),
                null,
                CompareFilter.CompareOp.EQUAL,
                NullComparator.class,
                hbaseQueryField.filterIfMissing(),
                familyName
        );
        return filter;
    }

    /**
     * 构建过滤器
     *
     * @param fieldName
     * @param value
     * @param compareOp
     * @param comparatorClass
     * @param filterIfMissing
     * @param familyName
     * @return
     */
    public static final Filter buildQueryFilter(
            String fieldName,
            String value,
            CompareFilter.CompareOp compareOp,
            Class<? extends ByteArrayComparable> comparatorClass,
            boolean filterIfMissing,
            String familyName) {
        ByteArrayComparable comparator = ByteArrayComparableUtils.buildByteArrayComparable(value, comparatorClass);
        SingleColumnValueFilter filter = new SingleColumnValueFilter(
                Bytes.toBytes(familyName),
                Bytes.toBytes(fieldName),
                compareOp,
                comparator
        );
        filter.setFilterIfMissing(filterIfMissing);
        return filter;
    }

    /**
     * 字段 多选情况，筛选器过滤
     *
     * @param values
     * @param hbaseQueryField
     * @param hbaseField
     * @param familyName
     * @return
     */
    public static final FilterList buildQueryFilterList(List<String> values, HbaseQueryField hbaseQueryField, HbaseField hbaseField, String familyName) {
        FilterList subFilterList = new FilterList(FilterList.Operator.MUST_PASS_ONE);
        values.stream()
                .distinct()
                .map(subValue -> FilterUtils.buildQueryFilter(subValue, hbaseQueryField, hbaseField, familyName))
                .filter(Objects::nonNull)
                .forEach(f -> subFilterList.addFilter(f));
        //添加空值支持
        if (!values.stream().filter(Objects::isNull).collect(Collectors.toList()).isEmpty()) {
            Filter nullFilter= FilterUtils.buildQueryNullFilter(hbaseQueryField,hbaseField,familyName);
            Filter emptyFilter = FilterUtils.buildQueryFilter(hbaseField.fieldName(),"", hbaseQueryField.compareOp(),BinaryComparator.class,true,familyName);
            subFilterList.addFilter(nullFilter);
            subFilterList.addFilter(emptyFilter);
        }
        return subFilterList;
    }

    /**
     * 日期区间 字段 查询过滤器
     *
     * @param value
     * @param hbaseQueryField
     * @param hbaseField
     * @param familyName
     * @return
     */
    public static List<Filter> buildQueryDateRangeFilterList(DateRange value, HbaseQueryField hbaseQueryField, HbaseField hbaseField, String familyName) {

        List<Filter> filterList = new ArrayList<>(2);
        // createDateStart filter
        if (value.getStart() != null) {
            String startValue = value.getStartTimeToString();
            Filter filter = FilterUtils.buildQueryFilter(
                    hbaseField.fieldName(),
                    startValue,
                    hbaseQueryField.rangeCompareOp()[0],
                    hbaseQueryField.comparator(),
                    hbaseQueryField.filterIfMissing(),
                    familyName
            );
            filterList.add(filter);
        }
        // createDateEnd filter
        if (value.getEnd() != null) {
            String endValue = value.getEndTimeToString();
            Filter filter = FilterUtils.buildQueryFilter(
                    hbaseField.fieldName(),
                    endValue,
                    hbaseQueryField.rangeCompareOp()[1],
                    hbaseQueryField.comparator(),
                    hbaseQueryField.filterIfMissing(),
                    familyName
            );
            filterList.add(filter);
        }
        return filterList;
    }
}
