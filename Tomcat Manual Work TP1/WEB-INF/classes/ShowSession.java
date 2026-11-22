
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;

@WebServlet("/ShowSession")
public class ShowSession extends HttpServlet {

    private static final DateTimeFormatter[] FORMATS = {
        DateTimeFormatter.ofPattern("MM/dd/yyyy"),
        DateTimeFormatter.ofPattern("dd/MM/yyyy"),
        DateTimeFormatter.ofPattern("yyyy-MM-dd")
    };

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession s = request.getSession(true);
        response.setContentType("text/html;charset=UTF-8");

        if (s.isNew()) {
            response.sendRedirect(request.getContextPath() + "/form.html");
            return;
        }

        String firstname = "";
        String br = "";
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie c : cookies) {
                switch (c.getName()) {
                    case "firstName":
                        firstname = c.getValue();
                        break;
                    case "birthDay":
                        br = c.getValue();
                        break;
                }
            }
        }

        response.getWriter().println("<h2>Welcome back</h2>");

        if (firstname != null && !firstname.isEmpty()) {
            response.getWriter().println("<h3>Hi, " + firstname + "</h3>");
        }

        LocalDate birthday = parseDate(br);
        if (birthday == null) {
            response.getWriter().println("<p>No valid birthday cookie found. "
                    + "<a href=\"" + request.getContextPath() + "/form.html\">Fill the form</a></p>");
            return;
        }

        LocalDate today = LocalDate.now();
        LocalDate nextBirthday = birthday.withYear(today.getYear());
        if (!nextBirthday.isAfter(today)) {
            nextBirthday = nextBirthday.plusYears(1);
        }
        long days = ChronoUnit.DAYS.between(today, nextBirthday);

        response.getWriter().println("<h3>there are " + days + " days to your birthday</h3>");
    }

    private LocalDate parseDate(String value) {
        if (value == null || value.trim().isEmpty()) {
            return null;
        }
        value = value.trim();
        for (DateTimeFormatter f : FORMATS) {
            try {
                return LocalDate.parse(value, f);
            } catch (DateTimeParseException ignored) {
            }
        }
        return null;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
