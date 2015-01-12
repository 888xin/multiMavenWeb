package com.lhx.model;

/**
 * Created by lhx on 15-1-12 上午10:44
 *
 * @project multiMavenWeb
 * @package com.lhx.model
 * @Description
 * @blog http://blog.csdn.net/u011439289
 * @email 888xin@sina.com
 * @github https://github.com/888xin
 */
public class User {

    private int id;
    private int state;
    private String nickname;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getState() {
        return state;
    }
    public void setState(int state) {
        this.state = state;
    }
    public String getNickname() {
        return nickname;
    }
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
