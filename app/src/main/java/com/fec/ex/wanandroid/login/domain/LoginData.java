package com.fec.ex.wanandroid.login.domain;

import java.util.List;

/**
 * Created by Fe2Cu on 06.29.2018
 * github: https://www.github.com/fectong
 * Email : fectong@live.com
 */
public class LoginData {

    private String username;
    private String password;
    private String email;
    private String icon;
    private int id;
    private int type;
    private List<?> collectIds;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public List<?> getCollectIds() {
        return collectIds;
    }

    public void setCollectIds(List<?> collectIds) {
        this.collectIds = collectIds;
    }
}
