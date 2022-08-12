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
 
@WebServlet(urlPatterns = { "/add" })
public class AddClassServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    public AddClassServlet() {
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
        String studentID = loginedUser.getStudentID();
      //Search for the class details
        Courses c=null;
        String errorString = null;
        try {
        	boolean ableToAdd=true;
        	c=DBUtils.findClass(conn, classID);
            //Check if room in class
            int x= Integer.parseInt(c.getClassMaxSize());
            int y= Integer.parseInt(c.getClassCurrentSize());
            //check to see if there is room available in the class
            if(x<=y) {
            	errorString = "Unable to add class: NO SPACE AVAIABLE.";
            	ableToAdd=false;
            }	
            
            else {
            	//check to see if class puts student over credit limit
            	int a= Integer.parseInt(c.getCredits());
            	List<Courses> curr=null;
            	curr=DBUtils.getCurrentCourses(conn, studentID);
            	for(Courses cc:curr) {
            		a+=Integer.parseInt(cc.getCredits());
            	}
            	if(a>18) {
            		errorString = "Unable to add class: CLASS CREDIT LIMIT WILL BE SURPASSED";
            		ableToAdd=false;
            	}
            	else {
            		//if space available check for prerequisites
                    List<Courses> list = null;
                    list = DBUtils.getRecordOfCourses(conn, studentID);  
                    //System.out.println(c.getPrerequisite3());
                    if(!(c.getPrerequisite3()==null)) {
                    	System.out.println("THERE ARE 3 PREREQUISITES FOR THIS CLASS");
                    	boolean pr3=false;
                    	String prereq3=c.getPrerequisite3();
                    	String[] arrOfStr = prereq3.split(" ", 2);
                    	String type=arrOfStr[0];
                    	String number=arrOfStr[1];
                    	//Check records for 3rd prerequisite
                    	for(Courses H: list) {
                    		if(H.getClassType().equals(type) && H.getClassNumber().equals(number)) {
                    			if(H.getGrade().equals("A")||H.getGrade().equals("B")||H.getGrade().equals("C")) {
                    				pr3=true;
                    			}
                    		}
                    	}
                    	if(!pr3) {
                    		errorString = "Unable to add class: PREREQUISITE(S) NOT MET, "+ type+ " "+ number+" ";
                    		ableToAdd=false;
                    	}
                    }
                    
                    if(!(c.getPrerequisite2()==null)) {
                    	System.out.println("THERE ARE 2 PREREQUISITES FOR THIS CLASS");
                    	boolean pr2=false;
                    	String prereq2=c.getPrerequisite2();
                    	String[] arrOfStr = prereq2.split(" ", 2);
                    	String type=arrOfStr[0];;
                    	String number=arrOfStr[1];
                    	//Check records for 2nd prerequisite
                    	for(Courses H: list) {
                    		if(H.getClassType().equals(type) && H.getClassNumber().equals(number)) {
                    			if(H.getGrade().equals("A")||H.getGrade().equals("B")||H.getGrade().equals("C")) {
                    				pr2=true;
                    			}
                    		}
                    	}
                    	if(!pr2) {
                    		ableToAdd=false;
                    		if(errorString==null) {
                    			errorString = "Unable to add class: PREREQUISITE NOT MET, "+ type+ " "+ number+"";
                    		}
                    		else {
                    			errorString +=", "+ type+ " "+ number;
                    		}
                    	}
                    }
                    
                    if(!(c.getPrerequisite1()==null)) {
                    	System.out.println("THERE ARE 1 PREREQUISITES FOR THIS CLASS");
                    	boolean pr1=false;
                    	String prereq1=c.getPrerequisite1();
                    	String[] arrOfStr = prereq1.split(" ", 2);
                    	String type=arrOfStr[0];
                    	String number=arrOfStr[1];
                    	//Check records for prerequisite
                    	for(Courses H: list) {
                    		if(H.getClassType().equals(type) && H.getClassNumber().equals(number)) {
                    			if(H.getGrade().equals("A")||H.getGrade().equals("B")||H.getGrade().equals("C")) {
                    				pr1=true;
                    			}
                    		}
                    	}
                    	if(!pr1) {
                    		ableToAdd=false;
                    		if(errorString==null) {
                    			errorString = "Unable to add class: PREREQUISITE NOT MET "+ type+ " "+ number+"";
                    		}
                    		else {
                    			errorString +=", "+ type+ " "+ number;
                    		}
                    	}
                    }
            	}
            }
            //check to see class not already in schedule
            List<Courses> list = null;
            list = DBUtils.getCurrentCourses(conn, studentID);
            for(Courses Curr: list) {
            	//System.out.println("ID FROM CURRENT CLASSES "+Curr.getClassID());
            	//System.out.println("ID FROM CLASS TO ADD "+c.getClassID());
            	//System.out.println(c.getClassID().equals(Curr.getClassID()));
            	if(c.getClassID().equals(Curr.getClassID())) {
            		
            		errorString = "Unable to add class: CLASS ALREADY IN SCHEDULE.";
            		ableToAdd=false;
            	}
            }
            //if space available and prereqs met and not already in schedule... then add to current courses
            if(ableToAdd) {
            	//DBUtils.insertProduct(conn, classID, studentID, c.getClassInstructorEmployeeID());
            	DBUtils.addClass(conn, classID, studentID, c.getClassInstructorEmployeeID());
            	DBUtils.updateClassSizeADD(conn, classID, c.getClassCurrentSize());
            }
        } catch (SQLException e) {
            e.printStackTrace();
            errorString = e.getMessage();
        } 
        // If has an error, redirect to the error page.
        if (errorString != null) {
        	List<Courses> searchList=null;
            // Store the information in the request attribute, before forward to views.
            request.setAttribute("errorString", errorString);
            try {
				searchList = DBUtils.searchCourses(conn, c.getClassType(), c.getClassNumber());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            request.setAttribute("searchList", searchList);
            RequestDispatcher dispatcher = request.getServletContext()
                    .getRequestDispatcher("/WEB-INF/views/searchListView.jsp");
            dispatcher.forward(request, response);
        }
        // If everything nice.
        // Redirect to current courses page.        
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