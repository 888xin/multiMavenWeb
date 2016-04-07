package com.lhx.model;

import java.util.Date;

/**
 * Created by lhx on 15-9-9 上午9:26
 *
 * @Description
 */
public class ContentInfo {

    /**
     * 内容ID
     */
    private Long contentId;

    /**
     * 用户ID
     */
    private Long accountId;

    /**
     * 飞鸽ID
     */
    private Long dashboardId;

    /**
     * 内容标题
     */
    private String title;

    /**
     * 内容
     */
    private String content;

    /**
     * 内容中包含的图片以逗号分割
     */
    private String images;

    /**
     * 0普通内容,1秘密,2我擦
     */
    private Integer contentType;

    /**
     * 内容对应参数
     */
    private String contentParams;

    /**
     * 纬度
     */
    private Double lat;

    /**
     * 经度
     */
    private Double lng;

    /**
     * 内容地理位置信息
     */
    private String localName;

    /**
     * 创建时间
     */
    private Date createTime;

    public ContentInfo() {
        super();
    }

    public ContentInfo(Long accountId, Long dashboardId, String title, String content, String images,
                       Integer contentType, String contentParams, Double lat, Double lng, String localName, Date createTime) {
        super();
        this.accountId = accountId;
        this.dashboardId = dashboardId;
        this.title = title;
        this.content = content;
        this.images = images;
        this.contentType = contentType;
        this.contentParams = contentParams;
        this.lat = lat;
        this.lng = lng;
        this.localName = localName;
        this.createTime = createTime;
    }

    public Long getContentId() {
        return contentId;
    }

    public void setContentId(Long contentId) {
        this.contentId = contentId;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Long getDashboardId() {
        return dashboardId;
    }

    public void setDashboardId(Long dashboardId) {
        this.dashboardId = dashboardId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public Integer getContentType() {
        return contentType;
    }

    public void setContentType(Integer contentType) {
        this.contentType = contentType;
    }

    public String getContentParams() {
        return contentParams;
    }

    public void setContentParams(String contentParams) {
        this.contentParams = contentParams;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public String getLocalName() {
        return localName;
    }

    public void setLocalName(String localName) {
        this.localName = localName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
