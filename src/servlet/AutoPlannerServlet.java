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

@WebServlet(urlPatterns = { "/Autobots" })
public class AutoPlannerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 
    public AutoPlannerServlet() {
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
    	
        Connection conn = MyUtils.getStoredConnection(request);
        UserAccount user= MyUtils.getLoginedUser(session);
        String errorString = null;
        List<Courses> Recordslist = null;
        List<Courses> Currentlist = null;
        List<Courses> tryitout = null;
        try {
        	//Check Student Standing
            Recordslist = DBUtils.getRecordOfCourses(conn, user.getStudentID());
            Currentlist = DBUtils.getCurrentCourses(conn, user.getStudentID());
            DBUtils.coreRequirementCheck(Recordslist, request);
            DBUtils.genEdsRequirementCheck(Recordslist, request);
            DBUtils.inProgressCheck(Currentlist, request);
            tryitout = DBUtils.AutoPlannerVersion1(conn, request, user.getStudentID());
            
            //if(tryitout.isEmpty())
            request.setAttribute("AutoPlannerRan", true);
            request.setAttribute("tryitout", tryitout);
            
        } catch (SQLException e) {
            e.printStackTrace();
            errorString = e.getMessage();
        }
        //Store info in request attribute, before forward to views
        request.setAttribute("errorString", errorString);
        //request.setAttribute("courseList", list);
         
        // Forward to /WEB-INF/views/productListView.jsp
        RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/WEB-INF/views/autoPlannerView.jsp");
        dispatcher.forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
