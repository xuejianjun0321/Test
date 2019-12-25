package com.中间件.hbase.repository.entity;

import com.中间件.hbase.annotation.HbaseField;
import com.中间件.hbase.constant.HbaseFieldDefaultValueEnum;
import com.中间件.hbase.constant.HbaseFieldformatEnum;
import com.中间件.hbase.converter.Converter;
import com.中间件.hbase.converter.DefaultConverter;
import com.中间件.hbase.entry.HbaseRowEntry;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
/**
        * 线索数据对象
        *

        * @date 2019/7/11 18:11
        */
@Getter
@Setter
@Slf4j
@ToString
public class Clue implements HbaseRowEntry {

    public Clue() {
        try {
            setDefaultValue();
        } catch (Exception e) {
            log.error("setDefaultValue error", e);
        }
    }

    @HbaseField(fieldName = "is_deleted", classz = Boolean.class,
            defaultValue = HbaseFieldDefaultValueEnum.BOOLEN_VALUE)
    private Boolean isDeleted;

    @HbaseField(fieldName = "create_date", classz = LocalDateTime.class,
            format = HbaseFieldformatEnum.DEFAULT_DATE_FORMAT,
            defaultValue = HbaseFieldDefaultValueEnum.DEFAULT_DATE)
    private LocalDateTime createDate;

    @HbaseField(fieldName = "modify_date", classz = LocalDateTime.class,
            format = HbaseFieldformatEnum.DEFAULT_DATE_FORMAT,
            defaultValue = HbaseFieldDefaultValueEnum.DEFAULT_DATE)
    private LocalDateTime modifyDate;

    @HbaseField(fieldName = "claim_Date", classz = LocalDateTime.class,
            format = HbaseFieldformatEnum.DEFAULT_DATE_FORMAT,
            defaultValue = HbaseFieldDefaultValueEnum.DEFAULT_DATE)
    private LocalDateTime claimDate;



    /**
     * 线索名称
     */
    @HbaseField(fieldName = "clue_name",
            defaultValue = HbaseFieldDefaultValueEnum.STRING_VALUE)
    private String clueName;

    /**
     * 线索类型 企业 个人
     */
    @HbaseField(fieldName = "clue_type", classz = Byte.class)
    private Byte clueType;

    /**
     * 用户OUID
     */
    @HbaseField(fieldName = "ouid",
            defaultValue = HbaseFieldDefaultValueEnum.STRING_VALUE)
    private String ouid;

    /**
     * 用户GUID
     */
    @HbaseField(fieldName = "guid",
            defaultValue = HbaseFieldDefaultValueEnum.STRING_VALUE)
    private String guid;

    /**
     * 来源动作ID
     */
    @HbaseField(fieldName = "source_id", classz = Long.class)
    private Long sourceId;

    /**
     * 来源类型
     */
    @HbaseField(fieldName = "source_type", classz = Byte.class)
    private Byte sourceType;

    /**
     * 来源动作
     */
    @HbaseField(fieldName = "source_action", classz = Byte.class)
    private Byte sourceAction;

    /**
     * 来源详情
     */
    @HbaseField(fieldName = "source_detail")
    private String sourceDetail;

    /**
     * 来源详情名称
     */
    @HbaseField(fieldName = "source_detail_info_name")
    private String sourceDetailInfoName;
    /**
     * 来源平台类型(产品端)
     */
    @HbaseField(fieldName = "source_platform_type", classz = Byte.class)
    private Byte sourcePlatformType;

    /**
     * 来源渠道:$latest_utm_source
     */
    @HbaseField(fieldName = "source_channel")
    private String sourceChannel;

    /**
     * 线索进程
     */
    @HbaseField(fieldName = "clue_Process", classz = Byte.class,
            defaultValue = HbaseFieldDefaultValueEnum.BYTE_VALUE)
    private Byte clueProcess;

    /**
     * 证件类型
     */
    @HbaseField(fieldName = "certificate_type",
            defaultValue = HbaseFieldDefaultValueEnum.STRING_VALUE)
    private String certificateType;

    /**
     * 证件号码
     */
    @HbaseField(fieldName = "certificate_no",
            defaultValue = HbaseFieldDefaultValueEnum.STRING_VALUE)
    private String certificateNo;

    /**
     * 归属状态 已认领/未认领/人工转出/系统转出/人工作废/系统作废
     */
    @HbaseField(fieldName = "clue_status", classz = Byte.class,
            defaultValue = HbaseFieldDefaultValueEnum.BYTE_VALUE)
    private Byte clueStatus;

    /**
     * 创建人
     */
    @HbaseField(fieldName = "create_man")
    private String createMan;

    /**
     * 创建人AccountId
     */
    @HbaseField(fieldName = "create_man_id")
    private String createManId;

    /**
     * 跟进时间
     */
    @HbaseField(fieldName = "follow_date", classz = LocalDateTime.class,
            format = HbaseFieldformatEnum.DEFAULT_DATE_FORMAT)
    private LocalDateTime followDate;

    /**
     * 跟进状态
     */
    @HbaseField(fieldName = "follow_status", classz = Byte.class)
    private Byte followStatus;

    /**
     * 下次跟进时间
     */
    @HbaseField(fieldName = "follow_next_date", classz = LocalDateTime.class, format = HbaseFieldformatEnum.DEFAULT_DATE_FORMAT)
    private LocalDateTime followNextDate;

    /**
     * 负责人
     */
    @HbaseField(fieldName = "owner",
            defaultValue = HbaseFieldDefaultValueEnum.STRING_VALUE)
    private String owner;

    /**
     * 负责人AccountId
     */
    @HbaseField(fieldName = "owner_id",
            defaultValue = HbaseFieldDefaultValueEnum.STRING_VALUE)
    private String ownerId;

    /**
     * 主联系人ID
     */
    @HbaseField(fieldName = "main_contact_id", classz = Long.class)
    private Long mainContactId;

    /**
     * 转化的客户ID
     */
    @HbaseField(fieldName = "custom_id", classz = Long.class)
    private Long customId;

    /**
     * 转客户时间
     */
    @HbaseField(fieldName = "convertDate", classz = LocalDateTime.class, format = HbaseFieldformatEnum.DEFAULT_DATE_FORMAT)
    private LocalDateTime convertDate;

    /**
     * 线索等级
     */
    @HbaseField(fieldName = "clue_level")
    private String clueLevel;

    /**
     * 意向产品
     */
    @HbaseField(fieldName = "product_intention", classz = Byte.class, defaultValue = HbaseFieldDefaultValueEnum.DEFAULT_PRODUCT_INTENTION)
    private Byte productIntention;

    @HbaseField(fieldName = "province")
    private String province;

    @HbaseField(fieldName = "city")
    private String city;

    /** 地址是否手动修改 */
    @HbaseField(fieldName = "is_modify_addr", classz = Byte.class,
            defaultValue = HbaseFieldDefaultValueEnum.BYTE_VALUE)
    private Byte isModifyAddr;


    @HbaseField(fieldName = "industry")
    private String industry;

    private Converter converter = new DefaultConverter();

    /**主键ID**/
    @Setter
    private String rowKey;

    @Override
    public String getRowKey() {
        if(rowKey == null) {
            rowKey = ClueUtils.buildRowKeyByDataId("");
        }
        return rowKey;
    }

    @Override
    public Converter getConverter() {
        return converter;
    }
}
