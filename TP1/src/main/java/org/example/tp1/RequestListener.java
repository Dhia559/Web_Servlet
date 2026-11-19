package org.example.tp1;

import jakarta.servlet.ServletRequestEvent;
import jakarta.servlet.ServletRequestListener;

public class RequestListener implements ServletRequestListener {

    @Override
    public void requestInitialized(ServletRequestEvent se ){
        System.out.println("HTTP  Request is initialised!! ");
    }

    @Override
    public void requestDestroyed(ServletRequestEvent se ){
        System.out.println("HTTP  Request processing finishesd!! ");
    }
}
