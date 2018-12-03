package com.learn.日志脱敏;

/**
 * @author xuejianjun<xuejianjun@corp.netease.com>
 * @since 2018/12/03 11:50 AM
 */
public class CardInfo {

    private String id;
    private String userId;
    private String name;
    @SensitiveInfo(type = SensitiveType.ID_CARD)
    private String certId;
    @SensitiveInfo(type = SensitiveType.BANK_CARD)
    private String cardId;
    private String bank;
    @SensitiveInfo(type = SensitiveType.PHONE)
    private String phone;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCertId() {
        return certId;
    }

    public void setCertId(String certId) {
        this.certId = certId;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
