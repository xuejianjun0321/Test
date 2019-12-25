package com.中间件.hbase.utils;

import com.中间件.hbase.mode.DateRange;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang.StringUtils;

import java.io.Serializable;

/**
 * 页码分页参数
 *
 * @date: 2018/8/7 15:54
 **/
@Setter
@Getter
public class PageQuery implements Serializable {

    /**
     * 查询创建时间区间
     */
    private DateRange createDateRange;

    /**
     * 每页数量
     */
    private Integer pageSize;

    /**
     * 起始行rowKey
     */
    private String startRowKey;

    /**
     * 结束行rowKey
     */
    private String endRowKey;

    public String getStartRowKey() {
        if (startRowKey == null) {
            setStartRowKey(createDateRange.getEndTimeToString());
        }
        return startRowKey;
    }

    public String getStopRowKey() {
        if (endRowKey == null) {
            setEndRowKey(createDateRange.getStartTimeToString());
        }
        return endRowKey;
    }

    /**
     * 补充默认值
     */
    public void setDefaultValue() {
        if (pageSize == null) {
            pageSize = new Integer(100);
        }
        if (createDateRange == null) {
            createDateRange = new DateRange();
        }
        createDateRange.setDefaultValue();
        if (StringUtils.isEmpty(startRowKey)) {
            getStartRowKey();
        }
        if (StringUtils.isEmpty(endRowKey)) {
            getStopRowKey();
        }

    }
}
