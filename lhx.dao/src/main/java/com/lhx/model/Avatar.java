package com.lhx.model;

/**
 * Created by lhx on 15-7-21 上午9:40
 *
 * @Description
 */
public class Avatar {

    private long avatarsId ;
    private long accountId ;
    private String avatarsPath ;

    public long getAvatarsId() {
        return avatarsId;
    }

    public void setAvatarsId(long avatarsId) {
        this.avatarsId = avatarsId;
    }

    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    public String getAvatarsPath() {
        return avatarsPath;
    }

    public void setAvatarsPath(String avatarsPath) {
        this.avatarsPath = avatarsPath;
    }
}
