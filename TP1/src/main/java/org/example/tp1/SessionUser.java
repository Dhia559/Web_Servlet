package org.example.tp1;

import jakarta.servlet.http.HttpSessionActivationListener;
import jakarta.servlet.http.HttpSessionBindingListener;
import jakarta.servlet.http.HttpSessionBindingEvent;
import jakarta.servlet.http.HttpSessionEvent;

public class SessionUser implements HttpSessionBindingListener, HttpSessionActivationListener {

    private String username;

    public SessionUser(String username) {
        this.username = username;
    }

    @Override
    public void valueBound(HttpSessionBindingEvent event) {
        System.out.println(
                username + " has been added to the session!"
        );
    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent event) {
        System.out.println(
                username + " has been removed from the session!"
        );
    }
    @Override
    public void sessionWillPassivate(HttpSessionEvent event) {
        System.out.println(
                username + " session is being passivated!"
        );
    }

    @Override
    public void sessionDidActivate(HttpSessionEvent event) {
        System.out.println(
                username + " session has been activated!"
        );
    }
}

