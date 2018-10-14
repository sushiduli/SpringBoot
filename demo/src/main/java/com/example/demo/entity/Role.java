package com.example.demo.entity;

import java.util.Collection;

/**
 * Role
 */
public class Role {

    private String roleName;
    private Collection<String> permissions;

    public String getRoleName() {
        return this.roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Collection<String> getPermissions() {
        return this.permissions;
    }

    public void setPermissions(Collection<String> permissions) {
        this.permissions = permissions;
    }
}