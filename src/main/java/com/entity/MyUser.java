package com.entity;

public class MyUser {
    private String id;
    private String name;
    private String pwd;

    public MyUser() {
    }

    public MyUser(String id, String name, String pwd) {
        this.name = name;
        this.pwd = pwd;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public MyUser(String id, String pwd) {
        this.id = id;
        this.pwd = pwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String username) {
        this.name = username;
    }

    public String getpwd() {
        return pwd;
    }

    public void setpwd(String pwd) {
        this.pwd = pwd;
    }
}
