package servlet;

import java.io.IOException;
 
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
 
@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    public LogoutServlet() {
        super();
    }
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.removeAttribute("loginedUser");
             
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/homeView.jsp");
            dispatcher.forward(request, response);
        }
        
    }
}
