package com.架构设计.模板架构.mq;

import lombok.Data;

import java.util.Objects;

/**
 *
 * @author 莫那·鲁道
 * @date 2019-04-28-20:13
 */
@Data
public class Topic {

    /**
     * 话题.
     */
    String topic;

    /**
     * subExpression 过滤表达式, 使用 * 号,表示获取所有; 例如使用 TagA || TagC || TagD 表示只获取此 3 个 tag 的消息.
     */
    String subExpression = "*";

    public Topic() {
    }

    public Topic(String topic) {
        this.topic = topic;
    }

    public Topic(String topic, String subExpression) {
        this.topic = topic;
        this.subExpression = subExpression;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Topic topic1 = (Topic) o;
        return Objects.equals(topic, topic1.topic) &&
                Objects.equals(subExpression, topic1.subExpression);
    }

    @Override
    public int hashCode() {
        return Objects.hash(topic, subExpression);
    }
}
