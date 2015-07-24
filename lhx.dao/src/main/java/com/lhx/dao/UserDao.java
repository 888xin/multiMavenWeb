package com.lhx.dao;

import com.lhx.model.User;

/**
 * Created by lhx on 15-1-12 上午10:45
 *
 * @project multiMavenWeb
 * @package com.lhx.dao
 * @Description
 * @blog http://blog.csdn.net/u011439289
 * @email 888xin@sina.com
 * @github https://github.com/888xin
 */
public interface UserDao {

    /**
     * 添加新用户
     * @param user
     * @return
     */
    public int insertUser(User user);

    /**
     * 添加用户，返回主键
     * @param user
     * @return
     */
    public int insertUserBackID(User user);

    /**
     * 根据id获得用户
     * @param id
     * @return
     */
    public User getUser(int id);
}
