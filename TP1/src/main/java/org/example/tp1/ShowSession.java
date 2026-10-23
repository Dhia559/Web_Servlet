package org.example.tp1;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

@WebServlet("/ShowSession")
public class ShowSession extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession s =request.getSession(true);
        response.setContentType("text/html;charset=UTF-8");
        if (s.isNew()) {
            response.getWriter().println("<h2> Welcome on my site </h2>");
            response.sendRedirect("/form.html");
        }
        else {
            String firstname = ""  ;
            String br = "" ;
            Cookie[] cookies = request.getCookies();
                for(Cookie c:cookies) {
                    switch(c.getName()) {
                        case "firstName":
                            firstname = c.getValue();
                            if (firstname == "") {
                                System.out.println("Veuiller saisir votre Nom  ");
                            }
                            break;

                        case "birthDay":
                            br = c.getValue();
                            if (br == "") {
                                System.out.println("Veuiller saisir votre date d aniversaire   ");
                            }
                            break;
                    }
                }
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

            LocalDate birthday = LocalDate.parse(br, formatter);
            LocalDate today = LocalDate.now();

            LocalDate nextBirthday = birthday.withYear(today.getYear());

            if (!nextBirthday.isAfter(today)) {
                nextBirthday = nextBirthday.plusYears(1);
            }

            long days = ChronoUnit.DAYS.between(today, nextBirthday);

            System.out.println("Days until birthday: " + days);
            response.getWriter().println("<h2>Welcome back</h2>");
            response.getWriter().println("<h3>Hi , "+firstname+" there are "+days+" days to your birthday </h3>");

        }

    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}