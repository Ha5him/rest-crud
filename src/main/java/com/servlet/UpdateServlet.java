package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UserDao;
import com.dao.UserDaoImplement;
import com.entity.MyUser;

public class UpdateServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String id = request.getParameter("id");

        String name = request.getParameter("name"); //获取jsp页面传过来的参数

        UserDao ud = new UserDaoImplement();

        System.out.println(id + name);
        if (ud.update(id, name)) {
            request.getRequestDispatcher("/addUpdateDeleteSuccess.jsp").forward(request, response);
        } else {
            response.sendRedirect("addUpdateDeleteFail.jsp");
        }
    }
}
