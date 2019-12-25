package com.中间件.hbase.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
/**
 * hbase 表 描述
 */
public enum  HbaseTableEnum {
    /**
     * 线索表
     */
    TABLE_CLUE_INFO("clue","default",HbbaseConstant.DEFAULT_MAX_FILE_SIZE);
    /**
     * 表名
     */
    private String tableName;
    /**
     * 列族
     */
    private  String familyName;
    /**
     * 文件大小
     */
    private long maxFileSize;
}
