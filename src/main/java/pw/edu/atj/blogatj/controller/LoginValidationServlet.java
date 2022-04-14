package pw.edu.atj.blogatj.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import pw.edu.atj.blogatj.model.User;
import pw.edu.atj.blogatj.model.UserService;

import java.io.IOException;

@WebServlet(name = "LoginValidationServlet", value = "/LoginValidationServlet")
public class LoginValidationServlet extends HttpServlet {
    UserService userService;
    boolean validUser = false;
    public static User ACTUAL_USER = new User(null, null);

    public void init() {
        userService = new UserService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        userValidation(request);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        userValidation(request);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/validation.jsp");
        dispatcher.forward(request, response);
    }

    private void userValidation(HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        ACTUAL_USER.setUsername(username);
        ACTUAL_USER.setPassword(password);
        validUser = userService.userIsValid(ACTUAL_USER);
        request.setAttribute("user", ACTUAL_USER);
        request.setAttribute("validUser", validUser);
    }
}
