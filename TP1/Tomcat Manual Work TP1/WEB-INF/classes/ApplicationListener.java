import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ApplicationListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("Application Started");

        sce.getServletContext().setAttribute(
            "AppName", "ING1 Web Application"
        );
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("App destroyed");
    }
}
