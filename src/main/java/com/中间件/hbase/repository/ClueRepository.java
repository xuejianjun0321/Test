package com.中间件.hbase.repository;


import com.中间件.hbase.mode.ClueQuery;
import com.中间件.hbase.mode.HbasePageResult;
import com.中间件.hbase.repository.entity.Clue;

import java.util.List;
import java.util.function.Function;

/**
 * clue 底层存储类
 */
public interface ClueRepository {

    String UPDATE_CLUE_LOCK_KEY = "CRM_CLUE_UPDATE_CLUE";

    /**
     * 根据联系人id查询是否存在相关的个人线索
     *
     * @param clue
     * @return select count(1) from clue clue where clue.contact_id = #{contactId} and clue.clue_type = #{clueType}
     */
    Clue insertClue(Clue clue);

    /**
     * 如果有rowKey，优先以rowKey更新数据，如果找不到，以dataId更新数据，还找不到，返回异常rowKey和dataId参数
     *
     * @date 2019/8/13 15:17
     * @param rowKey
     * @param updateFunction
     * @return
     */
    Clue updateClue(String rowKey, Function<Clue, Clue> updateFunction);

    /**
     * 根据线索id 更新线索
     *
     * @param dataId
     * @param updateFunction
     * @return Clue
     */
    Clue updateClueByDataId(String dataId, Function<Clue, Clue> updateFunction);

    /**
     * 分页查询线索
     *
     * @param clueQuery 查询线索查询条件
     * @return
     */
    @Deprecated
    HbasePageResult<Clue> selectClueList(ClueQuery clueQuery);

    /**
     * Clue
     * @param rowKey
     * @return
     */
    Clue findByRowKey(String rowKey);

    /**
     * findByRowKeys
     * @param idList
     * @return
     */
    List<Clue> findByRowKeys(List<String> idList);

    /**
     * removeClue
     * @param clueId
     */
    void removeClue(List<String> clueId);

    /**
     * findByOuid
     * @param ouidList
     * @return
     */
    List<Clue> findByOuid(List<String> ouidList);

    /**
     * dataId查询线索
     *
     * @param dataId
     * @return
     * @author shoujing
     * @Date 2018/12/28 15:29
     */
    Clue findByDataId(String dataId);

    /**
     * 查询所有的线索
     *
     * @param clueQuery
     * @return
     */
    List<Clue> findAll(ClueQuery clueQuery);

}
