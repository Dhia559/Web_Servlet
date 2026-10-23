package org.example.tp1;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
@WebServlet(name = "ex1", value = "/ex1")
public class ex1 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher("/form.html").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String birthdate = request.getParameter("birthdate");
        String gender = request.getParameter("gender") ;

        Cookie c1=new Cookie("firstName",firstname);
        Cookie c2=new Cookie("LastName",lastname);
        Cookie c3=new Cookie("birthDay",birthdate);
        Cookie c4=new Cookie("Sex",gender);

        response.addCookie(c1);
        response.addCookie(c2);
        response.addCookie(c3);
        response.addCookie(c4);
        response.setContentType("text/html; charset=UTF-8");

        PrintWriter out = response.getWriter();

        out.println("<html><body>");

        out.println("<table border='1'>"
                + "<tr>"
                + "<th>First Name</th>"
                + "<th>Last Name</th>"
                + "<th>Birth Date</th>"
                + "<th> gender </th>"
                + "</tr>");

        out.println("<tr>"
                + "<td>" + firstname + "</td>"
                + "<td>" + lastname + "</td>"
                + "<td>" + birthdate + "</td>"
                + "<td>" + gender + "</td>"
                + "</tr>");

        out.println("</table>");
        out.println("</body></html>");
    }
}
