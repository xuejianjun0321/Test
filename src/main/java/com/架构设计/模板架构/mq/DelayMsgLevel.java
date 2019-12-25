package com.架构设计.模板架构.mq;

/**
 * 消息延迟级别:
 * 1:  1s
 * 2:  5s
 * 3:  10s
 * 4:  30s
 * 5:  1m
 * 6:  2m
 * 7:  3m
 * 8:  4m
 * 9:  5m
 * 10: 6m
 * 11: 7m
 * 12: 8m
 * 13: 9m
 * 14: 10m
 * 15: 20m
 * 16: 30m
 * 17: 1h
 * 18: 2h
 */
public enum DelayMsgLevel {

    /** 级别一 */
    ONE(1, "1 秒", 1000L),
    TWO(2, "5 秒", 5 * 1000L),
    THREE(3, "10 秒", 10 * 1000),
    FOUR(4, "30 秒", 30 * 1000),
    FIVE(5, "1 分钟", 60 * 1000),
    SIX(6, "2 分钟", 2 * 60 * 1000),
    SEVEN(7, "3 分钟", 3 * 60 * 1000),
    EIGHT(8, "4 分钟", 4 * 60 * 1000),
    NINE(9, "5 分钟", 300 * 1000),
    TEN(10, "6 分钟", 360 * 1000),
    ELEVEN(11, "7 分钟", 420 * 1000),
    TWELVE(12, "8 分钟", 480 * 1000),
    THIRTEEN(13, "9 分钟", 540 * 1000),
    FOURTEEN(14, "10 分钟", 600 * 1000),
    FIFTEEN(15, "20 分钟", 1200 * 1000),
    SIXTEEN(16, "30 分钟", 1800 * 1000),
    SEVENTEEN(17, "1 小时", 3600 * 1000),
    EIGHTEEN(18, "2 小时", 120 * 60 * 1000),

    @Deprecated
    one(1, "1 秒", 1000L),
    @Deprecated
    two(2, "5 秒", 5 * 1000L),
    @Deprecated
    three(3, "10 秒", 10 * 1000),
    @Deprecated
    four(4, "30 秒", 30 * 1000),
    @Deprecated
    five(5, "1 分钟", 60 * 1000),
    @Deprecated
    six(6, "2 分钟", 2 * 60 * 1000),
    @Deprecated
    seven(7, "3 分钟", 3 * 60 * 1000),
    @Deprecated
    eight(8, "4 分钟", 4 * 60 * 1000),
    @Deprecated
    nine(9, "5 分钟", 300 * 1000),
    @Deprecated
    ten(10, "6 分钟", 360 * 1000),
    @Deprecated
    eleven(11, "7 分钟", 420 * 1000),
    @Deprecated
    twelve(12, "8 分钟", 480 * 1000),
    @Deprecated
    thirteen(13, "9 分钟", 540 * 1000),
    @Deprecated
    fourteen(14, "10 分钟", 600 * 1000),
    @Deprecated
    fifteen(15, "20 分钟", 1200 * 1000),
    @Deprecated
    sixteen(16, "30 分钟", 1800 * 1000),
    @Deprecated
    seventeen(17, "1 小时", 3600 * 1000),
    @Deprecated
    eighteen(18, "2 小时", 120 * 60 * 1000);


    private int level;

    private String desc;

    private long timestamp;

    DelayMsgLevel(int level, String desc, long timestamp) {
        this.level = level;
        this.timestamp = timestamp;
        this.desc = desc;
    }

    /**
     * 找寻最接近指定时间戳的级别.
     */
    public static DelayMsgLevel getPossibleLevel(long timestamp) {
        DelayMsgLevel[] arr =    DelayMsgLevel.values();
        for (int i = arr.length - 1; i >= 0; i--) {
            if (timestamp >= arr[i].timestamp) {
                return arr[i];
            }
        }
        throw new IllegalArgumentException("not support less 1S time.");
    }


    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public static long getTimestamp(int level) {
        for (DelayMsgLevel value : DelayMsgLevel.values()) {
            if (value.getLevel() == level) {
                return value.getTimestamp();
            }
        }
        throw new IllegalArgumentException("delayMsgLevel must be 1 ~ 18.");

    }


}