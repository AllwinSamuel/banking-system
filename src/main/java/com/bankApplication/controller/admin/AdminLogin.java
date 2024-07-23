package com.bankApplication.controller.admin;

import java.io.IOException;

import com.bankApplication.dao.AdminDao;
import com.bankApplication.model.Admin;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class AdminLogin extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String password = request.getParameter("password");

        Admin admin = new Admin();
        admin.setUsername(name);
        admin.setPassword(password);

        boolean logged = AdminDao.adminLogin(admin);
        RequestDispatcher dispatcher;

        if (logged) {
            HttpSession session = request.getSession();
            session.setAttribute("adminId", "admin");
            dispatcher = request.getRequestDispatcher("dashboard.jsp");
            
        } else {
            request.setAttribute("status", "failed");
            dispatcher = request.getRequestDispatcher("login.jsp");
        }

        dispatcher.forward(request, response);
    }
}