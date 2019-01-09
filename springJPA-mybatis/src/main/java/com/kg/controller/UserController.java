/**   
 * Copyright © 2019  All rights reserved.
 * 
 * @Package: com.kg.controller
 * @author: xp023396
 * @CreateDate: Jan 9, 2019 11:00:25 AM
 */

package com.kg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.kg.dao.jpa.UserJPA;
import com.kg.dao.mapper.UserMapper;
import com.kg.entity.User;

/**
 * @ClassName: UserController
 * @Description: TODO
 * @author: xp023396
 * @date: Jan 9, 2019 11:00:25 AM
 */

@Controller
public class UserController {

    @Autowired
    private UserJPA userJPA;

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/jpa/all")
    @ResponseBody
    public String JPA2GetAll() {
        List<User> lu = userJPA.findAll();
        return JSON.toJSONString(lu);
    }

    @RequestMapping("/mybatis/all")
    @ResponseBody
    public String mybatis2GetAll() {
        List<User> lu = userMapper.getList();
        return JSON.toJSONString(lu);
    }

}
