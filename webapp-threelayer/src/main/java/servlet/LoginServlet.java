package servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.Impl.LoginServiceImpl;
import service.LoginService;

import javax.naming.NamingException;
import java.io.IOException;

@WebServlet(urlPatterns = {"/login", "/loginPage"})
public class LoginServlet extends HttpServlet {
    private LoginService service;

    public void init() throws ServletException {
        try {
            service = LoginServiceImpl.getInstance();
        } catch (NamingException e) {
            throw new ServletException(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("login.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (service.check(username, password)) {
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            response.sendRedirect(request.getContextPath() + "/info");
        } else {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("login.jsp");
            request.setAttribute("status", false);
            requestDispatcher.forward(request, response);
        }
    }
}
