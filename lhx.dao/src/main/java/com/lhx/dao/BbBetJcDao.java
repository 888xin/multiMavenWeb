package com.lhx.dao;


import com.lhx.model.BetJc;

public interface BbBetJcDao {

    public BetJc selectById(long id);

//    public Long insertAndGetPrimaryKey(BetJc entity);
//
//    /**
//     * 查询单个玩法单方下注记录
//     *
//     * @param contestId
//     * @param userId
//     * @param suport
//     * @return
//     */
//    public BetJc selectByBet(Long contestId, Long userId, int support);
//
//    /**
//     * 查询下注记录
//     *
//     * @param contestId
//     * @param userId
//     * @param start
//     * @param limit
//     * @return
//     */
//    public List<BetJc> findBbBetJc(Long contestId, Long userId, boolean settle, Long startId, int limit);
//
//    /**
//     * 更新内容id
//     *
//     * @param entity
//     * @return
//     */
//    public boolean updateContentId(BetJc entity);
//
//    /**
//     * 更新结算
//     *
//     * @param bId
//     * @param back
//     * @param status
//     * @return
//     */
//    public boolean updateSettle(Long bId, Double back, Integer status);
//
//    /**
//     * 根据id更新contentId
//     *
//     * @param contentId
//     * @param bId
//     * @return
//     */
//    public boolean updateContentIdById(Long contentId, Integer bId);
//
//    /**
//     * 查询让球胜平负下注记录（后台用）
//     *
//     * @param contestId
//     * @param userId
//     * @param settle
//     * @param startId
//     * @param limit
//     * @param startTime
//     * @param endTime
//     * @return
//     */
//    public List<BetJc> findBbBetJcList(Long contestId, Long userId, boolean settle, Long startId, int limit, Date startTime,
//                                       Date endTime);
//
//
//    /**
//     * add by lhx on 16-03-02
//     * 根据Id来删除记录
//     */
//    public boolean deleteById(Long id);
//
//    /**
//     * add by lhx on 16-03-14
//     * 根据contestId来查询记录
//     */
//    public List<BetJc> findFbBetJcByContestId(Long contestId, Long startId, Integer limit);
}