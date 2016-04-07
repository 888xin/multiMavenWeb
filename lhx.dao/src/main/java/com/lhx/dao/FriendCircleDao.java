package com.lhx.dao;


import com.lhx.model.FriendCircle;

import java.util.List;

public interface FriendCircleDao {
    /**
     * 根据ids活得猜友圈记录(不包含押押)
     */
    public List<FriendCircle> getFriendCircleByIds(List<Long> circleIds, String client, Boolean hasContent);

    /**
     * 我的战绩(不包含押押)
     */
    public List<FriendCircle> getMyCircleByIds(Long userId, String client, Integer hasContent, int page, int limit);

    /**
     * 我的押押列表
     * 
     * @param userId
     * @param startId
     * @param limit
     * @return
     */
    public List<FriendCircle> getMyYayaCircle(Long userId, Long startId, int limit);

    public Integer insert(FriendCircle friendCircle);

    public FriendCircle findById(Long id);

    public Integer deleteById(Long id);


    /**
     * 更新内容附加字段
     */
    //public boolean updateFriendCircle(FriendCircle cont);

    //public List<FriendCircle> getInnerCircles(Long userId, String searchKey, Long startId, Long endId, Integer limit, Integer skip);
    public List<FriendCircle> getInnerCircles();

    public Integer getInnerCirclesNum(Long userId, String searchKey);

    /**
     * 根据contest来获取
     */
    public List<FriendCircle> findByContestId(Integer contestType, Long contestId);

    public Integer uploadParams(FriendCircle friendCircle);
}
