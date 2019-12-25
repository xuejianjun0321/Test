package com.中间件.hbase.mode;

import com.中间件.hbase.constant.HbaseFieldformatEnum;
import com.中间件.hbase.utils.DateUtils;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * 时间区间
 * @author xuejianjun<xuejianjun @ corp.netease.com>
 * @since 2019/12/18 21:26
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DateRange {

    /**
     * 开始时间
     */
    private LocalDateTime start  ;

    public String getStartTimeToString() {
        if (start == null) {
            return null;
        }
        return DateUtils.formatLocalDateTime(start, HbaseFieldformatEnum.DATE_FORMAT_Y_M_D.getFormat());
    }

    /**
     * 结束时间
     */
    private LocalDateTime end;

    public String getEndTimeToString(){
        if(end == null){
            return null;
        }
        return DateUtils.formatLocalDateTime(end, HbaseFieldformatEnum.DATE_FORMAT_Y_M_D.getFormat());
    }

    /**
     * 时间区间 默认一年
     */
    public DateRange setDefaultValue() {

        if (end != null && start != null) {
            return this;
        }

        LocalDateTime now = LocalDateTime.now();
        if (start == null) {
            //int year, Month month, int dayOfMonth, int hour, int minute, int second
            start = LocalDateTime.of(now.getYear(), now.getMonth(), now.getDayOfMonth(), 0, 0, 0).plusMonths(-3);
        }
        if (end == null) {
            end = LocalDateTime.of(now.getYear(), now.getMonth(), now.getDayOfMonth(), 0,0,0).plusDays(1);
        }
        return this;
    }

}
