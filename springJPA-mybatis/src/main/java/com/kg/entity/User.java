/**   
 * Copyright © 2019  All rights reserved.
 * 
 * @Package: com.kg.entity
 * @author: xp023396
 * @CreateDate: Jan 9, 2019 10:38:17 AM
 */

package com.kg.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.alibaba.druid.support.json.JSONUtils;

/**
 * @ClassName: User
 * @Description: TODO
 * @author: xp023396
 * @date: Jan 9, 2019 10:38:17 AM
 */

@Entity
@Table(name = "p_user")
public class User {

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "user_name")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "address")
    private String address;

    @Column(name = "email")
    private String email;

    @Column(name = "age")
    private int age;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    
}
