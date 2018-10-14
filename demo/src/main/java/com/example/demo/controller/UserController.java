package com.example.demo.controller;

import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Levin
 * @since 2018/6/28 0028
 */
@Controller
public class UserController {

    /**
     * RequiresRoles 是所需角色 包含 AND 和 OR 两种
     * RequiresPermissions 是所需权限 包含 AND 和 OR 两种
     *
     * @return msg
     */
    @RequiresRoles(value = {"admin", "test"}, logical = Logical.OR)
    @RequiresPermissions(value = {"user:list", "user:query"}, logical = Logical.OR)
    @RequestMapping("/users/query")
    public String query() {
        return "forward:/list";
    }


}