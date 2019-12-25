package com.中间件.hbase.mode;

import com.中间件.hbase.annotation.HbaseField;
import com.中间件.hbase.annotation.HbaseQueryField;
import com.中间件.hbase.constant.HbaseFieldformatEnum;
import com.中间件.hbase.constant.HbaseQueryFieldTypeEnum;
import com.中间件.hbase.constant.HbaseTableEnum;
import com.中间件.hbase.converter.Converter;
import com.中间件.hbase.converter.DefaultConverter;
import com.中间件.hbase.query.HbaseQuery;
import com.中间件.hbase.utils.HbaseEntryUtils;
import com.中间件.hbase.utils.PageQuery;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.apache.hadoop.hbase.filter.*;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 线索数据查询 【ClueQuery】
 * =====================使用规则============================
 * <p>
 * 1.如果需要分页 请自行实现  getPageFilter
 * 2.新添加查询字段， 需要 添加 注解 HbaseField，HbaseQueryField;
 * 3.查询字段 如需支持多值 多值直接 or 关系，且不支持 null 值，
 * 4.查询字段 如需支持多值 字段数据类型 只能是 List<T>
 * <p>
 * =====================使用规则============================
 *
 * @date 2019/7/11 18:11
 */
@Getter
@Setter
@Slf4j
public class ClueQuery implements HbaseQuery {

    public ClueQuery() {
        try {
            setDefaultValue();
        } catch (Exception e) {
            log.error("ClueQuery setDefaultValue error", e);
        }
    }


    private PageQuery page = new PageQuery();

    /**
     * 用户OUID
     */
    @HbaseField(fieldName = "rowKey")
    @HbaseQueryField(fieldType = HbaseQueryFieldTypeEnum.ROW_KEY_LIST, comparator = BinaryComparator.class)
    private List<String> rowKeyList;

    @HbaseField(fieldName = "data_id", classz = String.class)
    @HbaseQueryField(fieldType = HbaseQueryFieldTypeEnum.LIST, comparator = BinaryComparator.class)
    private List<String> dataId;

    /**
     * 线索名称模糊查询
     */
    @HbaseField(fieldName = "clue_name")
    @HbaseQueryField(comparator = SubstringComparator.class)
    private String clueName;

    /**
     * 线索名称精确匹配
     */
    @HbaseField(fieldName = "clue_name")
    @HbaseQueryField(comparator = BinaryComparator.class)
    private String fullClueName;
    /**
     * 线索类型 企业 个人
     */
    @HbaseField(fieldName = "clue_type", classz = Byte.class)
    @HbaseQueryField(comparator = BinaryComparator.class)
    private Byte clueType;

    /**
     * 用户OUID
     */
    @HbaseField(fieldName = "ouid")
    @HbaseQueryField(fieldType = HbaseQueryFieldTypeEnum.LIST, comparator = BinaryComparator.class)
    private List<String> ouid;

    /**
     * 用户GUID
     */
    @HbaseField(fieldName = "guid")
    @HbaseQueryField(comparator = BinaryComparator.class)
    private String guid;

    /**
     * 来源动作ID
     */
    @HbaseField(fieldName = "source_id", classz = Long.class)
    @HbaseQueryField(comparator = BinaryComparator.class)
    private Long sourceId;

    /**
     * 来源类型
     */
    @HbaseField(fieldName = "source_type", classz = Byte.class)
    @HbaseQueryField(fieldType = HbaseQueryFieldTypeEnum.LIST,comparator = BinaryComparator.class)
    private List<Byte> sourceType;

    @HbaseField(fieldName = "source_type", classz = byte.class)
    @HbaseQueryField(fieldType = HbaseQueryFieldTypeEnum.LIST,comparator = NullComparator.class)
    private List<Byte> sourceTypeNull;

    /**
     * 来源动作
     */
    @HbaseField(fieldName = "source_action", classz = Byte.class)
    @HbaseQueryField(fieldType = HbaseQueryFieldTypeEnum.LIST, comparator = BinaryComparator.class)
    private List<Byte> sourceAction;

    /**
     * 来源详情
     */
    @HbaseField(fieldName = "source_detail")
    @HbaseQueryField(comparator = SubstringComparator.class)
    private String sourceDetail;

    /**
     * 来源详情名称
     */
    @HbaseField(fieldName = "source_detail_info_name")
    @HbaseQueryField(comparator = SubstringComparator.class)
    private String sourceDetailInfoName;

    /**
     * 来源平台类型(产品端)
     */
    @HbaseField(fieldName = "source_platform_type", classz = Byte.class)
    @HbaseQueryField(fieldType = HbaseQueryFieldTypeEnum.LIST,comparator = BinaryComparator.class)
    private List<Byte> sourcePlatformType;

    /**
     * 来源渠道:$latest_utm_source
     */
    @HbaseField(fieldName = "source_channel")
    @HbaseQueryField(fieldType = HbaseQueryFieldTypeEnum.LIST,comparator = BinaryComparator.class)
    private List<String> sourceChannel;

    /**
     * 线索进程
     */
    @HbaseField(fieldName = "clue_Process", classz = Byte.class)
    @HbaseQueryField(fieldType = HbaseQueryFieldTypeEnum.LIST,comparator = BinaryComparator.class)
    private List<Byte> clueProcess;

    /**
     * 证件类型
     */
    @HbaseField(fieldName = "certificate_type")
    @HbaseQueryField(comparator = BinaryComparator.class)
    private String certificateType;

    /**
     * 证件号码
     */
    @HbaseField(fieldName = "certificate_no")
    @HbaseQueryField(comparator = BinaryComparator.class)
    private String certificateNo;

    /**
     * 归属状态 已认领/未认领/人工转出/系统转出/人工作废/系统作废
     */
    @HbaseField(fieldName = "clue_status", classz = Byte.class)
    @HbaseQueryField(fieldType = HbaseQueryFieldTypeEnum.LIST, comparator = BinaryComparator.class)
    private List<Byte> clueStatus;

    /**
     * 创建人
     */
    @HbaseField(fieldName = "create_man")
    @HbaseQueryField(comparator = SubstringComparator.class)
    private String createMan;

    /**
     * 创建人AccountId
     */
    @HbaseField(fieldName = "create_man_id")
    @HbaseQueryField(comparator = BinaryComparator.class)
    private String createManId;

    /**
     * 跟进时间 TODO
     */
    @HbaseField(fieldName = "follow_date", classz = LocalDateTime.class, format = HbaseFieldformatEnum.DEFAULT_DATE_FORMAT)
    @HbaseQueryField(fieldType = HbaseQueryFieldTypeEnum.RANGE, comparator = BinaryComparator.class, rangeCompareOp = {CompareFilter.CompareOp.GREATER_OR_EQUAL, CompareFilter.CompareOp.LESS_OR_EQUAL})
    private DateRange followDate;

    /**
     * 认领时间 TODO
     */
    @HbaseField(fieldName = "claim_Date", classz = LocalDateTime.class, format = HbaseFieldformatEnum.DEFAULT_DATE_FORMAT)
    @HbaseQueryField(fieldType = HbaseQueryFieldTypeEnum.RANGE, comparator = BinaryComparator.class, rangeCompareOp = {CompareFilter.CompareOp.GREATER_OR_EQUAL, CompareFilter.CompareOp.LESS_OR_EQUAL})
    private DateRange claimDate;

    /**
     * 修改时间 TODO
     */
    @HbaseField(fieldName = "modify_date", classz = LocalDateTime.class, format = HbaseFieldformatEnum.DEFAULT_DATE_FORMAT)
    @HbaseQueryField(fieldType = HbaseQueryFieldTypeEnum.RANGE, comparator = BinaryComparator.class, rangeCompareOp = {CompareFilter.CompareOp.GREATER_OR_EQUAL, CompareFilter.CompareOp.LESS_OR_EQUAL})
    private DateRange modifiedDate;


    /**
     * 跟进状态
     */
    @HbaseField(fieldName = "follow_status", classz = Byte.class)
    @HbaseQueryField(fieldType = HbaseQueryFieldTypeEnum.LIST, comparator = BinaryComparator.class)
    private List<Byte> followStatus;

    /**
     * 下次跟进时间
     */
    @HbaseField(fieldName = "follow_next_date", classz = LocalDateTime.class, format = HbaseFieldformatEnum.DEFAULT_DATE_FORMAT)
    @HbaseQueryField(fieldType = HbaseQueryFieldTypeEnum.RANGE, comparator = BinaryComparator.class, rangeCompareOp = {CompareFilter.CompareOp.GREATER_OR_EQUAL, CompareFilter.CompareOp.LESS_OR_EQUAL})
    private DateRange followNextDate;


    /**
     * 负责人AccountId
     */
    @HbaseField(fieldName = "owner_id")
    @HbaseQueryField(
            fieldType = HbaseQueryFieldTypeEnum.LIST,
            comparator = BinaryComparator.class)
    private List<String> ownerId;

    @HbaseField(fieldName = "owner_id")
    @HbaseQueryField(
            compareOp = CompareFilter.CompareOp.NOT_EQUAL,
            comparator = BinaryComparator.class)
    private String excludeOwnerId;

    /**
     * 主联系人ID
     */
    @HbaseField(fieldName = "main_contact_id", classz = Long.class)
    @HbaseQueryField(comparator = BinaryComparator.class)
    private Long mainContactId;

    /**
     * 转化的客户ID
     */
    @HbaseField(fieldName = "custom_id", classz = Long.class)
    @HbaseQueryField(comparator = BinaryComparator.class)
    private Long customId;

    /**
     * 转客户时间开始
     */
    @HbaseField(fieldName = "convertDate", classz = LocalDateTime.class, format = HbaseFieldformatEnum.DEFAULT_DATE_FORMAT)
    @HbaseQueryField(fieldType = HbaseQueryFieldTypeEnum.RANGE, comparator = BinaryComparator.class, rangeCompareOp = { CompareFilter.CompareOp.GREATER_OR_EQUAL,CompareFilter.CompareOp.LESS_OR_EQUAL})
    private DateRange convertDate;

    /**
     * 线索等级
     */
    @HbaseField(fieldName = "clue_level")
    @HbaseQueryField(fieldType = HbaseQueryFieldTypeEnum.LIST,comparator = BinaryComparator.class)
    private List<String> clueLevel;

    /**
     * 意向产品
     */
    @HbaseField(fieldName = "product_intention",classz = Byte.class)
    @HbaseQueryField(fieldType = HbaseQueryFieldTypeEnum.LIST,comparator = BinaryComparator.class)
    private List<Byte> productIntention;
    /**
     * 省
     */
    @HbaseField(fieldName = "province")
    @HbaseQueryField(comparator = BinaryComparator.class)
    private String province;
    /**
     * 市
     */
    @HbaseField(fieldName = "city")
    @HbaseQueryField(comparator = BinaryComparator.class)
    private String city;

    @HbaseField(fieldName = "industry")
    @HbaseQueryField(comparator = BinaryComparator.class)
    private String industry;

    private Converter converter = new DefaultConverter();

    @Override
    public Converter getConverter() {
        return converter;
    }

    /**
     * 默认值设置
     *
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     */
    @Override
    public void setDefaultValue() throws IllegalArgumentException, IllegalAccessException {
        if (this.getPage() == null) {
            this.setPage(new PageQuery());
        }
        this.getPage().setDefaultValue();
        HbaseEntryUtils.setDefaultValue(this);

    }

    @Override
    public String getStartRow() {
        return getPage().getStartRowKey();
    }

    @Override
    public String getStopRow() {
        return getPage().getStopRowKey();
    }

    @Override
    public String getFamilyName() {
        return HbaseTableEnum.TABLE_CLUE_INFO.getFamilyName();
    }

    @Override
    public PageFilter getPageFilter() {
        return new PageFilter(getPage().getPageSize());
    }
}
