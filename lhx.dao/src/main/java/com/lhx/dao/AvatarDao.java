package com.lhx.dao;

import com.lhx.model.Avatar;

import java.util.List;
import java.util.Map;

/**
 * Created by lhx on 15-7-21 上午9:40
 *
 * @Description
 */
public interface AvatarDao {


    public List<Avatar> getAvatar(Map<String,Integer> map);

    public List<Avatar> getAvatar2(Map<String,Object> map);
}
