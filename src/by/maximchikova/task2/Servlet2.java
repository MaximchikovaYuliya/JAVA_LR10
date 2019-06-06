package by.maximchikova.task2;

import by.maximchikova.dao.UserDAO;
import by.maximchikova.entities.User;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Date;

@javax.servlet.annotation.WebServlet(name = "Servlet2", urlPatterns = "/Servlet2")
public class Servlet2 extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        UserDAO userDAO = new UserDAO();
        User user = userDAO.findEntity(login, password);
        if(user != null) {
            HttpSession session = request.getSession(true);
            session.setAttribute("URL", request.getRequestURL());
            session.setAttribute("User", user);
            response.addCookie(new Cookie("LastSession", new Date(session.getCreationTime()).toString()));
            response.addCookie(new Cookie("UserRole", ((User)session.getAttribute("User")).getRole()));

            response.sendRedirect(request.getContextPath() + "/Servlet4");
        }
        else {
            response.getWriter().println("ERROR");
        }
    }
}
