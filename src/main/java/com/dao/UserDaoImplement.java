package com.dao;


import com.entity.MyUser;
import com.util.DBconnect;

import java.lang.invoke.MutableCallSite;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImplement implements UserDao {
    public boolean login(String id, String pwd) {
        boolean flag = false;
        try {
            try {
                DBconnect.init();
            } catch (Exception e) {
                e.printStackTrace();
            }
            //注意查询语句中的单引号双引号
            ResultSet rs = DBconnect.selectSql("select * from student where id='" + id + " 'and pwd='" + pwd + "';");
            while (rs.next()) {
                if (rs.getString("id").equals(id) && rs.getString("pwd").equals(pwd)) {
                    flag = true;
                }
            }
            DBconnect.closeConn();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

    public boolean register(MyUser user) {
        boolean flag = false;
        try {
            DBconnect.init();
        } catch (Exception e) {
            e.printStackTrace();
        }
        int i = DBconnect.addUpdateDelete("insert into student(id,name,pwd) " +
                "values('" + user.getId() + "','" + user.getName() + "','" + user.getpwd() + " ' )");
        if (i > 0) {
            flag = true;
        }
        DBconnect.closeConn();
        return flag;
    }

    public List<MyUser> getUserAll() {//返回用户信息集合
        List<MyUser> list = new ArrayList<>();
        try {
            try {
                DBconnect.init();
            } catch (Exception e) {
                e.printStackTrace();
            }
            ResultSet rs = DBconnect.selectSql("select * from student");
            while (rs.next()) {
                String idone = rs.getString("id");
                String nameone = rs.getString("name");
                String pwdone = rs.getString("pwd");

                MyUser user = new MyUser(idone, nameone, pwdone);
                list.add(user);
            }
            DBconnect.closeConn();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public boolean delete(String id) {//根据id删除{
        boolean flag = false;
        try {
            DBconnect.init();
        } catch (Exception e) {
            e.printStackTrace();
        }
        String sql = "delete from student where id='" + id + "'";
        int i = DBconnect.addUpdateDelete(sql);//i的意义：
        if (i > 0) {
            flag = true;
        }
        DBconnect.closeConn();
        return flag;
    }

    public boolean update(String id, String name) {
        boolean flag = false;
        try {
            DBconnect.init();
        } catch (Exception e) {
            e.printStackTrace();
        }
        String sql = "update student set name ='" + name

                + "'" + "where id = '" + id + "'";

        int i = DBconnect.addUpdateDelete(sql);
        System.out.println("1" + " " + i);
        if (i > 0) {
            flag = true;
        }
        DBconnect.closeConn();
        return flag;
    }

}