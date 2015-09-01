package com.lhx.model;

import java.io.Serializable;

/**
 * Created by lhx on 15-8-7 下午2:46
 *
 * @Description
 */
public class DashboardId implements Serializable {

    private Long dashboardId;

    public Long getDashboardId() {
        return dashboardId;
    }

    public void setDashboardId(Long dashboardId) {
        this.dashboardId = dashboardId;
    }
}
