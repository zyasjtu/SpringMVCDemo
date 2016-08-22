package filter;


import model.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by z673413 on 2016/7/26.
 */
public class LoginFilter implements Filter {

    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        User user = (User) req.getSession().getAttribute("loginUser");
        String url = req.getRequestURI();

        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        if (user != null) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else if (url.indexOf("login.html") > 0) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            resp.sendRedirect("http://localhost:8080/SSMDemo/page/login.html");
        }
    }

    public void destroy() {

    }
}
