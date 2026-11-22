import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/countServlet")
public class CountVisits extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws IOException {

        response.setContentType("text/html;charset=UTF-8");

        int visits = 0;
        Cookie[] cookies = request.getCookies();

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("visits".equals(cookie.getName())) {
                    try {
                        visits = Integer.parseInt(cookie.getValue());
                    } catch (NumberFormatException e) {
                        visits = 0;
                    }
                    break;
                }
            }
        }

        visits++;

        Cookie cookie = new Cookie("visits", String.valueOf(visits));
        cookie.setPath("/TP1");
        response.addCookie(cookie);

        response.getWriter().println("Nombre de visites : " + visits);
    }
}