package com.lhx.model;

import java.io.Serializable;
import java.util.Date;

public class FriendCircle implements Serializable {

    /**
     * 主键id
     */
    private Long id;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 源内容id
     */
    private Long sourceId = 0L;

    /**
     * 源作者id
     */
    private Long sourceUserId = 0L;

    /**
     * 类型（心情|推荐）
     */
    private Integer type;

    /**
     * 内容
     */
    private String content;

    /**
     * 扩展字段
     */
    private String params;

    /**
     * 比赛id
     */
    private Long contestId;

    /**
     * 比赛类型
     */
    private Integer contestType;

    /**
     * 客户端标识
     */
    private String client;

    /**
     * 删除标志位
     */
    private Boolean deleteFlag;

    /**
     * 发表时间
     */
    private Date createTime;

    /**
     * 是否包含爆料内容(有音频，图片，文字三者其一即为true)
     */
    private Boolean hasContent;

    /**
     * 龙筹券
     */
    private Integer coupon;

    public FriendCircle() {
	super();
    }

    public FriendCircle(Long id, Long userId, Long sourceId, Long sourceUserId, Integer type, String content, String params,
                        Long contestId, Integer contestType, String client, Boolean deleteFlag, Date createTime, Boolean hasContent) {
	super();
	this.id = id;
	this.userId = userId;
	this.sourceId = sourceId;
	this.sourceUserId = sourceUserId;
	this.type = type;
	this.content = content;
	this.params = params;
	this.contestId = contestId;
	this.contestType = contestType;
	this.client = client;
	this.deleteFlag = deleteFlag;
	this.createTime = createTime;
	this.hasContent = hasContent;
    }

    public Integer getCoupon() {
	return coupon;
    }

    public void setCoupon(Integer coupon) {
	this.coupon = coupon;
    }

    public Long getUserId() {
	return userId;
    }

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public void setUserId(Long userId) {
	this.userId = userId;
    }

    public Long getSourceId() {
	return sourceId;
    }

    public void setSourceId(Long sourceId) {
	this.sourceId = sourceId;
    }

    public Long getSourceUserId() {
	return sourceUserId;
    }

    public void setSourceUserId(Long sourceUserId) {
	this.sourceUserId = sourceUserId;
    }

    public Integer getType() {
	return type;
    }

    public void setType(Integer type) {
	this.type = type;
    }

    public String getContent() {
	return content;
    }

    public void setContent(String content) {
	this.content = content;
    }

    public String getParams() {
	return params;
    }

    public void setParams(String params) {
	this.params = params;
    }

    public Long getContestId() {
	return contestId;
    }

    public void setContestId(Long contestId) {
	this.contestId = contestId;
    }

    public Integer getContestType() {
	return contestType;
    }

    public void setContestType(Integer contestType) {
	this.contestType = contestType;
    }

    public String getClient() {
	return client;
    }

    public void setClient(String client) {
	this.client = client;
    }

    public Boolean getDeleteFlag() {
	return deleteFlag;
    }

    public void setDeleteFlag(Boolean deleteFlag) {
	this.deleteFlag = deleteFlag;
    }

    public Date getCreateTime() {
	return createTime;
    }

    public void setCreateTime(Date createTime) {
	this.createTime = createTime;
    }

    public Boolean getHasContent() {
	return this.hasContent;
    }

    public void setHasContent(Boolean hasContent) {
	this.hasContent = hasContent;
    }

}
