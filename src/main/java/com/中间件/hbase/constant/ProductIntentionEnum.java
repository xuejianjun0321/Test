package com.中间件.hbase.constant;

import com.中间件.hbase.utils.EnumUtils;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Map;

/**
 * 意向产品
 * @author xuejianjun<xuejianjun @ corp.netease.com>
 * @since 2019/12/18 21:34
 */
@AllArgsConstructor
@Getter
public enum  ProductIntentionEnum implements ICodeEnum {
    /**
     * 意向产品枚举值
     */
    NULL((byte)-1, ""),
    XUANYUAN_API((byte) 0, "轩辕API"),
    XUANYUAN_SAAS((byte) 1, "轩辕SAAS"),
    DING((byte) 2, "钉签"),
    WUKONG((byte) 3, "悟空"),
    TIANYIN((byte) 4, "天印"),
    ;

    public static final Map<Byte, ProductIntentionEnum> CODE_MAP = EnumUtils.initEnumMap(ProductIntentionEnum.class);

    private Byte code;

    private String text;
}
