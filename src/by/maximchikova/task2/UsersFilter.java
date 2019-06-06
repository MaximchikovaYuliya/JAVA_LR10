package by.maximchikova.task2;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "UsersFilter", urlPatterns = { "/SecurePage.jsp" })
public class UsersFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        HttpSession session = request.getSession(true);
        if(session.getAttribute("User") == null) {
            response.sendRedirect(request.getContextPath() + "/registration.jsp");
        }
        chain.doFilter(request,  response);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
