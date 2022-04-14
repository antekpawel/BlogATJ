package pw.edu.atj.blogatj.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import pw.edu.atj.blogatj.model.User;
import pw.edu.atj.blogatj.model.UserService;

import java.io.IOException;

@WebServlet(name = "RegisterAuthenticationServlet", value = "/RegisterAuthenticationServlet")
public class RegisterAuthenticationServlet extends HttpServlet {
    UserService userService = new UserService();
    boolean userExist;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        userValidation(request);
        request.setAttribute("userExist", userExist);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/registerAuthentication.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        userValidation(request);
        request.setAttribute("userExist", userExist);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/registerAuthentication.jsp");
        dispatcher.forward(request, response);
    }
    private void userValidation(HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = new User(username, password);

        userExist = userService.userExist(user.getUsername());

        if (userExist) return;
        userService.addUser(username, password);
    }
}
