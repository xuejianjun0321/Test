package com.中间件.hbase.repository.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * hbase 分页结果集合
 */
@Getter
@Setter
@ToString
public class HbasePageDataResult {
    /**
     * 每页数据条数
     */
    Integer pageSize;
    /**
     * 总条数
     */
    Integer totalRows;

    /**
     * 存放每一页的开始行，结束行
     */

    List<RowkeyRange> data;

    /**
     * 总页数
     * @return
     */
    public int getTotalPages() {
        return data != null ? data.size() : 0;
    }
}
