
package org.example.tp1;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class ApplicationListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {

        System.out.println("Application Started");

        ServletContext context = sce.getServletContext();

        context.setAttribute("AppName", "ING1 Web Application");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

        System.out.println("App destroyed");
    }
}
