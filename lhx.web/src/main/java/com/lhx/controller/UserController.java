package com.lhx.controller;

import com.lhx.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by lhx on 14-12-22 下午3:08
 *
 * @project springmybatis
 * @package cn.springmvc.controller
 * @blog http://blog.csdn.net/u011439289
 * @email 888xin@sina.com
 * @Description
 */
@Controller
@RequestMapping("/")
public class UserController {

    @Autowired
    private UserDao userDao ;

    @RequestMapping("/main")
    public String index(){
        return "main";
    }

    @RequestMapping("/show")
    public ModelAndView showUser(){
        ModelAndView  modelAndView = new ModelAndView();
        modelAndView.addObject("user",userDao.getUser(2));
        modelAndView.setViewName("show");
        return modelAndView ;
    }

}
