package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//import beans.Courses;
import beans.Instructor;
import beans.UserAccount;
import utils.DBUtils;
import utils.MyUtils;
 
@WebServlet(urlPatterns = { "/instructor2" })
public class InstructorServlet2 extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    public InstructorServlet2() {
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
        String intructorID = (String) request.getParameter("intructorID");
        System.out.println(intructorID);
        String studentID = loginedUser.getStudentID();
        System.out.println(studentID);
        //String instructorID 
        String errorString = null;
        Instructor in=null;
        try {
            in=DBUtils.findInstructor(conn, intructorID);
            //Courses c=DBUtils.findProduct(conn, classID);
            //DBUtils.insertProduct(conn, classID, studentID, c.getClassInstructorEmployeeID());
        } catch (SQLException e) {
            e.printStackTrace();
            errorString = e.getMessage();
        } 
        request.setAttribute("Instructor", in); 
        // If has an error, redirecte to the error page.
        if (errorString != null) {
            // Store the information in the request attribute, before forward to views.
            request.setAttribute("errorString", errorString);
            // 
            RequestDispatcher dispatcher = request.getServletContext()
                    .getRequestDispatcher("/WEB-INF/views/deleteProductErrorView.jsp");
            dispatcher.forward(request, response);
        }
        // If everything nice.
        // Redirect to the product listing page.        
        else {
        	RequestDispatcher dispatcher = request.getServletContext()
                    .getRequestDispatcher("/WEB-INF/views/instructorView2.jsp");
            dispatcher.forward(request, response);
        }
 
    }
 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
 
}