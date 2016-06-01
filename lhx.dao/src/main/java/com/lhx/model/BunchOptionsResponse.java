package com.lhx.model;

/**
 * Created by lhx on 16-5-17 上午9:32
 *
 * @Description 串选项
 */
public class BunchOptionsResponse  {

    /**
     * 序号
     */
    private Integer index ;
    /**
     * 赔率
     */
    //private OddsOpResponse oddsOpResponse ;
    //private OddsJcResponse oddsJcResponse ;
    //private OddsSizeResponse oddsSizeResponse ;
    //private OddsDssResponse oddsDssResponse ;
    //private ContestResponse contestResponse;
    /**
     * 赛事ID
     */
    private Long contest_id ;

    /**
     * 赛事类型
     */
    private Integer contest_type ;

    /**
     * 赢方
     */
    private Integer win ;
    /**
     * 玩法
     */
    private Integer play_type ;

    /**
     * 支持方
     */
    private Integer support ;

    public Integer getSupport() {
        return support;
    }

    public void setSupport(Integer support) {
        this.support = support;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public Long getContest_id() {
        return contest_id;
    }

    public void setContest_id(Long contest_id) {
        this.contest_id = contest_id;
    }

    public Integer getContest_type() {
        return contest_type;
    }

    public void setContest_type(Integer contest_type) {
        this.contest_type = contest_type;
    }

    public Integer getWin() {
        return win;
    }

    public void setWin(Integer win) {
        this.win = win;
    }

    public Integer getPlay_type() {
        return play_type;
    }

    public void setPlay_type(Integer play_type) {
        this.play_type = play_type;
    }

}
