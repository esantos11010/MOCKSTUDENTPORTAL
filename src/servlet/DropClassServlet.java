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

import beans.Courses;
import beans.UserAccount;
import utils.DBUtils;
import utils.MyUtils;
 
@WebServlet(urlPatterns = { "/drop" })
public class DropClassServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    public DropClassServlet() {
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
        String classID = (String) request.getParameter("classID");
        System.out.println(classID);
        String studentID = loginedUser.getStudentID();
        System.out.println(studentID);
        String errorString = null;
        try {
        	//delete from table student_has_courses
            DBUtils.dropClass(conn, classID, studentID);
            // get all course info 
            Courses c=DBUtils.findClass(conn, classID);
            //reduce the current class size by one
            DBUtils.updateClassSizeDROP(conn, classID, c.getClassCurrentSize());
            //Make entry to table student_records_of_classes
            DBUtils.insertRecordOfDrop(conn, classID, studentID, c.getClassInstructorEmployeeID());
        } catch (SQLException e) {
            e.printStackTrace();
            errorString = e.getMessage();
        } 
         
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
            response.sendRedirect(request.getContextPath() + "/courses");
        }
 
    }
 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
 
}