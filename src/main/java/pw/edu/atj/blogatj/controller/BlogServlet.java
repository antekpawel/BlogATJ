package pw.edu.atj.blogatj.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import pw.edu.atj.blogatj.model.Post;
import pw.edu.atj.blogatj.model.PostService;
import pw.edu.atj.blogatj.model.User;

import java.io.IOException;

import static pw.edu.atj.blogatj.controller.LoginValidationServlet.ACTUAL_USER;

@WebServlet(name = "blog", value = "/blog")
public class BlogServlet extends HttpServlet {
    private PostService postService;
    private User user = ACTUAL_USER;

    public void init() {
        postService = new PostService();
        postService.readFromJSON();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("posts", postService.getPost());
        request.setAttribute("user", user);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/blog.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String post = request.getParameter("blogPost");

        if (!post.isEmpty()){
            postService.addPost(new Post(post, user.getUsername()));
            postService.saveToJSON();
        }

        request.setAttribute("posts", postService.getPost());
        request.setAttribute("user", user);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/blog.jsp");
        dispatcher.forward(request, response);
    }
}
