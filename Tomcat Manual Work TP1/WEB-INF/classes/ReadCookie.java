

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/ReadCookie")
public class ReadCookie extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String firstname = "";
        String lastname = "";
        String birthday = "";
        String sex = "";

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie c : cookies) {
                switch (c.getName()) {
                    case "firstName":
                        firstname = c.getValue();
                        break;
                    case "LastName":
                        lastname = c.getValue();
                        break;
                    case "birthDay":
                        birthday = c.getValue();
                        break;
                    case "Sex":
                        sex = c.getValue();
                        break;
                }
            }
        }

        out.println("<html><body>");
        if (firstname.isEmpty() && lastname.isEmpty() && birthday.isEmpty() && sex.isEmpty()) {
            out.println("<p>No cookies found. "
                    + "<a href=\"" + request.getContextPath() + "/form.html\">Fill the form first</a></p>");
        } else {
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
                    + "<td>" + birthday + "</td>"
                    + "<td>" + sex + "</td>"
                    + "</tr>");
            out.println("</table>");
        }
        out.println("<p><a href=\"" + request.getContextPath() + "/form.html\">Home</a></p>");
        out.println("</body></html>");
    }
}
