package by.maximchikova.task2;

import by.maximchikova.dao.UserDAO;
import by.maximchikova.entities.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@javax.servlet.annotation.WebServlet(name = "Servlet3", urlPatterns = "/Servlet3")
public class Servlet3 extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        UserDAO userDAO = new UserDAO();
        User newUser = userDAO.addEntity(login, password);

        HttpSession session = request.getSession(true);
        session.setAttribute("URL", request.getRequestURL());
        session.setAttribute("User", newUser);

        response.sendRedirect(request.getContextPath() + "/Servlet4");
    }
}
