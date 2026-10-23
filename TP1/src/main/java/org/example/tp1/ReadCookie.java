package org.example.tp1;


import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/ReadCookie")
public class ReadCookie extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String firstname = ""  ;
        String lastname = ""  ;
        String birthday = "" ;
        String sex = "" ;
        Cookie[] cookies = request.getCookies();
        if (cookies!= null ) {
            for(Cookie c:cookies) {
                switch(c.getName()) {
                    case "firstName":
                        firstname = c.getValue();
                        if (firstname == "") {
                            System.out.println("Veuiller saisir votre Nom  ");
                    }
                        break;

                    case "LastName":
                        lastname = c.getValue();
                        if (lastname == "") {
                            System.out.println("Veuiller saisir votre Prenom  ");
                        }
                        break;

                    case "birthDay":
                        birthday = c.getValue();
                        if (birthday == "") {
                            System.out.println("Veuiller saisir votre date d aniversaire   ");
                        }
                        break;

                    case "Sex":
                        sex = c.getValue();
                        if (sex == "") {
                            System.out.println("Veuiller saisir votre Sex  ");
                        }
                        break;
                }
            }
            response.getWriter().println("<table border='1'>"
                    + "<tr>"
                    + "<th>First Name</th>"
                    + "<th>Last Name</th>"
                    + "<th>Birth Date</th>"
                    + "<th> gender </th>"
                    + "</tr>");

            response.getWriter().println("<tr>"
                    + "<td>" + firstname + "</td>"
                    + "<td>" + lastname + "</td>"
                    + "<td>" + birthday + "</td>"
                    + "<td>" + sex + "</td>"
                    + "</tr>");
        }
    }
}
