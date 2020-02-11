package by.it.academy.offer.servlet;
//
//import by.it.academy.offer.model.User;
//import by.it.academy.offer.service.UserService;
//import by.it.academy.offer.dao.impl.UserServiceImpl;

import by.it.academy.entity.User;
import by.it.academy.service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    private final UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        req.getSession(true).setAttribute("offer.user.Locale", "ru");
        req.getRequestDispatcher("/WEB-INF/include/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        String userName = req.getParameter("userName");
        String password = req.getParameter("password");

        String errorMsg = "";
        boolean hasError = false;

        if (userName == null || userName.length() == 0 || password == null || password.length() == 0) {
            hasError = true;
            errorMsg = "UserName and password should not be empty";
        } else {
            List<User> user = userService.findUser(userName, password);
            if (!user.isEmpty()) {
                hasError = true;
                errorMsg = "Invalid user name or password";
            } else {
                req.getSession().setAttribute("user",userService.findUser(userName,password));
            }
        }

        if (hasError) {
            req.setAttribute("errorString", errorMsg);
            req.setAttribute("user", new User(userName, password));
            req.getRequestDispatcher("/WEB-INF/include/login.jsp").forward(req, resp);
        } else {
            resp.sendRedirect(req.getContextPath() + "/home");
        }
    }
}