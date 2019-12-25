package com.中间件.hbase.mode;


import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
/**
 * hbase 分页查询 结果集合
 */
public class HbasePageResult<T> implements Serializable {

    /**
     * 每页的数量
     */
    private int pageSize;

    /**"下一页起始行RowKey"*/
    private String nextRowKey;

    /** "是否有下一行"*/
    private boolean hasNext;

    /** "结果集" */
    private List<T> data;

    public HbasePageResult(int pageSize, String nextRowKey, boolean hasNext, List<T> data) {
        this.pageSize = pageSize;
        this.nextRowKey = nextRowKey;
        this.hasNext = hasNext;
        this.data =data;
    }
}