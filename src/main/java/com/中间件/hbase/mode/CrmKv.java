package com.中间件.hbase.mode;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
/**
 * crm 通用的kv 模型
 */
public class CrmKv<K, V> {
    /**
     * key
     */
    private K key;
    /**
     * value
     */
    private V value;
}
