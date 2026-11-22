import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.annotation.WebFilter;

import java.io.IOException;
@WebFilter("/*")
public class LoggingFilter implements Filter {
    private String logPrefix;
    @Override 
    public void init (FilterConfig config) throws ServletException {
        logPrefix = config.getInitParameter("logPrefix");
        System.out.println("LoggingFilter initialized");
    }
    @Override
    public void doFilter(ServletRequest request,
                        ServletResponse response,
                        FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        System.out.println("Request URL: " +
        httpRequest.getRequestURL());    
        System.out.println(logPrefix +"Before Servlet"); 
        chain.doFilter(request, response);
        System.out.println(logPrefix +"After Servlet ");

    }

    @Override
    public void destroy() {
        System.out.println("LoggingFilter destroyed");
    }
    
}