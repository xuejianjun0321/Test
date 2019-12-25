package com.中间件.hbase.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HConstants;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
/**
 * hbase 相关 bean
 *
 */
@Slf4j
public class HbaseConfiguration {

    @Bean(value = "hbaseConnection", name = "hbaseConnection")
    public Connection connection(@Value("${hbase.zkAddress}") String zkAddress) {
        try {
            org.apache.hadoop.conf.Configuration config = HBaseConfiguration.create();
            config.set(HConstants.ZOOKEEPER_QUORUM, zkAddress);
            return ConnectionFactory.createConnection(config);
        } catch (Exception e) {
            log.error("ConnectionFactory.createConnection error", e);
            if (e instanceof RuntimeException) {
                throw (RuntimeException) e;
            }
            throw new RuntimeException("ConnectionFactory.createConnection error", e.getCause() == null ? e : e.getCause());
        }
    }
}
