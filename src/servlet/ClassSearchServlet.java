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
 
@WebServlet(urlPatterns = { "/classSearch" })
public class ClassSearchServlet extends HttpServlet {
	List<Courses> searchList = null;
    private static final long serialVersionUID = 1L;
 
    public ClassSearchServlet() {
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
        // Forward to /WEB-INF/views/loginView.jsp
        // (Users can not access directly into JSP pages placed in WEB-INF)
        RequestDispatcher dispatcher //
                = this.getServletContext().getRequestDispatcher("/WEB-INF/views/classSearchView.jsp");
        dispatcher.forward(request, response);
    }
 
    // When the user enters type & number, and click Submit.
    // This method will be executed.
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String classType = request.getParameter("classType");
        String classNumber = request.getParameter("classNumber");
        //String rememberMeStr = request.getParameter("rememberMe");
        //boolean remember = "Y".equals(rememberMeStr);
 
        //Courses user = null;
        boolean hasError = false;
        String errorString = null;
 
        if (classType == null || classNumber == null || classType.length() == 0 || classNumber.length() == 0) {
            hasError = true;
            errorString = "Required class type and number!";
        } else {
            Connection conn = MyUtils.getStoredConnection(request);
            
            try {
                // Find the user in the DB.
                searchList = DBUtils.searchCourses(conn, classType, classNumber);
 
                if (searchList.isEmpty()) {
                    hasError = true;
                    errorString = "Number or Type invalid";
                }
            } catch (SQLException e) {
                e.printStackTrace();
                hasError = true;
                errorString = e.getMessage();
            }
        }
        // If error, forward to /WEB-INF/views/classSearchView.jsp
        if (hasError) {
        	//System.out.println("YOU ARE HERE");
            // Store information in request attribute, before forward.
            request.setAttribute("errorString", errorString);
            //request.setAttribute("user", user);
 
            // Forward to class search view on error
            RequestDispatcher dispatcher //
                    = this.getServletContext().getRequestDispatcher("/WEB-INF/views/classSearchView.jsp");
 
            dispatcher.forward(request, response);
        }
        // If no error
        // Store user information in Session
        // And redirect to userInfo page.
        else {
            request.setAttribute("searchList", searchList);
            
 
            // Redirect to userInfo page.
            RequestDispatcher dispatcher = request.getServletContext()
                    .getRequestDispatcher("/WEB-INF/views/searchListView.jsp");
            dispatcher.forward(request, response);
            //response.sendRedirect(request.getContextPath() + "/courses");
        }
    }
 
}
