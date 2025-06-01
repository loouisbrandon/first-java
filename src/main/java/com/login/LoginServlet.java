package com.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private LoginService loginService = new LoginService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        boolean success = loginService.authenticate(username, password);

        response.setContentType("text/html");
        if (success) {
            response.getWriter().println("<h1>Login bem-sucedido!</h1>");
        } else {
            response.getWriter().println("<h1>Usuário ou senha inválidos.</h1>");
        }
    }
}