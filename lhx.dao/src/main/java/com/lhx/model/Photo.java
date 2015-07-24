package com.lhx.model;

import java.util.Date;

/**
 * Created by lhx on 15-7-21 上午9:38
 *
 * @Description
 */
public class Photo {

    private String path ; //图片存储路径
    private String property ; //图片的宽高大小等属性
    private Date createTime ; //图片上传日期
    private Date updateTime ; //图片修改日期
    private Long accountId ; //用户ID
    private Integer status = 1; //图片是否对外可见(0默认待审核，1显示)

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
