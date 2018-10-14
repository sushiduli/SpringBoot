package com.example.demo.dao;

import java.util.List;

import com.example.demo.entity.Role;
import com.example.demo.entity.User;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper{

    int insert(User user);
    User selectUserByName(String username);
    List<User> listUser();
    int deleteAll();
    List<Role> listRoles();

}