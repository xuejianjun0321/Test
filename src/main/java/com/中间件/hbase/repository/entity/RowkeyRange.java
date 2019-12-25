package com.中间件.hbase.repository.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
/**
 * RowkeyRange
 */
public class RowkeyRange {
    /**
     * 开始行
     */
    private String startRowkey;
    /**
     * 结束行
     */
    private String endRowkey;

}
