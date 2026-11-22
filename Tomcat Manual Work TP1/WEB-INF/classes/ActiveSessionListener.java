import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ActiveSessionListener implements HttpSessionListener {

    private static int activeSessions = 0;

    @Override
    public void sessionCreated(HttpSessionEvent se) {

        activeSessions++;

        ServletContext context = se.getSession()
                                  .getServletContext();

        context.setAttribute("activeSessions", activeSessions);

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