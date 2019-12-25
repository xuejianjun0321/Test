package com.架构设计.模板架构.mq;

import lombok.Data;

/**
 *
 * 只有 RocketMQ 才需要. ActiveMQ 不支持此功能.
 *
 *
 * 1. 长度限制在 7-60 字节之间;
 * 2. Group ID 一旦创建, 将无法再修改。
 *
 * @author 莫那·鲁道
 * @date 2019-04-28-20:13
 */
@Data
public class Group {

    /**
     * 组名, 通常建议生产者组名和消费者组名一致, 便于管理, 减少概念.
     *
     * 可使用不同的消费组名实现广播模式.
     *
     * 使用 IP 是为了便于查找问题.
     */
    String groupName = HostNameUtil.getIp() + ":default_groupName";

    public Group() {
    }

    public Group(String groupName) {
        this.groupName = groupName;
    }

    /**
     * 由于阿里云要求 GroupName必须是 GID_ 开头, 为了屏蔽这个功能,我们就做了简单的处理.
     */
    public Group buildAliyunGroupName() {
        if (this.groupName.startsWith("GID_")) {
            return this;
        }
        return new Group("GID_" + this.groupName);
    }

    /**
     * 当一个客户端从阿里云切到其他(rocketMQ), 那么, groupName 前面的 GID_ 就需要去掉.
     */
    public Group recoveryAliyunGroupName() {
        if (this.groupName.startsWith("GID_")) {
            return new Group(this.getGroupName().substring(4));
        }
        return this;

    }
}
