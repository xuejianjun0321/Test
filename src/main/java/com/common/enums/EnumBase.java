package com.common.enums;

/**
 * 枚举基类
 *
 * @author LIU Kunpeng  WeChat:13758206010
 * @version $Id: EnumBase.java, v 0.1 2017年10月12日 下午8:32:25 LIU Kunpeng Exp $
 */
public interface EnumBase {

    /**
     * 获取枚举名(建议与enumCode保持一致)
     *
     * @return
     */
    public String name();

    /**
     * 获取枚举消息
     *
     * @return
     */
    public String message();

}
