package com.learn.日志脱敏;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.serializer.ValueFilter;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;

/**
 * @author xuejianjun<xuejianjun@corp.netease.com>
 * @since 2018/12/03 11:48 AM
 */
public class SensitiveInfoUtils {

    public static String toJsonString(Object object) {
        return JSON.toJSONString(object, getValueFilter(), SerializerFeature.WriteMapNullValue);
    }

    private static String desensitizePhoneOrIdCard(String num) {
        if (StringUtils.isBlank(num)) {
            return "";
        }
        return StringUtils.left(num, 3).concat(StringUtils.removeStart(StringUtils.leftPad(StringUtils.right(num, 4), StringUtils.length(num), "*"), "***"));
    }

    private static String desensitizeBankCard(String cardNum) {
        if (StringUtils.isBlank(cardNum)) {
            return "";
        }
        return StringUtils.left(cardNum, 4).concat(StringUtils.removeStart(StringUtils.leftPad(StringUtils.right(cardNum, 4), StringUtils.length(cardNum), "*"), "****"));
    }

    private static final ValueFilter getValueFilter() {
        return new ValueFilter() {
            @Override
            public Object process(Object obj, String key, Object value) {//obj-对象  key-字段名  value-字段值
                try {
                    Field field = obj.getClass().getDeclaredField(key);
                    SensitiveInfo annotation = field.getAnnotation(SensitiveInfo.class);
                    if (null != annotation && value instanceof String) {
                        String strVal = (String) value;
                        if (StringUtils.isNotBlank(strVal)) {
                            switch (annotation.type()) {
                                case PHONE:
                                    return desensitizePhoneOrIdCard(strVal);
                                case ID_CARD:
                                    return desensitizePhoneOrIdCard(strVal);
                                case BANK_CARD:
                                    return desensitizeBankCard(strVal);
                                default:
                                    break;
                            }
                        }
                    }
                } catch (NoSuchFieldException e) {
                    //找不到的field对功能没有影响,空处理
                }
                return value;
            }
        };
    }


    public static void main(String[] args) {
        CardInfo cardInfo = new CardInfo();
        cardInfo.setId("11111111111111111");
        cardInfo.setCardId("6228480402564890018");
        cardInfo.setPhone("15088755202");
        System.out.println(SensitiveInfoUtils.toJsonString(cardInfo));
    }

}
