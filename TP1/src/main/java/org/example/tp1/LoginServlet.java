package org.example.tp1;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        if (username == null || username.trim().isEmpty()
                || password == null || password.trim().isEmpty()) {
            out.println("<html><body>");
            out.println("<h2>Missing username or password</h2>");
            out.println("<a href=\"login.html\">Back to login</a>");
            out.println("</body></html>");
            return;
        }

        HttpSession session = request.getSession();

        SessionUser user = new SessionUser("Dhia");

        session.setAttribute("user", user);
        System.out.println("success !!!!!!!!!! ");

        out.println("<html><body>");
        out.println("<h2>Welcome, " + username + " !</h2>");
        out.println("<br> <a href=\"./items.html\">Items List </a>");
        out.println("</body></html>");
    }
}
