package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
 
import beans.Courses;
import beans.UserAccount;
import utils.DBUtils;
import utils.MyUtils;
 
@WebServlet(urlPatterns = { "/genEdClassSearch" })
public class GenEdSearchServlet extends HttpServlet {
	List<Courses> searchList = null;
    private static final long serialVersionUID = 1L;
 
    public GenEdSearchServlet() {
        super();
    }
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	HttpServletRequest req = (HttpServletRequest) request;
    	HttpSession session = req.getSession();
    	// Check User has logged on
        UserAccount loginedUser = MyUtils.getLoginedUser(session);
 
        // Not logged in
        if (loginedUser == null) {
            // Redirect to login page.
            response.sendRedirect(request.getContextPath() + "/login");
            return;
        }
        boolean hasError = false;
        String errorString = null;
        String classType = request.getParameter("classType");
        String classNumber = request.getParameter("classNumber");
        System.out.println(classType+ " "+ classNumber);
        try {
        	Connection conn = MyUtils.getStoredConnection(request);
            searchList = DBUtils.searchCourses(conn, classType, classNumber);

            if (searchList.isEmpty()) {
                hasError = true;
                errorString = "CLASS IS NOT OFFERED THIS SEMESTER";
            }
        } catch (SQLException e) {
            e.printStackTrace();
            hasError = true;
            errorString = e.getMessage();
        }
        // If error, forward to /WEB-INF/views/classSearchView.jsp
        if (hasError) {
            request.setAttribute("errorString", errorString);
            // Forward to class search view on error
            RequestDispatcher dispatcher //
                    = this.getServletContext().getRequestDispatcher("/WEB-INF/views/classSearchView.jsp");
            dispatcher.forward(request, response);
        }
        // If no error
        else {
            request.setAttribute("searchList", searchList);
 
            // Redirect to page.
            RequestDispatcher dispatcher = request.getServletContext()
                    .getRequestDispatcher("/WEB-INF/views/searchListView.jsp");
            dispatcher.forward(request, response);
        }
    }
 
    // When the user enters type & number, and click Submit.
    // This method will be executed.
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    }
 
}
