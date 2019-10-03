package com.servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UserDao;
import com.dao.UserDaoImplement;
import com.entity.MyUser;

public class ShowAllServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=utf-8");
        UserDao ud = new UserDaoImplement();
        List<MyUser> userAll = ud.getUserAll();
        for (MyUser a : userAll) {
            System.out.println(a.getId() + a.getName() + a.getpwd());
        }
        request.setAttribute("all", userAll);
        request.getRequestDispatcher("showAll.jsp").forward(request, response);
    }
}