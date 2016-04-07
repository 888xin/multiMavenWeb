package com.lhx.dao;

import com.lhx.model.Dashboard;

import java.util.List;
import java.util.Map;

/**
 * Created by lhx on 15-9-1 下午5:42
 *
 * @Description
 */
public interface DashboardDao {

    public List<Dashboard> getDashboards(Map<String,Integer> map);

}
