package org.example.tp1;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/countServlet")
public class CountVisits extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int visits  = 1 ;
        Cookie[] cookies = request.getCookies();
        if (cookies!= null ) {
            for(Cookie c:cookies) {
                if ("visits".equals(c.getName())){
                    try{
                        visits = Integer.parseInt(c.getValue());
                    }catch (Exception e ){
                        visits =  0 ;
                    }
                }
            }

        }
        visits ++ ;



        Cookie c = new Cookie("visits",String.valueOf(visits));
        response.addCookie(c);

        response.getWriter().println(
                "Nombre de visites : " + visits
        );

    }
}
