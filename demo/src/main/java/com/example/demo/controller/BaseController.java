package com.example.demo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.example.demo.dao.UserMapper;
import com.example.demo.entity.Role;
import com.example.demo.entity.User;

import org.apache.shiro.authz.annotation.Logical;
// import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BaseController{

    // private int i=0;

    @Autowired    
    private UserMapper userMapper;

    @RequestMapping("/index")
    @RequiresPermissions(value = {"user:update", "user:query"}, logical = Logical.OR)
    public String index(){

        return "index";
    }
   
    @RequestMapping("/deleteAll")
    @ResponseBody
    public String deleteAll(){
        int n = userMapper.deleteAll();        
        return String.valueOf(n);
    }

    // @RequestMapping("/add")
    // @ResponseBody    
    // public String insert(){
    //     i++;
    //     User user = new User();
    //     user.setUsername("AA"+i);
    //     user.setPassword("A p"+i);
    //     int n = userMapper.insert(user);
    //     return String.valueOf(n);
    // }

    @RequestMapping("/list")
    public String list(HttpServletRequest request){
        List<User>  userList = userMapper.listUser();
        List<Role>  roleList = userMapper.listRoles();
        request.setAttribute("userList", userList);
        request.setAttribute("roleList", roleList);
        return "user/list";
    }
    
}