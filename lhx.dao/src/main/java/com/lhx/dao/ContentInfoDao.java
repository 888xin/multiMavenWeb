package com.lhx.dao;

import com.lhx.model.ContentInfo;

import java.util.List;
import java.util.Map;

public interface ContentInfoDao {

    /**
     * 写入内容
     * 
     * @param contentInfo
     * @return
     */
    public boolean insert(ContentInfo contentInfo);

    /**
     * 根据dashboardId查看内容
     * 
     * @param dashboardId
     * @return
     */
    public ContentInfo findByDashboardId(Long dashboardId);

    /**
     * 根据dashboardIds批量查询
     * @param dashboardIds
     * @return
     */
    public Map<Long, ContentInfo> findContentInfoMapByDashboardIds(List<Long> dashboardIds);
}
