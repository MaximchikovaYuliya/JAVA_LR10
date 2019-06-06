package by.maximchikova.task2;

import by.maximchikova.entities.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDateTime;

@javax.servlet.annotation.WebServlet(name = "Servlet4", urlPatterns = "/Servlet4")
public class Servlet4 extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);

        response.getWriter().println("<html><body>");
        response.getWriter().println("Hello, " + ((User) session.getAttribute("User")).getLogin() + "</br>");
        response.getWriter().println("Your role: " + ((User) session.getAttribute("User")).getRole() + "</br>");
        response.getWriter().println("DateTime: " + LocalDateTime.now() + "</br>");
        response.getWriter().println("<a href=\"SecurePage.jsp\">Secure Page</a></body></html>");
    }
}
