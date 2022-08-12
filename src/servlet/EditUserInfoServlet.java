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
 
import beans.UserAccount;
import utils.DBUtils;
import utils.MyUtils;
 
@WebServlet(urlPatterns = { "/editUserInfo" })
public class EditUserInfoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    HttpSession session;
    UserAccount loginedUser;
    public EditUserInfoServlet() {
        super();
    }
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //HttpSession 
    	session = request.getSession();
 
        // Check User has logged on
        //UserAccount 
        loginedUser = MyUtils.getLoginedUser(session);
 
        // Not logged in
        if (loginedUser == null) {
            // Redirect to login page.
            response.sendRedirect(request.getContextPath() + "/login");
            return;
        }
        // Store info to the request attribute before forwarding.
        request.setAttribute("user", loginedUser); // <-- can change this maybe to student
 
        // If the user has logged in, then forward to the page
        // /WEB-INF/views/userInfoView.jsp
        RequestDispatcher dispatcher //
                = this.getServletContext().getRequestDispatcher("/WEB-INF/views/editUserInfoView.jsp");
        dispatcher.forward(request, response);
 
    }
 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        String errorString=null;
        //System.out.println(loginedUser.getStudentFirstName()+ loginedUser.getStudentLastName());
        //System.out.println(phone);
        //System.out.println(address);
        
        boolean hasError=false;
        if(email==null|| email.isBlank()) {
        	hasError = true;
        	errorString = "Cannot leave email blank. ";
        }
        if(phone==null|| phone.isBlank()) {
        	hasError = true;
        	if(errorString==null) {
        		errorString = "Cannot leave phone blank. ";
        	}
        	else
        	errorString += "Cannot leave phone blank. ";
        }
        if(address==null|| address.isBlank()) {
        	hasError = true;
        	if(errorString==null) {
        		errorString = "Cannot leave address blank. ";
        	}
        	else
        	errorString += "Cannot leave address blank. ";
        }
 
        if (hasError) {
        	//HttpSession session = request.getSession();
        	//UserAccount loginedUser = MyUtils.getLoginedUser(session);
            // Store information in request attribute, before forward.
            request.setAttribute("errorString", errorString);
            request.setAttribute("user", loginedUser);
 
            RequestDispatcher dispatcher //
                    = this.getServletContext().getRequestDispatcher("/WEB-INF/views/editUserInfoView.jsp");
 
            dispatcher.forward(request, response);
        }
        else {
            loginedUser.setStudentEmail(email);
            loginedUser.setStudentPhone(phone);
            loginedUser.setStudentAddress(address); 
            Connection conn = MyUtils.getStoredConnection(request);
            try {
                DBUtils.updateStudent(conn, loginedUser);
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
                        .getRequestDispatcher("/WEB-INF/views/editUserInfoView.jsp");
                dispatcher.forward(request, response);
            }
            // If everything nice.
            // Redirect to the product listing page.        
            else {
                response.sendRedirect(request.getContextPath() + "/userInfo");
            }
        }
        //doGet(request, response);
    }
 
}