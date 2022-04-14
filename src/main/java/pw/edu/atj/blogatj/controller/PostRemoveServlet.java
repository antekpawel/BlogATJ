package pw.edu.atj.blogatj.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import pw.edu.atj.blogatj.model.Post;
import pw.edu.atj.blogatj.model.PostService;

import java.io.IOException;

@WebServlet(name = "PostRemoveServlet", value = "/PostRemoveServlet")
public class PostRemoveServlet extends HttpServlet {
    PostService postService = new PostService();
    boolean isPostRemoved = false;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/postRemove.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int noPost;
        try {
            noPost = Integer.parseInt(request.getParameter("noPost")) - 1;
        } catch (NumberFormatException e) {
            return;
        }
        if (noPost >= 0) {
            postService.removePost(noPost);
            isPostRemoved = true;
        }

        request.setAttribute("isPostRemoved", isPostRemoved);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/postRemove.jsp");
        dispatcher.forward(request, response);
    }
}
