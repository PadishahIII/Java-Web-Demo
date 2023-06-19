package servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(urlPatterns = "/info")
public class UserInfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println("servlet");
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("userinfo.jsp");
        request.setAttribute("username", username);
        requestDispatcher.forward(request, response);
    }
}
