package by.maximchikova.task1;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Enumeration;

@javax.servlet.annotation.WebServlet(name = "Servlet1", urlPatterns = "/Servlet1")
public class Servlet1 extends javax.servlet.http.HttpServlet {

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        response.getWriter().println(LocalDateTime.now().toLocalTime().toString());
        response.getWriter().println();

        response.getWriter().println(request.getProtocol());
        response.getWriter().println(request.getRemoteAddr());
        response.getWriter().println(request.getRequestURL());
        response.getWriter().println(request.getRemoteUser());
        response.getWriter().println();

        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String s = headerNames.nextElement();
            response.getWriter().println(s + " = " + request.getHeader(s));
        }
    }
}
