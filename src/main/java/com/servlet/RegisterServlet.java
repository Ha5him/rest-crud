package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.text.*;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UserDao;
import com.dao.UserDaoImplement;
import com.entity.MyUser;

public class RegisterServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name"); //获取jsp页面传过来的参数
        String pwd = request.getParameter("pwd");
        String id = request.getParameter("id");

        MyUser user = new MyUser(); //实例化一个对象，组装属性
        user.setId(id);
        user.setName(name);
        user.setpwd(pwd);

        UserDao ud = new UserDaoImplement();
        if (ud.register(user)) {
            request.setAttribute("name", name);  //向request域中放置参数
            request.getRequestDispatcher("/login.jsp").forward(request, response);  //转发到登录页面
        } else {
            response.sendRedirect("register.jsp");//注册失败则返回注册页面，但是缺少提示"注册失败"
        }
    }
}