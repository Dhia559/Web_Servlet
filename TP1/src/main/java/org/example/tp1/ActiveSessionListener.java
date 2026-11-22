package org.example.tp1;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;
import jakarta.servlet.annotation.WebListener;

import java.util.concurrent.atomic.AtomicInteger;

@WebListener
public class ActiveSessionListener implements HttpSessionListener {

    private static int activeSessions = 0;

    @Override
    public void sessionCreated(HttpSessionEvent se) {

        activeSessions++;


        ServletContext context = se.getSession()
                .getServletContext();

        context.setAttribute("activeSessions", new AtomicInteger(activeSessions));;

        System.out.println("New session created. Active sessions: " + activeSessions);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {

        activeSessions--;

        ServletContext context = se.getSession()
                .getServletContext();

        context.setAttribute("activeSessions", activeSessions);

        System.out.println("Session destroyed. Active sessions: " + activeSessions);
    }
}
