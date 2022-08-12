package utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import beans.UserAccount;
import beans.Courses;
import beans.Instructor;
 
public class DBUtils {
 
    public static UserAccount findUser(Connection conn, //
            String userName, String password) throws SQLException {
 
        String sql = "Select studentHandle, studentPassword, studentFirstName, studentLastName, studentID, studentPhone, studentEmail, studentAddress from students a " //
                + " where studentHandle = ? and studentpassword= ?";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, userName);
        pstm.setString(2, password);
        ResultSet rs = pstm.executeQuery();
 
        if (rs.next()) {
            //String gender = rs.getString("Gender");
            UserAccount user = new UserAccount();
            user.setUserName(userName);
            user.setPassword(password);
            user.setStudentFirstName(rs.getString("studentFirstName"));
            user.setStudentLastName(rs.getString("studentLastName"));
            user.setStudentPhone(rs.getNString("studentPhone"));
            user.setStudentID(rs.getString("studentID"));
            user.setStudentEmail(rs.getString("studentEmail"));
            user.setStudentAddress(rs.getString("studentAddress"));
            return user;
        }
        return null;
    }
    //Following method never used???
    public static UserAccount findUser(Connection conn, String userName) throws SQLException {
 
        String sql = "Select a.User_Name, a.Password from User_Account a "//
                + " where a.User_Name = ? ";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, userName);
 
        ResultSet rs = pstm.executeQuery();
 
        if (rs.next()) {
            String password = rs.getString("Password");
            //String gender = rs.getString("Gender");
            UserAccount user = new UserAccount();
            user.setUserName(userName);
            user.setPassword(password);
            //user.setGender(gender);
            return user;
        }
        return null;
    }
    
    public static Instructor findInstructor(Connection conn, String code) throws SQLException {
        String sql = "Select * from instructor where idInstructor=?";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, code);
 
        ResultSet rs = pstm.executeQuery();
        Instructor I=new Instructor() ;
        while (rs.next()) {
        	
            String ID = rs.getString("idInstructor");
            String first = rs.getString("FirstName");
            String last = rs.getString("LastName");
            String email = rs.getString("Email");
            String room = rs.getString("Room");
            String phone = rs.getString("Phone");
            I.setInstructorID(ID);
            I.setFirstName(first);
            I.setLastName(last);
            I.setEmail(email);
            I.setRoom(room);
            I.setPhone(phone);
        }
        return I;
    }
 
    public static Courses findClass(Connection conn, String code) throws SQLException {
        String sql = "Select * from classes where idClass=?";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, code);
 
        ResultSet rs = pstm.executeQuery();
        Courses course=null ;
        while (rs.next()) {
        	
            String ID = rs.getString("idClass");
            String type = rs.getString("classType");
            String number = rs.getString("classNumber");
            String title = rs.getString("classTitle");
            String section = rs.getString("Section");
            String room = rs.getString("Room");
            String daysTime = rs.getString("Days");
            String start = rs.getString("classStartTime");
            String end = rs.getString("classEndTime");
            String max = rs.getString("classMaxSize");
            String current = rs.getString("CurrentSize");
            String instructor = rs.getString("Instructor_idInstructor");
            String year = rs.getString("Year");
            String semester = rs.getString("Semester");
            String credits = rs.getString("Credits");
            String prereq1 = rs.getString("Prerequisite1");
            String prereq2 = rs.getString("Prerequisite2");
            String prereq3 = rs.getString("Prerequisite3");
            course = new Courses(ID, type, number, title, section, room, daysTime, start, end, max, current, instructor, year, semester, credits);
            course.setPrerequisite1(prereq1);
            course.setPrerequisite2(prereq2);
            course.setPrerequisite3(prereq3);
        }
        return course;
    }
    
    public static List<Courses> getRecordOfCourses(Connection conn, String studentID) throws SQLException {
        String sql = "SELECT * from classes inner join students_record_of_classes on  Classe_idClasse = idClass where Students_idStudents =?";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, studentID);
 
        ResultSet rs = pstm.executeQuery();
        List<Courses> list = new ArrayList<Courses>();
        while (rs.next()) {
        	
            String ID = rs.getString("idClass");
            String type = rs.getString("classType");
            String number = rs.getString("classNumber");
            String title = rs.getString("classTitle");
            //String section = rs.getString("Section");
            //String room = rs.getString("Room");
            //String daysTime = rs.getString("Days");
            //String start = rs.getString("classStartTime");
            //String end = rs.getString("classEndTime");
            //String max = rs.getString("classMaxSize");
            //String current = rs.getString("CurrentSize");
            //String instructor = rs.getString("Instructor_idInstructor");
            String year = rs.getString("Year");
            String semester = rs.getString("Semester");
            //String credits = rs.getString("Credits");
            String grade = rs.getString("Grade");
            //Courses course = new Courses(ID, type, number, title, section, room, daysTime, start, end, max, current, instructor, year, semester, credits);
            Courses course= new Courses();
            course.setClassID(ID);
            course.setClassType(type);
            course.setClassNumber(number);
            course.setClassTitle(title);
            course.setYear(year);
            course.setSemester(semester);
            course.setGrade(grade);
            list.add(course);
        }
        return list;
    }
    
    public static List<Courses> getCurrentCourses(Connection conn, String studentID) throws SQLException {
        String sql = "SELECT * from classes inner join students_has_classes on  Classe_idClasse = idClass where Students_idStudents =?";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, studentID);
 
        ResultSet rs = pstm.executeQuery();
        List<Courses> list = new ArrayList<Courses>();
        while (rs.next()) {
        	
            String ID = rs.getString("idClass");
            String type = rs.getString("classType");
            String number = rs.getString("classNumber");
            String title = rs.getString("classTitle");
            String section = rs.getString("Section");
            String room = rs.getString("Room");
            String daysTime = rs.getString("Days");
            String start = rs.getString("classStartTime");
            String end = rs.getString("classEndTime");
            String max = rs.getString("classMaxSize");
            String current = rs.getString("CurrentSize");
            String instructor = rs.getString("Instructor_idInstructor");
            String year = rs.getString("Year");
            String semester = rs.getString("Semester");
            String credits = rs.getString("Credits");
            Courses course = new Courses(ID, type, number, title, section, room, daysTime, start, end, max, current, instructor, year, semester, credits);
            list.add(course);
        }
        return list;
    }
    
    public static List<Courses> searchCourses(Connection conn, String classType, String classNumber) throws SQLException {
        String sql = "SELECT * from classes  where classType=? and classNumber=?";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, classType);
        pstm.setString(2, classNumber);
        
        ResultSet rs = pstm.executeQuery();
        List<Courses> list = new ArrayList<Courses>();
        while (rs.next()) {
        	
            String ID = rs.getString("idClass");
            String type = rs.getString("classType");
            String number = rs.getString("classNumber");
            String title = rs.getString("classTitle");
            String section = rs.getString("Section");
            String room = rs.getString("Room");
            String daysTime = rs.getString("Days");
            String start = rs.getString("classStartTime");
            String end = rs.getString("classEndTime");
            String max = rs.getString("classMaxSize");
            String current = rs.getString("CurrentSize");
            String instructor = rs.getString("Instructor_idInstructor");
            String year = rs.getString("Year");
            String semester = rs.getString("Semester");
            String credits = rs.getString("Credits");
            Courses course = new Courses(ID, type, number, title, section, room, daysTime, start, end, max, current, instructor, year, semester, credits);
            list.add(course);
        }
        return list;
    }
    
    // the followingMethod will update students when they edit their info
    public static void updateStudent(Connection conn, UserAccount student) throws SQLException {
        String sql = "Update students set studentEmail =?, studentPhone=?, studentAddress=? where studentID=? ";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
 
        pstm.setString(1, student.getStudentEmail());
        pstm.setString(2, student.getStudentPhone());
        pstm.setString(3, student.getStudentAddress());
        pstm.setString(4, student.getStudentID());
        pstm.executeUpdate();
    }
 
    public static void insertRecordOfDrop(Connection conn, String classID, String studentID, String instructorID) throws SQLException {
    	//this method will make a record of a dropped class
    	String sql = "Insert into students_record_of_classes(Students_idStudents, Classe_idClasse, Classe_Instructor_idInstructor, Grade) values (?,?,?,?)";
        
        PreparedStatement pstm = conn.prepareStatement(sql);
 
        pstm.setString(1, studentID);
        pstm.setString(2, classID);
        pstm.setString(3, instructorID);
        pstm.setString(4, "W");
        pstm.executeUpdate();
    }
 
    public static void dropClass(Connection conn, String classID, String studentID) throws SQLException {
    	//this medthod will delete a class from the students current schedule
        String sql = "Delete From students_has_classes where Students_idStudents=? and Classe_idClasse=?";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, studentID);
        pstm.setString(2, classID);
        pstm.executeUpdate();
    }
    
    public static void addClass(Connection conn, String classID, String studentID, String instructorID) throws SQLException{
    	//this method will insert into table students students_has_classes
    	String sql = "Insert into students_has_classes(Students_idStudents, Classe_idClasse, Classe_Instructor_idInstructor) values(?,?,?)";
    	PreparedStatement pstm = conn.prepareStatement(sql);
    	pstm.setString(1, studentID);
        pstm.setString(2, classID);
        pstm.setString(3, instructorID);
        pstm.executeUpdate();
    	
    }
    
    public static void updateClassSizeDROP(Connection conn, String classID, String classCurrentSize) throws SQLException {
    	int x = Integer.parseInt(classCurrentSize);
    	System.out.println("CURRENT SIZE"+x);
    	x--;
    	System.out.println("UPDATED SIZE"+x);
    	
    	String sql = "Update classes set CurrentSize =? where idClass =?";
    	PreparedStatement pstm = conn.prepareStatement(sql);
    	pstm.setString(1, Integer.toString(x));
    	pstm.setString(2, classID);
    	pstm.executeUpdate();
    }
    
    public static void updateClassSizeADD(Connection conn, String classID, String classCurrentSize) throws SQLException {
    	int x = Integer.parseInt(classCurrentSize);
    	x++;
    	String sql = "Update classes set CurrentSize =? where idClass =?";
    	PreparedStatement pstm = conn.prepareStatement(sql);
    	pstm.setInt(1, x);
    	pstm.setString(2, classID);
    	pstm.executeUpdate();
    }
    
    public static void genEdsRequirementCheck(List<Courses> list, HttpServletRequest request) {
    	boolean Composition=false;
        boolean Eng108=false;
        boolean Eng109=false;
        for(Courses CR : list) {
        	if(CR.getClassType().equals("ENG") && CR.getClassNumber().equals("110")) {
        		if(CR.getGrade().equals("A")||CR.getGrade().equals("B")||CR.getGrade().equals("C")) {
        			Composition=true;
        		}
        	}
        	if(CR.getClassType().equals("ENG") && CR.getClassNumber().equals("112")) {
        		if(CR.getGrade().equals("A")||CR.getGrade().equals("B")||CR.getGrade().equals("C")) {
        			Composition=true;
        		}
        	}
        	if(CR.getClassType().equals("ENG") && CR.getClassNumber().equals("108")) {
        		if(CR.getGrade().equals("A")||CR.getGrade().equals("B")||CR.getGrade().equals("C")) {
        			Eng108=true;
        		}
        	}
        	if(CR.getClassType().equals("ENG") && CR.getClassNumber().equals("109")) {
        		if(CR.getGrade().equals("A")||CR.getGrade().equals("B")||CR.getGrade().equals("C")) {
        			Eng109=true;
        		}
        	}
        	if(Eng108 && Eng109) {
        		Composition=true;
        	}
        	//System.out.println("FROM SERVLET "+Composition);
        }
        request.setAttribute("Composition", Composition);
        
        //this loop checks part a section 2
        //actually this part should be taken by CSC121
        boolean Logic=false;
        if((boolean)request.getAttribute("CSC121")) {
        	Logic=true;
        }
        else {
        	for(Courses CR : list) {
            	if(CR.getClassType().equals("MAT") && CR.getClassNumber().equals("271")) {
            		if(CR.getGrade().equals("A")||CR.getGrade().equals("B")||CR.getGrade().equals("C")) {
            			Logic=true;
            		}
            	}
            	if(CR.getClassType().equals("PHI") && CR.getClassNumber().equals("120")) {
            		if(CR.getGrade().equals("A")||CR.getGrade().equals("B")||CR.getGrade().equals("C")) {
            			Logic=true;
            		}
            	}
            	if(CR.getClassType().equals("PSY") && CR.getClassNumber().equals("110")) {
            		if(CR.getGrade().equals("A")||CR.getGrade().equals("B")||CR.getGrade().equals("C")) {
            			Logic=true;
            		}
            	}
            }
        }
        request.setAttribute("Logic", Logic);
        
        //this loop checks part a section 3
        boolean Oral=false;
        for(Courses CR : list) {
        	if(CR.getClassType().equals("THE") && CR.getClassNumber().equals("120")) {
        		if(CR.getGrade().equals("A")||CR.getGrade().equals("B")||CR.getGrade().equals("C")) {
        			Oral=true;
        		}
        	}
        }
        request.setAttribute("Oral", Oral);
        
        //this loop checks part b section 1
        boolean Physical=false;
        for(Courses CR : list) {
        	if(CR.getClassType().equals("CHE") && CR.getClassNumber().equals("102")) {
        		if(CR.getGrade().equals("A")||CR.getGrade().equals("B")||CR.getGrade().equals("C")) {
        			Physical=true;
        		}
        	}
        	if(CR.getClassType().equals("EAR") && CR.getClassNumber().equals("100")) {
        		if(CR.getGrade().equals("A")||CR.getGrade().equals("B")||CR.getGrade().equals("C")) {
        			Physical=true;
        		}
        	}
        	if(CR.getClassType().equals("GEO") && CR.getClassNumber().equals("200")) {
        		if(CR.getGrade().equals("A")||CR.getGrade().equals("B")||CR.getGrade().equals("C")) {
        			Physical=true;
        		}
        	}
        	if(CR.getClassType().equals("PHY") && CR.getClassNumber().equals("100")) {
        		if(CR.getGrade().equals("A")||CR.getGrade().equals("B")||CR.getGrade().equals("C")) {
        			Physical=true;
        		}
        	}
        }
        request.setAttribute("Physical", Physical);
        
        //this loop checks part b sec 2
        boolean Life=false;
        for(Courses CR : list) {
        	if(CR.getClassType().equals("ANT") && CR.getClassNumber().equals("101")) {
        		if(CR.getGrade().equals("A")||CR.getGrade().equals("B")||CR.getGrade().equals("C")) {
        			Life=true;
        		}
        	}
        	if(CR.getClassType().equals("BIO") && CR.getClassNumber().equals("102")) {
        		if(CR.getGrade().equals("A")||CR.getGrade().equals("B")||CR.getGrade().equals("C")) {
        			Life=true;
        		}
        	}
        }
        request.setAttribute("Life", Life);
        
        //
        boolean ScienceLab=false;
        for(Courses CR : list) {
        	if(CR.getClassType().equals("BIO") && CR.getClassNumber().equals("103")) {
        		if(CR.getGrade().equals("A")||CR.getGrade().equals("B")||CR.getGrade().equals("C")) {
        			ScienceLab=true;
        		}
        	}
        	if(CR.getClassType().equals("EAR") && CR.getClassNumber().equals("101")) {
        		if(CR.getGrade().equals("A")||CR.getGrade().equals("B")||CR.getGrade().equals("C")) {
        			ScienceLab=true;
        		}
        	}
        	if(CR.getClassType().equals("CHE") && CR.getClassNumber().equals("103")) {
        		if(CR.getGrade().equals("A")||CR.getGrade().equals("B")||CR.getGrade().equals("C")) {
        			ScienceLab=true;
        		}
        	}
        }
        request.setAttribute("ScienceLab", ScienceLab);
        
        //part b sec 4
        boolean Quantitative=false;
        for(Courses CR : list) {
        	if(CR.getClassType().equals("MAT")) {
        		if(CR.getClassNumber().contentEquals("105")||CR.getClassNumber().contentEquals("131")||
        				CR.getClassNumber().contentEquals("132")||CR.getClassNumber().contentEquals("151")||
        				CR.getClassNumber().contentEquals("153")||CR.getClassNumber().contentEquals("171")||
        				CR.getClassNumber().contentEquals("191")||CR.getClassNumber().contentEquals("193")) {
        			if(CR.getGrade().equals("A")||CR.getGrade().equals("B")||CR.getGrade().equals("C")) {
        				Quantitative=true;
            		}
        			
        		}
        	}
        }
        request.setAttribute("Quantitative", Quantitative);
        
        //part c sec 1,2,3
        int artCounter=0, letterCounter=0;
        boolean Letters=false;
        boolean Arts=false;
        boolean Humanities=false;
        for(Courses CR : list) {
        	if(		  (CR.getClassType().equals("AFS") && CR.getClassNumber().equals("205"))
        			||(CR.getClassType().equals("APP") && CR.getClassNumber().equals("225"))
        			||(CR.getClassType().equals("ART") && CR.getClassNumber().equals("100"))
        			||(CR.getClassType().equals("ART") && CR.getClassNumber().equals("101"))
        			||(CR.getClassType().equals("CHS") && CR.getClassNumber().equals("125"))
        			||(CR.getClassType().equals("COM") && CR.getClassNumber().equals("130"))
        			||(CR.getClassType().equals("DAN") && CR.getClassNumber().equals("130"))
        			||(CR.getClassType().equals("ENG") && CR.getClassNumber().equals("271"))
        			||(CR.getClassType().equals("MUS") && CR.getClassNumber().equals("101"))
        			||(CR.getClassType().equals("MUS") && CR.getClassNumber().equals("110"))
        			||(CR.getClassType().equals("MUS") && CR.getClassNumber().equals("201"))
        			||(CR.getClassType().equals("MUS") && CR.getClassNumber().equals("250"))
        			||(CR.getClassType().equals("THE") && CR.getClassNumber().equals("100"))
        			||(CR.getClassType().equals("THE") && CR.getClassNumber().equals("160"))) {
        		if(CR.getGrade().equals("A")||CR.getGrade().equals("B")||CR.getGrade().equals("C")) {
        			Arts=true;
        			artCounter++;
        		}
        	}
        	if(		  (CR.getClassType().equals("AFS") && CR.getClassNumber().equals("200"))
        			||(CR.getClassType().equals("AFS") && CR.getClassNumber().equals("231"))
        			||(CR.getClassType().equals("APP") && CR.getClassNumber().equals("101"))
        			||(CR.getClassType().equals("APP") && CR.getClassNumber().equals("201"))
        			||(CR.getClassType().equals("CHS") && CR.getClassNumber().equals("100"))
        			||(CR.getClassType().equals("CHS") && CR.getClassNumber().equals("205"))
        			||(CR.getClassType().equals("COM") && CR.getClassNumber().equals("100"))
        			||(CR.getClassType().equals("ENG") && CR.getClassNumber().equals("230"))
        			||(CR.getClassType().equals("FRE") && CR.getClassNumber().equals("220"))
        			||(CR.getClassType().equals("HUM") && CR.getClassNumber().equals("200"))
        			||(CR.getClassType().equals("HUM") && CR.getClassNumber().equals("212"))
        			||(CR.getClassType().equals("JPN") && CR.getClassNumber().equals("110"))
        			||(CR.getClassType().equals("JPN") && CR.getClassNumber().equals("111"))
        			||(CR.getClassType().equals("PHI") && CR.getClassNumber().equals("101"))
        			||(CR.getClassType().equals("PHI") && CR.getClassNumber().equals("102"))
        			||(CR.getClassType().equals("PHI") && CR.getClassNumber().equals("201"))
        			||(CR.getClassType().equals("PHI") && CR.getClassNumber().equals("202"))
        			||(CR.getClassType().equals("SPA") && CR.getClassNumber().equals("151"))
        			||(CR.getClassType().equals("SPA") && CR.getClassNumber().equals("221"))
        			||(CR.getClassType().equals("WMS") && CR.getClassNumber().equals("100"))) {
        		if(CR.getGrade().equals("A")||CR.getGrade().equals("B")||CR.getGrade().equals("C")) {
        			Letters=true;
        			letterCounter++;
        		}
        	}
        	if(artCounter>=2||letterCounter>=2) {
        		if(Letters && Arts) {
        			Humanities=true;
        		}
        	}
        }
        request.setAttribute("Arts", Arts);
        request.setAttribute("Letters", Letters);
        request.setAttribute("Humanities", Humanities);
        
        //part d sec 1 2 3 
        int societyCounter=0, globalCounter=0;
        boolean Society=false;
        boolean Global=false;
        boolean Social=false;
        for(Courses CR : list) {
        	if(		  (CR.getClassType().equals("AFS") && CR.getClassNumber().equals("100"))
        			||(CR.getClassType().equals("AFS") && CR.getClassNumber().equals("220"))
        			||(CR.getClassType().equals("ANT") && CR.getClassNumber().equals("100"))
        			||(CR.getClassType().equals("APP") && CR.getClassNumber().equals("212"))
        			||(CR.getClassType().equals("CHS") && CR.getClassNumber().equals("212"))
        			||(CR.getClassType().equals("ECO") && CR.getClassNumber().equals("210"))
        			||(CR.getClassType().equals("ECO") && CR.getClassNumber().equals("211"))
        			||(CR.getClassType().equals("IDS") && CR.getClassNumber().equals("210"))
        			||(CR.getClassType().equals("LBS") && CR.getClassNumber().equals("205"))
        			||(CR.getClassType().equals("LAW") && CR.getClassNumber().equals("240"))
        			||(CR.getClassType().equals("PSY") && CR.getClassNumber().equals("101"))
        			||(CR.getClassType().equals("SOC") && CR.getClassNumber().equals("101"))
        			||(CR.getClassType().equals("SOC") && CR.getClassNumber().equals("102"))
        			||(CR.getClassType().equals("WMS") && CR.getClassNumber().equals("250"))) {
        		if(CR.getGrade().equals("A")||CR.getGrade().equals("B")||CR.getGrade().equals("C")) {
        			Society=true;
        			societyCounter++;
        		}
        	}
        	if(		  (CR.getClassType().equals("AFS") && CR.getClassNumber().equals("201"))
        			||(CR.getClassType().equals("ANT") && CR.getClassNumber().equals("102"))
        			||(CR.getClassType().equals("CHS") && CR.getClassNumber().equals("200"))
        			||(CR.getClassType().equals("ENG") && CR.getClassNumber().equals("150"))
        			||(CR.getClassType().equals("GEO") && CR.getClassNumber().equals("100"))
        			||(CR.getClassType().equals("HIS") && CR.getClassNumber().equals("120"))
        			||(CR.getClassType().equals("HIS") && CR.getClassNumber().equals("121"))
        			||(CR.getClassType().equals("LBR") && CR.getClassNumber().equals("200"))
        			||(CR.getClassType().equals("MGT") && CR.getClassNumber().equals("200"))
        			||(CR.getClassType().equals("POL") && CR.getClassNumber().equals("100"))) {
        		if(CR.getGrade().equals("A")||CR.getGrade().equals("B")||CR.getGrade().equals("C")) {
        			Global=true;
        			globalCounter++;
        		}
        	}
        	if(societyCounter>=2||globalCounter>=2) {
        		if(Global && Society) {
        			Social=true;
        		}
        	}
        }
        request.setAttribute("Society", Society);
        request.setAttribute("Global", Global);
        request.setAttribute("Social", Social);
        
        //part e 
        boolean Lifelong=false;
        for(Courses CR : list) {
        	if(		  (CR.getClassType().equals("BUS") && CR.getClassNumber().equals("100"))
        			||(CR.getClassType().equals("CIS") && CR.getClassNumber().equals("275"))
        			||(CR.getClassType().equals("FIN") && CR.getClassNumber().equals("200"))
        			||(CR.getClassType().equals("HEA") && CR.getClassNumber().equals("100"))
        			||(CR.getClassType().equals("HEA") && CR.getClassNumber().equals("201"))
        			||(CR.getClassType().equals("KIN") && CR.getClassNumber().equals("235"))
        			||(CR.getClassType().equals("LIB") && CR.getClassNumber().equals("151"))
        			||(CR.getClassType().equals("REC") && CR.getClassNumber().equals("100"))
        			||(CR.getClassType().equals("UNV") && CR.getClassNumber().equals("101"))) {
        		if(CR.getGrade().equals("A")||CR.getGrade().equals("B")||CR.getGrade().equals("C")) {
        			Lifelong=true;
        		}
        	}
        }
        request.setAttribute("Lifelong", Lifelong);
        
        //part f sec 1 2 3
        boolean IntegrativeHumanities=false;
        boolean IntegrativeNatural=false;
        boolean IntegrativeSocial=false;
        for(Courses CR : list) {
        	if(		  (CR.getClassType().equals("AFS") && CR.getClassNumber().equals("331"))
        			||(CR.getClassType().equals("AFS") && CR.getClassNumber().equals("332"))
        			||(CR.getClassType().equals("AFS") && CR.getClassNumber().equals("333"))
        			||(CR.getClassType().equals("AFS") && CR.getClassNumber().equals("334"))
        			||(CR.getClassType().equals("APP") && CR.getClassNumber().equals("314"))
        			||(CR.getClassType().equals("APP") && CR.getClassNumber().equals("315"))
        			||(CR.getClassType().equals("APP") && CR.getClassNumber().equals("325"))
        			||(CR.getClassType().equals("APP") && CR.getClassNumber().equals("339"))
        			||(CR.getClassType().equals("APP") && CR.getClassNumber().equals("343"))
        			||(CR.getClassType().equals("ARH") && CR.getClassNumber().equals("370"))
        			||(CR.getClassType().equals("CHS") && CR.getClassNumber().equals("340"))
        			||(CR.getClassType().equals("CHS") && CR.getClassNumber().equals("345"))
        			||(CR.getClassType().equals("ENG") && CR.getClassNumber().equals("308"))
        			||(CR.getClassType().equals("HIS") && CR.getClassNumber().equals("355"))
        			||(CR.getClassType().equals("HIS") && CR.getClassNumber().equals("375"))
        			||(CR.getClassType().equals("HIS") && CR.getClassNumber().equals("376"))
        			||(CR.getClassType().equals("HUM") && CR.getClassNumber().equals("310"))
        			||(CR.getClassType().equals("HUM") && CR.getClassNumber().equals("312"))
        			||(CR.getClassType().equals("HUM") && CR.getClassNumber().equals("314"))
        			||(CR.getClassType().equals("IDS") && CR.getClassNumber().equals("312"))
        			||(CR.getClassType().equals("LBR") && CR.getClassNumber().equals("310"))
        			||(CR.getClassType().equals("LBR") && CR.getClassNumber().equals("312"))
        			||(CR.getClassType().equals("LBR") && CR.getClassNumber().equals("314"))
        			||(CR.getClassType().equals("MUS") && CR.getClassNumber().equals("312"))
        			||(CR.getClassType().equals("MUS") && CR.getClassNumber().equals("345"))
        			||(CR.getClassType().equals("MUS") && CR.getClassNumber().equals("486"))
        			||(CR.getClassType().equals("PHI") && CR.getClassNumber().equals("351"))
        			||(CR.getClassType().equals("PHI") && CR.getClassNumber().equals("352"))
        			||(CR.getClassType().equals("PHI") && CR.getClassNumber().equals("353"))
        			||(CR.getClassType().equals("PHI") && CR.getClassNumber().equals("383"))
        			||(CR.getClassType().equals("SPA") && CR.getClassNumber().equals("310"))
        			||(CR.getClassType().equals("SPA") && CR.getClassNumber().equals("312"))
        			||(CR.getClassType().equals("SPA") && CR.getClassNumber().equals("313"))
        			||(CR.getClassType().equals("THE") && CR.getClassNumber().equals("313"))
        			||(CR.getClassType().equals("THE") && CR.getClassNumber().equals("315"))
        			||(CR.getClassType().equals("THE") && CR.getClassNumber().equals("317"))
        			||(CR.getClassType().equals("THE") && CR.getClassNumber().equals("319"))
        			||(CR.getClassType().equals("WMS") && CR.getClassNumber().equals("310"))
        			||(CR.getClassType().equals("WMS") && CR.getClassNumber().equals("311"))
        			||(CR.getClassType().equals("WMS") && CR.getClassNumber().equals("314"))
        			||(CR.getClassType().equals("WMS") && CR.getClassNumber().equals("315"))) {
        		if(CR.getGrade().equals("A")||CR.getGrade().equals("B")||CR.getGrade().equals("C")) {
        			IntegrativeHumanities=true;
        		}
        	}
        	//this should be filled by CSC301
        	if((boolean)request.getAttribute("CSC301")) {
        		IntegrativeNatural=true;
        	}
        	else {
        		if(		  (CR.getClassType().equals("BIO") && CR.getClassNumber().equals("336"))
            			||(CR.getClassType().equals("BIO") && CR.getClassNumber().equals("340"))
            			||(CR.getClassType().equals("CSC") && CR.getClassNumber().equals("301"))
            			||(CR.getClassType().equals("EAR") && CR.getClassNumber().equals("312"))
            			||(CR.getClassType().equals("EAR") && CR.getClassNumber().equals("416"))
            			||(CR.getClassType().equals("IDS") && CR.getClassNumber().equals("310"))
            			||(CR.getClassType().equals("LBS") && CR.getClassNumber().equals("380"))
            			||(CR.getClassType().equals("SMT") && CR.getClassNumber().equals("310"))
            			||(CR.getClassType().equals("SMT") && CR.getClassNumber().equals("314"))) {
            		if(CR.getGrade().equals("A")||CR.getGrade().equals("B")||CR.getGrade().equals("C")) {
            			IntegrativeNatural=true;
            		}
        		}
        	}
        	if(		  (CR.getClassType().equals("AFS") && CR.getClassNumber().equals("310"))
        			||(CR.getClassType().equals("AFS") && CR.getClassNumber().equals("311"))
        			||(CR.getClassType().equals("AFS") && CR.getClassNumber().equals("312"))
        			||(CR.getClassType().equals("ANT") && CR.getClassNumber().equals("312"))
        			||(CR.getClassType().equals("ANT") && CR.getClassNumber().equals("334"))
        			||(CR.getClassType().equals("ANT") && CR.getClassNumber().equals("336"))
        			||(CR.getClassType().equals("ANT") && CR.getClassNumber().equals("337"))
        			||(CR.getClassType().equals("ANT") && CR.getClassNumber().equals("338"))
        			||(CR.getClassType().equals("ANT") && CR.getClassNumber().equals("342"))
        			||(CR.getClassType().equals("ANT") && CR.getClassNumber().equals("371"))
        			||(CR.getClassType().equals("APP") && CR.getClassNumber().equals("311"))
        			||(CR.getClassType().equals("APP") && CR.getClassNumber().equals("318"))
        			||(CR.getClassType().equals("APP") && CR.getClassNumber().equals("327"))
        			||(CR.getClassType().equals("APP") && CR.getClassNumber().equals("350"))
        			||(CR.getClassType().equals("APP") && CR.getClassNumber().equals("335"))
        			||(CR.getClassType().equals("CHS") && CR.getClassNumber().equals("323"))
        			||(CR.getClassType().equals("CHS") && CR.getClassNumber().equals("330"))
        			||(CR.getClassType().equals("CHS") && CR.getClassNumber().equals("335"))
        			||(CR.getClassType().equals("GEO") && CR.getClassNumber().equals("318"))
        			||(CR.getClassType().equals("HEA") && CR.getClassNumber().equals("468"))
        			||(CR.getClassType().equals("HIS") && CR.getClassNumber().equals("340"))
        			||(CR.getClassType().equals("HIS") && CR.getClassNumber().equals("348"))
        			||(CR.getClassType().equals("HIS") && CR.getClassNumber().equals("352"))
        			||(CR.getClassType().equals("HIS") && CR.getClassNumber().equals("354"))
        			||(CR.getClassType().equals("HIS") && CR.getClassNumber().equals("380"))
        			||(CR.getClassType().equals("IDS") && CR.getClassNumber().equals("304"))
        			||(CR.getClassType().equals("IDS") && CR.getClassNumber().equals("318"))
        			||(CR.getClassType().equals("LBS") && CR.getClassNumber().equals("370"))
        			||(CR.getClassType().equals("SBS") && CR.getClassNumber().equals("318"))
        			||(CR.getClassType().equals("WMS") && CR.getClassNumber().equals("318"))) {
        		if(CR.getGrade().equals("A")||CR.getGrade().equals("B")||CR.getGrade().equals("C")) {
        			IntegrativeSocial=true;
        		}
        	}
        }
        request.setAttribute("IntegrativeHumanities", IntegrativeHumanities);
        request.setAttribute("IntegrativeNatural", IntegrativeNatural);
        request.setAttribute("IntegrativeSocial", IntegrativeSocial);
    }
    
    public static void coreRequirementCheck(List<Courses> list, HttpServletRequest request) {
		//lower division
    	boolean CSC121=false;
		boolean CSC123=false;
		boolean CSC221=false;
		boolean CSC2xx=false;
		boolean MAT191=false;
		boolean MAT193=false;
		boolean MAT271=false;
		boolean MAT281=false;
		boolean PHY130=false;
		boolean	PHY132=false;
		//upper division
		//core
		boolean CSC311=false;
		boolean CSC321=false;
		boolean CSC331=false;
		boolean CSC341=false;
		//required
		boolean CSC301=false;
		boolean CSC401=false;
		boolean CSC481=false;
		boolean CSC492=false;
		boolean MAT321=false;
		boolean CSC471=false;
		//electives
		boolean CSCElective1=false;
		boolean CSCElective2=false;
		
    	for(Courses CR : list) {
			if(CR.getClassType().equals("CSC") && CR.getClassNumber().equals("121")) {
				if(CR.getGrade().equals("A")||CR.getGrade().equals("B")||CR.getGrade().equals("C")) {
					CSC121=true;
					//NOTE: THIS CLASS CAN BE USED TO MEET THE GEN ED REQ FOR A-2
					//MAYBE ADD A WAY TO CHECK THAT GEN ED WHEN THIS CLASS IS DONE
				}
			}
		}
    	for(Courses CR : list) {
			if(CR.getClassType().equals("CSC") && CR.getClassNumber().equals("123")) {
				if(CR.getGrade().equals("A")||CR.getGrade().equals("B")||CR.getGrade().equals("C")) {
					CSC123=true;
				}
			}
		}
    	for(Courses CR : list) {
			if(CR.getClassType().equals("CSC") && CR.getClassNumber().equals("221")) {
				if(CR.getGrade().equals("A")||CR.getGrade().equals("B")||CR.getGrade().equals("C")) {
					CSC221=true;
				}
			}
		}
    	for(Courses CR : list) {
			if(CR.getClassType().equals("CSC")) {
				if(		CR.getClassNumber().equals("251")||CR.getClassNumber().equals("255")||
						CR.getClassNumber().equals("295")) {
					if(CR.getGrade().equals("A")||CR.getGrade().equals("B")||CR.getGrade().equals("C")) {
						CSC2xx=true;
					}
				}
			}
		}
    	for(Courses CR : list) {
			if(CR.getClassType().equals("MAT") && CR.getClassNumber().equals("191")) {
				if(CR.getGrade().equals("A")||CR.getGrade().equals("B")||CR.getGrade().equals("C")) {
					MAT191=true;
				}
			}
		}
    	for(Courses CR : list) {
			if(CR.getClassType().equals("MAT") && CR.getClassNumber().equals("193")) {
				if(CR.getGrade().equals("A")||CR.getGrade().equals("B")||CR.getGrade().equals("C")) {
					MAT193=true;
				}
			}
		}
    	for(Courses CR : list) {
			if(CR.getClassType().equals("MAT") && CR.getClassNumber().equals("271")) {
				if(CR.getGrade().equals("A")||CR.getGrade().equals("B")||CR.getGrade().equals("C")) {
					MAT271=true;
				}
			}
		}
    	for(Courses CR : list) {
			if(CR.getClassType().equals("MAT") && CR.getClassNumber().equals("281")) {
				if(CR.getGrade().equals("A")||CR.getGrade().equals("B")||CR.getGrade().equals("C")) {
					MAT281=true;
				}
			}
		}
    	for(Courses CR : list) {
			if(CR.getClassType().equals("PHY") && CR.getClassNumber().equals("130")) {
				if(CR.getGrade().equals("A")||CR.getGrade().equals("B")||CR.getGrade().equals("C")) {
					PHY130=true;
				}
			}
		}
    	for(Courses CR : list) {
			if(CR.getClassType().equals("PHY") && CR.getClassNumber().equals("132")) {
				if(CR.getGrade().equals("A")||CR.getGrade().equals("B")||CR.getGrade().equals("C")) {
					PHY132=true;
				}
			}
		}
    	//core
    	for(Courses CR : list) {
			if(CR.getClassType().equals("CSC") && CR.getClassNumber().equals("311")) {
				if(CR.getGrade().equals("A")||CR.getGrade().equals("B")||CR.getGrade().equals("C")) {
					CSC311=true;
				}
			}
		}
    	for(Courses CR : list) {
			if(CR.getClassType().equals("CSC") && CR.getClassNumber().equals("321")) {
				if(CR.getGrade().equals("A")||CR.getGrade().equals("B")||CR.getGrade().equals("C")) {
					CSC321=true;
				}
			}
		}
    	for(Courses CR : list) {
			if(CR.getClassType().equals("CSC") && CR.getClassNumber().equals("331")) {
				if(CR.getGrade().equals("A")||CR.getGrade().equals("B")||CR.getGrade().equals("C")) {
					CSC331=true;
				}
			}
		}
    	for(Courses CR : list) {
			if(CR.getClassType().equals("CSC") && CR.getClassNumber().equals("341")) {
				if(CR.getGrade().equals("A")||CR.getGrade().equals("B")||CR.getGrade().equals("C")) {
					CSC341=true;
				}
			}
		}
    	//core
    	for(Courses CR : list) {
			if(CR.getClassType().equals("CSC") && CR.getClassNumber().equals("301")) {
				if(CR.getGrade().equals("A")||CR.getGrade().equals("B")||CR.getGrade().equals("C")) {
					CSC301=true;
					//NOTE: THIS COULD MEET GEN ED REQ F-2
				}
			}
		}
    	for(Courses CR : list) {
			if(CR.getClassType().equals("CSC") && CR.getClassNumber().equals("401")) {
				if(CR.getGrade().equals("A")||CR.getGrade().equals("B")||CR.getGrade().equals("C")) {
					CSC401=true;
				}
			}
		}
    	for(Courses CR : list) {
			if(CR.getClassType().equals("CSC") && CR.getClassNumber().equals("481")) {
				if(CR.getGrade().equals("A")||CR.getGrade().equals("B")||CR.getGrade().equals("C")) {
					CSC481=true;
				}
			}
		}
    	for(Courses CR : list) {
			if(CR.getClassType().equals("CSC") && CR.getClassNumber().equals("492")) {
				if(CR.getGrade().equals("A")||CR.getGrade().equals("B")||CR.getGrade().equals("C")) {
					CSC492=true;
				}
			}
		}
    	for(Courses CR : list) {
			if(CR.getClassType().equals("MAT") && CR.getClassNumber().equals("321")) {
				if(CR.getGrade().equals("A")||CR.getGrade().equals("B")||CR.getGrade().equals("C")) {
					MAT321=true;
				}
			}
		}
    	for(Courses CR : list) {
			if(CR.getClassType().equals("CSC") && CR.getClassNumber().equals("471")) {
				if(CR.getGrade().equals("A")||CR.getGrade().equals("B")||CR.getGrade().equals("C")) {
					CSC471=true;
				}
			}
		}
    	//electives
    	for(Courses CR : list) {
			if(CR.getClassType().equals("CSC") && !(CSCElective1)) {
				if(		CR.getClassNumber().equals("395")||CR.getClassNumber().equals("411")||
						CR.getClassNumber().equals("421")||CR.getClassNumber().equals("431")||
						CR.getClassNumber().equals("441")||CR.getClassNumber().equals("451")||
						CR.getClassNumber().equals("453")||CR.getClassNumber().equals("455")||
						CR.getClassNumber().equals("459")||CR.getClassNumber().equals("461")||
						CR.getClassNumber().equals("463")||CR.getClassNumber().equals("471")||
						CR.getClassNumber().equals("490")||CR.getClassNumber().equals("495")) {
					if(CR.getGrade().equals("A")||CR.getGrade().equals("B")||CR.getGrade().equals("C")) {
						CSCElective1=true;
					}
				}
			}
			if(CR.getClassType().contentEquals("MAT") && !(CSCElective1)) {
				if(CR.getClassNumber().equals("367")||CR.getClassNumber().equals("369")) {
					if(CR.getGrade().equals("A")||CR.getGrade().equals("B")||CR.getGrade().equals("C")) {
						CSCElective1=true;
					}
				}
			}
			if(CR.getClassType().equals("CSC") && (CSCElective1)) {
				if(		CR.getClassNumber().equals("395")||CR.getClassNumber().equals("411")||
						CR.getClassNumber().equals("421")||CR.getClassNumber().equals("431")||
						CR.getClassNumber().equals("441")||CR.getClassNumber().equals("451")||
						CR.getClassNumber().equals("453")||CR.getClassNumber().equals("455")||
						CR.getClassNumber().equals("459")||CR.getClassNumber().equals("461")||
						CR.getClassNumber().equals("463")||CR.getClassNumber().equals("471")||
						CR.getClassNumber().equals("490")||CR.getClassNumber().equals("495")) {
					if(CR.getGrade().equals("A")||CR.getGrade().equals("B")||CR.getGrade().equals("C")) {
						CSCElective2=true;
					}
				}
			}
			if(CR.getClassType().contentEquals("MAT") && (CSCElective1)) {
				if(CR.getClassNumber().equals("367")||CR.getClassNumber().equals("369")) {
					if(CR.getGrade().equals("A")||CR.getGrade().equals("B")||CR.getGrade().equals("C")) {
						CSCElective2=true;
					}
				}
			}
		}
    	request.setAttribute("CSC121", CSC121);
    	request.setAttribute("CSC123", CSC123);
    	request.setAttribute("CSC221", CSC221);
    	request.setAttribute("CSC2xx", CSC2xx);
    	request.setAttribute("MAT191", MAT191);
    	request.setAttribute("MAT193", MAT193);
    	request.setAttribute("MAT271", MAT271);
    	request.setAttribute("MAT281", MAT281);
    	request.setAttribute("PHY130", PHY130);
    	request.setAttribute("PHY132", PHY132);
    	request.setAttribute("CSC311", CSC311);
    	request.setAttribute("CSC321", CSC321);
    	request.setAttribute("CSC331", CSC331);
    	request.setAttribute("CSC341", CSC341);
    	request.setAttribute("CSC301", CSC301);
    	request.setAttribute("CSC401", CSC401);
    	request.setAttribute("CSC481", CSC481);
    	request.setAttribute("CSC492", CSC492);
    	request.setAttribute("MAT321", MAT321);
    	request.setAttribute("CSC471", CSC471);
    	request.setAttribute("CSCElective1", CSCElective1);
    	request.setAttribute("CSCElective2", CSCElective2);
    }
      
    public static List<Courses> AutoPlannerVersion1(Connection conn, HttpServletRequest request, String studentID) throws SQLException {
    	//need to come up with a way to save this list and have it only run once even when called multiple times
    	int a= 0, x=0;
    	List<Courses> curr=null;
    	Courses Suggestion=null;
    	curr=DBUtils.getCurrentCourses(conn, studentID);
    	for(Courses cc:curr) {
    		a+=Integer.parseInt(cc.getCredits());
    	}
    	List<Courses> Suggestions = new ArrayList<Courses>();
    	
    	while(x<6) {
    		Suggestion=DBUtils.addClassSuggestion(request);
    		//System.out.println("Befor "+a);
    		a+=Integer.parseInt(Suggestion.getCredits());
    		//System.out.println("After "+a);
    		if(a<=18) {
    			Suggestions.add(Suggestion);
    		}
    		if(a>18) {
    			break;
    		}
    		x++;
    	}
    	
    	return Suggestions;
    }
    

    public static void inProgressCheck(List<Courses> list, HttpServletRequest request) {
    	//List<Courses> list=null;
    	//list=DBUtils.getCurrentCourses(conn, studentID);
		//lower division
    	boolean CSC121IP=false;
		boolean CSC123IP=false;
		boolean CSC221IP=false;
		boolean CSC2xxIP=false;
		boolean MAT191IP=false;
		boolean MAT193IP=false;
		boolean MAT271IP=false;
		boolean MAT281IP=false;
		boolean PHY130IP=false;
		boolean	PHY132IP=false;
		//upper division
		//core
		boolean CSC311IP=false;
		boolean CSC321IP=false;
		boolean CSC331IP=false;
		boolean CSC341IP=false;
		//required
		boolean CSC301IP=false;
		boolean CSC401IP=false;
		boolean CSC481IP=false;
		boolean CSC492IP=false;
		boolean MAT321IP=false;
		boolean CSC471IP=false;
		//electives
		boolean CSCElective1IP=false;
		boolean CSCElective2IP=false;
		
    	for(Courses CR : list) {
			if(CR.getClassType().equals("CSC") && CR.getClassNumber().equals("121")) {
				CSC121IP=true;
			}
		}
    	for(Courses CR : list) {
			if(CR.getClassType().equals("CSC") && CR.getClassNumber().equals("123")) {
				CSC123IP=true;
			}
		}
    	for(Courses CR : list) {
			if(CR.getClassType().equals("CSC") && CR.getClassNumber().equals("221")) {
				CSC221IP=true;
			}
		}
    	for(Courses CR : list) {
			if(CR.getClassType().equals("CSC")) {
				if(		CR.getClassNumber().equals("251")||CR.getClassNumber().equals("255")||
						CR.getClassNumber().equals("295")) {
					CSC2xxIP=true;
				}
			}
		}
    	for(Courses CR : list) {
			if(CR.getClassType().equals("MAT") && CR.getClassNumber().equals("191")) {
				MAT191IP=true;
			}
		}
    	for(Courses CR : list) {
			if(CR.getClassType().equals("MAT") && CR.getClassNumber().equals("193")) {
				MAT193IP=true;
			}
		}
    	for(Courses CR : list) {
			if(CR.getClassType().equals("MAT") && CR.getClassNumber().equals("271")) {
				MAT271IP=true;
			}
		}
    	for(Courses CR : list) {
			if(CR.getClassType().equals("MAT") && CR.getClassNumber().equals("281")) {
				MAT281IP=true;
			}
		}
    	for(Courses CR : list) {
			if(CR.getClassType().equals("PHY") && CR.getClassNumber().equals("130")) {
				PHY130IP=true;
			}
		}
    	for(Courses CR : list) {
			if(CR.getClassType().equals("PHY") && CR.getClassNumber().equals("132")) {
				PHY132IP=true;
			}
		}
    	//core
    	for(Courses CR : list) {
			if(CR.getClassType().equals("CSC") && CR.getClassNumber().equals("311")) {
				CSC311IP=true;
			}
		}
    	for(Courses CR : list) {
			if(CR.getClassType().equals("CSC") && CR.getClassNumber().equals("321")) {
				CSC321IP=true;
			}
		}
    	for(Courses CR : list) {
			if(CR.getClassType().equals("CSC") && CR.getClassNumber().equals("331")) {
				CSC331IP=true;
			}
		}
    	for(Courses CR : list) {
			if(CR.getClassType().equals("CSC") && CR.getClassNumber().equals("341")) {
				CSC341IP=true;
			}
		}
    	//core
    	for(Courses CR : list) {
			if(CR.getClassType().equals("CSC") && CR.getClassNumber().equals("301")) {
				CSC301IP=true;
				//NOTE: THIS COULD MEET GEN ED REQ F-2
			}
		}
    	for(Courses CR : list) {
			if(CR.getClassType().equals("CSC") && CR.getClassNumber().equals("401")) {
				CSC401IP=true;
			}
		}
    	for(Courses CR : list) {
			if(CR.getClassType().equals("CSC") && CR.getClassNumber().equals("481")) {
				CSC481IP=true;
			}
		}
    	for(Courses CR : list) {
			if(CR.getClassType().equals("CSC") && CR.getClassNumber().equals("492")) {
				CSC492IP=true;
			}
		}
    	for(Courses CR : list) {
			if(CR.getClassType().equals("MAT") && CR.getClassNumber().equals("321")) {
				MAT321IP=true;
			}
		}
    	for(Courses CR : list) {
			if(CR.getClassType().equals("CSC") && CR.getClassNumber().equals("471")) {
				CSC471IP=true;
			}
		}
    	//electives
    	for(Courses CR : list) {
			if(CR.getClassType().equals("CSC") && !(CSCElective1IP)) {
				if(		CR.getClassNumber().equals("395")||CR.getClassNumber().equals("411")||
						CR.getClassNumber().equals("421")||CR.getClassNumber().equals("431")||
						CR.getClassNumber().equals("441")||CR.getClassNumber().equals("451")||
						CR.getClassNumber().equals("453")||CR.getClassNumber().equals("455")||
						CR.getClassNumber().equals("459")||CR.getClassNumber().equals("461")||
						CR.getClassNumber().equals("463")||CR.getClassNumber().equals("471")||
						CR.getClassNumber().equals("490")||CR.getClassNumber().equals("495")) {
					CSCElective1IP=true;
				}
			}
			if(CR.getClassType().contentEquals("MAT") && !(CSCElective1IP)) {
				if(CR.getClassNumber().equals("367")||CR.getClassNumber().equals("369")) {
					CSCElective1IP=true;
				}
			}
			if(CR.getClassType().equals("CSC") && (CSCElective1IP)) {
				if(		CR.getClassNumber().equals("395")||CR.getClassNumber().equals("411")||
						CR.getClassNumber().equals("421")||CR.getClassNumber().equals("431")||
						CR.getClassNumber().equals("441")||CR.getClassNumber().equals("451")||
						CR.getClassNumber().equals("453")||CR.getClassNumber().equals("455")||
						CR.getClassNumber().equals("459")||CR.getClassNumber().equals("461")||
						CR.getClassNumber().equals("463")||CR.getClassNumber().equals("471")||
						CR.getClassNumber().equals("490")||CR.getClassNumber().equals("495")) {
					CSCElective2IP=true;
				}
			}
			if(CR.getClassType().contentEquals("MAT") && (CSCElective1IP)) {
				if(CR.getClassNumber().equals("367")||CR.getClassNumber().equals("369")) {
					CSCElective2IP=true;
				}
			}
		}
    	request.setAttribute("CSC121IP", CSC121IP);
    	request.setAttribute("CSC123IP", CSC123IP);
    	request.setAttribute("CSC221IP", CSC221IP);
    	request.setAttribute("CSC2xxIP", CSC2xxIP);
    	request.setAttribute("MAT191IP", MAT191IP);
    	request.setAttribute("MAT193IP", MAT193IP);
    	request.setAttribute("MAT271IP", MAT271IP);
    	request.setAttribute("MAT281IP", MAT281IP);
    	request.setAttribute("PHY130IP", PHY130IP);
    	request.setAttribute("PHY132IP", PHY132IP);
    	request.setAttribute("CSC311IP", CSC311IP);
    	request.setAttribute("CSC321IP", CSC321IP);
    	request.setAttribute("CSC331IP", CSC331IP);
    	request.setAttribute("CSC341IP", CSC341IP);
    	request.setAttribute("CSC301IP", CSC301IP);
    	request.setAttribute("CSC401IP", CSC401IP);
    	request.setAttribute("CSC481IP", CSC481IP);
    	request.setAttribute("CSC492IP", CSC492IP);
    	request.setAttribute("MAT321IP", MAT321IP);
    	request.setAttribute("CSC471IP", CSC471IP);
    	request.setAttribute("CSCElective1IP", CSCElective1IP);
    	request.setAttribute("CSCElective2IP", CSCElective2IP);
    	
    	//now for gen. eds., NO NEED FOR GRADES JUST CHECK TO SEE IF THEYRE IN SCHEDULE

    	boolean CompositionIP=false;
        boolean Eng108IP=false;
        boolean Eng109IP=false;
        for(Courses CR : list) {
        	if(CR.getClassType().equals("ENG") && CR.getClassNumber().equals("110")) {
        		CompositionIP=true;
        	}
        	if(CR.getClassType().equals("ENG") && CR.getClassNumber().equals("112")) {
        		CompositionIP=true;
        	}
        	if(CR.getClassType().equals("ENG") && CR.getClassNumber().equals("108")) {
        		Eng108IP=true;
        	}
        	if(CR.getClassType().equals("ENG") && CR.getClassNumber().equals("109")) {
        		Eng109IP=true;
        	}
        	if(Eng108IP || Eng109IP) {
        		CompositionIP=true;
        	}
        	//System.out.println("FROM SERVLET "+Composition);
        }
        request.setAttribute("CompositionIP", CompositionIP);
        
        //this loop checks part a section 2
        //actually this part should be taken by CSC121
        boolean LogicIP=false;
        if((boolean)request.getAttribute("CSC121IP")) {
        	LogicIP=true;
        }
        else {
        	for(Courses CR : list) {
            	if(CR.getClassType().equals("MAT") && CR.getClassNumber().equals("271")) {
            		LogicIP=true;
            	}
            	if(CR.getClassType().equals("PHI") && CR.getClassNumber().equals("120")) {
            		LogicIP=true;
            	}
            	if(CR.getClassType().equals("PSY") && CR.getClassNumber().equals("110")) {
            		LogicIP=true;
            	}
            }
        }
        request.setAttribute("LogicIP", LogicIP);
        
        //this loop checks part a section 3
        boolean OralIP=false;
        for(Courses CR : list) {
        	if(CR.getClassType().equals("THE") && CR.getClassNumber().equals("120")) {
        		OralIP=true;
        	}
        }
        request.setAttribute("OralIP", OralIP);
        
        //this loop checks part b section 1
        boolean PhysicalIP=false;
        for(Courses CR : list) {
        	if(CR.getClassType().equals("CHE") && CR.getClassNumber().equals("102")) {
        		PhysicalIP=true;
        	}
        	if(CR.getClassType().equals("EAR") && CR.getClassNumber().equals("100")) {
        		PhysicalIP=true;
        	}
        	if(CR.getClassType().equals("GEO") && CR.getClassNumber().equals("200")) {
        		PhysicalIP=true;
        	}
        	if(CR.getClassType().equals("PHY") && CR.getClassNumber().equals("100")) {
        		PhysicalIP=true;
        	}
        }
        request.setAttribute("PhysicalIP", PhysicalIP);
        
        //this loop checks part b sec 2
        boolean LifeIP=false;
        for(Courses CR : list) {
        	if(CR.getClassType().equals("ANT") && CR.getClassNumber().equals("101")) {
        		LifeIP=true;
        	}
        	if(CR.getClassType().equals("BIO") && CR.getClassNumber().equals("102")) {
        		LifeIP=true;
        	}
        }
        request.setAttribute("LifeIP", LifeIP);
        
        //
        boolean ScienceLabIP=false;
        for(Courses CR : list) {
        	if(CR.getClassType().equals("BIO") && CR.getClassNumber().equals("103")) {
        		ScienceLabIP=true;
        	}
        	if(CR.getClassType().equals("EAR") && CR.getClassNumber().equals("101")) {
        		ScienceLabIP=true;
        	}
        	if(CR.getClassType().equals("CHE") && CR.getClassNumber().equals("103")) {
        		ScienceLabIP=true;
        	}
        }
        request.setAttribute("ScienceLabIP", ScienceLabIP);
        
        //part b sec 4
        //THIS SHOULD BE TAKEN AS PART OF CS CORE REQUIREMENTS
        boolean QuantitativeIP=false;
        for(Courses CR : list) {
        	if(CR.getClassType().equals("MAT")) {
        		if(CR.getClassNumber().contentEquals("105")||CR.getClassNumber().contentEquals("131")||
        				CR.getClassNumber().contentEquals("132")||CR.getClassNumber().contentEquals("151")||
        				CR.getClassNumber().contentEquals("153")||CR.getClassNumber().contentEquals("171")||
        				CR.getClassNumber().contentEquals("191")||CR.getClassNumber().contentEquals("193")) {
        			QuantitativeIP=true;
        		}
        	}
        }
        request.setAttribute("QuantitativeIP", QuantitativeIP);
        
        //part c sec 1,2,3
        boolean LettersIP=false;
        boolean ArtsIP=false;
        //boolean HumanitiesIP=false;
        for(Courses CR : list) {
        	if(		  (CR.getClassType().equals("AFS") && CR.getClassNumber().equals("205"))
        			||(CR.getClassType().equals("APP") && CR.getClassNumber().equals("225"))
        			||(CR.getClassType().equals("ART") && CR.getClassNumber().equals("100"))
        			||(CR.getClassType().equals("ART") && CR.getClassNumber().equals("101"))
        			||(CR.getClassType().equals("CHS") && CR.getClassNumber().equals("125"))
        			||(CR.getClassType().equals("COM") && CR.getClassNumber().equals("130"))
        			||(CR.getClassType().equals("DAN") && CR.getClassNumber().equals("130"))
        			||(CR.getClassType().equals("ENG") && CR.getClassNumber().equals("271"))
        			||(CR.getClassType().equals("MUS") && CR.getClassNumber().equals("101"))
        			||(CR.getClassType().equals("MUS") && CR.getClassNumber().equals("110"))
        			||(CR.getClassType().equals("MUS") && CR.getClassNumber().equals("201"))
        			||(CR.getClassType().equals("MUS") && CR.getClassNumber().equals("250"))
        			||(CR.getClassType().equals("THE") && CR.getClassNumber().equals("100"))
        			||(CR.getClassType().equals("THE") && CR.getClassNumber().equals("160"))) {
        		ArtsIP=true;
        	}
        	if(		  (CR.getClassType().equals("AFS") && CR.getClassNumber().equals("200"))
        			||(CR.getClassType().equals("AFS") && CR.getClassNumber().equals("231"))
        			||(CR.getClassType().equals("APP") && CR.getClassNumber().equals("101"))
        			||(CR.getClassType().equals("APP") && CR.getClassNumber().equals("201"))
        			||(CR.getClassType().equals("CHS") && CR.getClassNumber().equals("100"))
        			||(CR.getClassType().equals("CHS") && CR.getClassNumber().equals("205"))
        			||(CR.getClassType().equals("COM") && CR.getClassNumber().equals("100"))
        			||(CR.getClassType().equals("ENG") && CR.getClassNumber().equals("230"))
        			||(CR.getClassType().equals("FRE") && CR.getClassNumber().equals("220"))
        			||(CR.getClassType().equals("HUM") && CR.getClassNumber().equals("200"))
        			||(CR.getClassType().equals("HUM") && CR.getClassNumber().equals("212"))
        			||(CR.getClassType().equals("JPN") && CR.getClassNumber().equals("110"))
        			||(CR.getClassType().equals("JPN") && CR.getClassNumber().equals("111"))
        			||(CR.getClassType().equals("PHI") && CR.getClassNumber().equals("101"))
        			||(CR.getClassType().equals("PHI") && CR.getClassNumber().equals("102"))
        			||(CR.getClassType().equals("PHI") && CR.getClassNumber().equals("201"))
        			||(CR.getClassType().equals("PHI") && CR.getClassNumber().equals("202"))
        			||(CR.getClassType().equals("SPA") && CR.getClassNumber().equals("151"))
        			||(CR.getClassType().equals("SPA") && CR.getClassNumber().equals("221"))
        			||(CR.getClassType().equals("WMS") && CR.getClassNumber().equals("100"))) {
        		LettersIP=true;
        	}
        }
        request.setAttribute("ArtsIP", ArtsIP);
        request.setAttribute("LettersIP", LettersIP);
        //request.setAttribute("Humanities", Humanities);
        
        //part d sec 1 2 3 
        //int societyCounter=0, globalCounter=0;
        boolean SocietyIP=false;
        boolean GlobalIP=false;
        //boolean Social=false;
        for(Courses CR : list) {
        	if(		  (CR.getClassType().equals("AFS") && CR.getClassNumber().equals("100"))
        			||(CR.getClassType().equals("AFS") && CR.getClassNumber().equals("220"))
        			||(CR.getClassType().equals("ANT") && CR.getClassNumber().equals("100"))
        			||(CR.getClassType().equals("APP") && CR.getClassNumber().equals("212"))
        			||(CR.getClassType().equals("CHS") && CR.getClassNumber().equals("212"))
        			||(CR.getClassType().equals("ECO") && CR.getClassNumber().equals("210"))
        			||(CR.getClassType().equals("ECO") && CR.getClassNumber().equals("211"))
        			||(CR.getClassType().equals("IDS") && CR.getClassNumber().equals("210"))
        			||(CR.getClassType().equals("LBS") && CR.getClassNumber().equals("205"))
        			||(CR.getClassType().equals("LAW") && CR.getClassNumber().equals("240"))
        			||(CR.getClassType().equals("PSY") && CR.getClassNumber().equals("101"))
        			||(CR.getClassType().equals("SOC") && CR.getClassNumber().equals("101"))
        			||(CR.getClassType().equals("SOC") && CR.getClassNumber().equals("102"))
        			||(CR.getClassType().equals("WMS") && CR.getClassNumber().equals("250"))) {
        		SocietyIP=true;
        	}
        	if(		  (CR.getClassType().equals("AFS") && CR.getClassNumber().equals("201"))
        			||(CR.getClassType().equals("ANT") && CR.getClassNumber().equals("102"))
        			||(CR.getClassType().equals("CHS") && CR.getClassNumber().equals("200"))
        			||(CR.getClassType().equals("ENG") && CR.getClassNumber().equals("150"))
        			||(CR.getClassType().equals("GEO") && CR.getClassNumber().equals("100"))
        			||(CR.getClassType().equals("HIS") && CR.getClassNumber().equals("120"))
        			||(CR.getClassType().equals("HIS") && CR.getClassNumber().equals("121"))
        			||(CR.getClassType().equals("LBR") && CR.getClassNumber().equals("200"))
        			||(CR.getClassType().equals("MGT") && CR.getClassNumber().equals("200"))
        			||(CR.getClassType().equals("POL") && CR.getClassNumber().equals("100"))) {
        		GlobalIP=true;
        	}
        }
        request.setAttribute("SocietyIP", SocietyIP);
        request.setAttribute("GlobalIP", GlobalIP);
        //request.setAttribute("SocialIP", SocialIP);
        
        //part e 
        boolean LifelongIP=false;
        for(Courses CR : list) {
        	if(		  (CR.getClassType().equals("BUS") && CR.getClassNumber().equals("100"))
        			||(CR.getClassType().equals("CIS") && CR.getClassNumber().equals("275"))
        			||(CR.getClassType().equals("FIN") && CR.getClassNumber().equals("200"))
        			||(CR.getClassType().equals("HEA") && CR.getClassNumber().equals("100"))
        			||(CR.getClassType().equals("HEA") && CR.getClassNumber().equals("201"))
        			||(CR.getClassType().equals("KIN") && CR.getClassNumber().equals("235"))
        			||(CR.getClassType().equals("LIB") && CR.getClassNumber().equals("151"))
        			||(CR.getClassType().equals("REC") && CR.getClassNumber().equals("100"))
        			||(CR.getClassType().equals("UNV") && CR.getClassNumber().equals("101"))) {
        		LifelongIP=true;
        	}
        }
        request.setAttribute("LifelongIP", LifelongIP);
        
        //part f sec 1 2 3
        boolean IntegrativeHumanitiesIP=false;
        boolean IntegrativeNaturalIP=false;
        boolean IntegrativeSocialIP=false;
        for(Courses CR : list) {
        	if(		  (CR.getClassType().equals("AFS") && CR.getClassNumber().equals("331"))
        			||(CR.getClassType().equals("AFS") && CR.getClassNumber().equals("332"))
        			||(CR.getClassType().equals("AFS") && CR.getClassNumber().equals("333"))
        			||(CR.getClassType().equals("AFS") && CR.getClassNumber().equals("334"))
        			||(CR.getClassType().equals("APP") && CR.getClassNumber().equals("314"))
        			||(CR.getClassType().equals("APP") && CR.getClassNumber().equals("315"))
        			||(CR.getClassType().equals("APP") && CR.getClassNumber().equals("325"))
        			||(CR.getClassType().equals("APP") && CR.getClassNumber().equals("339"))
        			||(CR.getClassType().equals("APP") && CR.getClassNumber().equals("343"))
        			||(CR.getClassType().equals("ARH") && CR.getClassNumber().equals("370"))
        			||(CR.getClassType().equals("CHS") && CR.getClassNumber().equals("340"))
        			||(CR.getClassType().equals("CHS") && CR.getClassNumber().equals("345"))
        			||(CR.getClassType().equals("ENG") && CR.getClassNumber().equals("308"))
        			||(CR.getClassType().equals("HIS") && CR.getClassNumber().equals("355"))
        			||(CR.getClassType().equals("HIS") && CR.getClassNumber().equals("375"))
        			||(CR.getClassType().equals("HIS") && CR.getClassNumber().equals("376"))
        			||(CR.getClassType().equals("HUM") && CR.getClassNumber().equals("310"))
        			||(CR.getClassType().equals("HUM") && CR.getClassNumber().equals("312"))
        			||(CR.getClassType().equals("HUM") && CR.getClassNumber().equals("314"))
        			||(CR.getClassType().equals("IDS") && CR.getClassNumber().equals("312"))
        			||(CR.getClassType().equals("LBR") && CR.getClassNumber().equals("310"))
        			||(CR.getClassType().equals("LBR") && CR.getClassNumber().equals("312"))
        			||(CR.getClassType().equals("LBR") && CR.getClassNumber().equals("314"))
        			||(CR.getClassType().equals("MUS") && CR.getClassNumber().equals("312"))
        			||(CR.getClassType().equals("MUS") && CR.getClassNumber().equals("345"))
        			||(CR.getClassType().equals("MUS") && CR.getClassNumber().equals("486"))
        			||(CR.getClassType().equals("PHI") && CR.getClassNumber().equals("351"))
        			||(CR.getClassType().equals("PHI") && CR.getClassNumber().equals("352"))
        			||(CR.getClassType().equals("PHI") && CR.getClassNumber().equals("353"))
        			||(CR.getClassType().equals("PHI") && CR.getClassNumber().equals("383"))
        			||(CR.getClassType().equals("SPA") && CR.getClassNumber().equals("310"))
        			||(CR.getClassType().equals("SPA") && CR.getClassNumber().equals("312"))
        			||(CR.getClassType().equals("SPA") && CR.getClassNumber().equals("313"))
        			||(CR.getClassType().equals("THE") && CR.getClassNumber().equals("313"))
        			||(CR.getClassType().equals("THE") && CR.getClassNumber().equals("315"))
        			||(CR.getClassType().equals("THE") && CR.getClassNumber().equals("317"))
        			||(CR.getClassType().equals("THE") && CR.getClassNumber().equals("319"))
        			||(CR.getClassType().equals("WMS") && CR.getClassNumber().equals("310"))
        			||(CR.getClassType().equals("WMS") && CR.getClassNumber().equals("311"))
        			||(CR.getClassType().equals("WMS") && CR.getClassNumber().equals("314"))
        			||(CR.getClassType().equals("WMS") && CR.getClassNumber().equals("315"))) {
        		IntegrativeHumanitiesIP=true;
        	}
        	//this should be filled by CSC301
        	if((boolean)request.getAttribute("CSC301IP")) {
        		IntegrativeNaturalIP=true;
        	}
        	else {
        		if(		  (CR.getClassType().equals("BIO") && CR.getClassNumber().equals("336"))
            			||(CR.getClassType().equals("BIO") && CR.getClassNumber().equals("340"))
            			||(CR.getClassType().equals("CSC") && CR.getClassNumber().equals("301"))
            			||(CR.getClassType().equals("EAR") && CR.getClassNumber().equals("312"))
            			||(CR.getClassType().equals("EAR") && CR.getClassNumber().equals("416"))
            			||(CR.getClassType().equals("IDS") && CR.getClassNumber().equals("310"))
            			||(CR.getClassType().equals("LBS") && CR.getClassNumber().equals("380"))
            			||(CR.getClassType().equals("SMT") && CR.getClassNumber().equals("310"))
            			||(CR.getClassType().equals("SMT") && CR.getClassNumber().equals("314"))) {
        			IntegrativeNaturalIP=true;
        		}
        	}
        	if(		  (CR.getClassType().equals("AFS") && CR.getClassNumber().equals("310"))
        			||(CR.getClassType().equals("AFS") && CR.getClassNumber().equals("311"))
        			||(CR.getClassType().equals("AFS") && CR.getClassNumber().equals("312"))
        			||(CR.getClassType().equals("ANT") && CR.getClassNumber().equals("312"))
        			||(CR.getClassType().equals("ANT") && CR.getClassNumber().equals("334"))
        			||(CR.getClassType().equals("ANT") && CR.getClassNumber().equals("336"))
        			||(CR.getClassType().equals("ANT") && CR.getClassNumber().equals("337"))
        			||(CR.getClassType().equals("ANT") && CR.getClassNumber().equals("338"))
        			||(CR.getClassType().equals("ANT") && CR.getClassNumber().equals("342"))
        			||(CR.getClassType().equals("ANT") && CR.getClassNumber().equals("371"))
        			||(CR.getClassType().equals("APP") && CR.getClassNumber().equals("311"))
        			||(CR.getClassType().equals("APP") && CR.getClassNumber().equals("318"))
        			||(CR.getClassType().equals("APP") && CR.getClassNumber().equals("327"))
        			||(CR.getClassType().equals("APP") && CR.getClassNumber().equals("350"))
        			||(CR.getClassType().equals("APP") && CR.getClassNumber().equals("335"))
        			||(CR.getClassType().equals("CHS") && CR.getClassNumber().equals("323"))
        			||(CR.getClassType().equals("CHS") && CR.getClassNumber().equals("330"))
        			||(CR.getClassType().equals("CHS") && CR.getClassNumber().equals("335"))
        			||(CR.getClassType().equals("GEO") && CR.getClassNumber().equals("318"))
        			||(CR.getClassType().equals("HEA") && CR.getClassNumber().equals("468"))
        			||(CR.getClassType().equals("HIS") && CR.getClassNumber().equals("340"))
        			||(CR.getClassType().equals("HIS") && CR.getClassNumber().equals("348"))
        			||(CR.getClassType().equals("HIS") && CR.getClassNumber().equals("352"))
        			||(CR.getClassType().equals("HIS") && CR.getClassNumber().equals("354"))
        			||(CR.getClassType().equals("HIS") && CR.getClassNumber().equals("380"))
        			||(CR.getClassType().equals("IDS") && CR.getClassNumber().equals("304"))
        			||(CR.getClassType().equals("IDS") && CR.getClassNumber().equals("318"))
        			||(CR.getClassType().equals("LBS") && CR.getClassNumber().equals("370"))
        			||(CR.getClassType().equals("SBS") && CR.getClassNumber().equals("318"))
        			||(CR.getClassType().equals("WMS") && CR.getClassNumber().equals("318"))) {
        		IntegrativeSocialIP=true;
        	}
        }
        request.setAttribute("IntegrativeHumanitiesIP", IntegrativeHumanitiesIP);
        request.setAttribute("IntegrativeNaturalIP", IntegrativeNaturalIP);
        request.setAttribute("IntegrativeSocialIP", IntegrativeSocialIP);
    
    }
    
    public static Courses addClassSuggestion(HttpServletRequest request) {
    	boolean classadded=false;
    	Courses C= new Courses();
    	C.setClassTitle("All Requirements Met");
    	C.setCredits("18");
    	//the following 5 is the ideal semester 1
    	if(!(boolean) request.getAttribute("CSC121")&& !(boolean)request.getAttribute("CSC121IP") && !classadded) {
    		C.setClassTitle("CSC 121");
    		C.setCredits("4");
    		classadded=true;
    		request.setAttribute("CSC121IP", classadded);
    	}
    	if(!(boolean) request.getAttribute("MAT191") && !(boolean)request.getAttribute("MAT191IP") && !classadded) {
    		C.setClassTitle("MAT 191");
    		C.setCredits("5");
    		classadded=true;
    		request.setAttribute("MAT191IP", classadded);
    	}
    	if(!(boolean) request.getAttribute("Composition")&& !(boolean)request.getAttribute("CompositionIP") && !classadded) {
    		C.setClassTitle("Gen Ed Area A-1 Composition");
    		C.setCredits("3");
    		classadded=true;
    		request.setAttribute("CompositionIP", classadded);
    	}
    	if(!(boolean) request.getAttribute("Arts")&& !(boolean)request.getAttribute("ArtsIP") && !classadded) {
    		C.setClassTitle("Gen Ed Area C-Arts");
    		C.setCredits("3");
    		classadded=true;
    		request.setAttribute("ArtsIP", classadded);
    	}
    	if(!(boolean) request.getAttribute("Letters")&& !(boolean)request.getAttribute("LettersIP") && !classadded) {
    		C.setClassTitle("Gen Ed Area C-Letters");
    		C.setCredits("3");
    		classadded=true;
    		request.setAttribute("LettersIP", classadded);
    	}
    	//the following is the ideal semester 2
    	if(!(boolean) request.getAttribute("Oral")&& !(boolean)request.getAttribute("OralIP") && !classadded) {
    		C.setClassTitle("Gen Ed Area A-2 Oral");
    		C.setCredits("3");
    		classadded=true;
    		request.setAttribute("OralIP", classadded);
    	}
    	if(!(boolean) request.getAttribute("PHY130")&& !(boolean)request.getAttribute("PHY130IP") && !classadded) {
    		C.setClassTitle("PHY 130");
    		C.setCredits("5");
    		classadded=true;
    		request.setAttribute("PHY130IP", classadded);
    	}
    	if(!(boolean) request.getAttribute("CSC123")&& !(boolean)request.getAttribute("CSC123IP") && !classadded && (boolean)request.getAttribute("CSC121")) {
    		C.setClassTitle("CSC 123");
    		C.setCredits("4");
    		classadded=true;
    		request.setAttribute("CSC123IP", classadded);
    	}
    	if(!(boolean) request.getAttribute("Society")&& !(boolean)request.getAttribute("SocietyIP") && !classadded) {
    		C.setClassTitle("Gen Ed Area D-Perspectives on Individuals, Groups and Society");
    		C.setCredits("3");
    		classadded=true;
    		request.setAttribute("SocietyIP", classadded);
    	}
    	if(!(boolean) request.getAttribute("Global")&& !(boolean)request.getAttribute("GlobalIP") && !classadded) {
    		C.setClassTitle("Gen Ed Area D-Global and Historical Perspectives");
    		C.setCredits("3");
    		classadded=true;
    		request.setAttribute("GlobalIP", classadded);
    	}
    	//the following is the ideal semester 3
    	if(!(boolean) request.getAttribute("MAT193")&& !(boolean)request.getAttribute("MAT193IP") && !classadded && (boolean)request.getAttribute("MAT191")) {
    		C.setClassTitle("MAT 193");
    		C.setCredits("5");
    		classadded=true;
    		request.setAttribute("MAT193IP", classadded);
    	}
    	if(!(boolean) request.getAttribute("MAT281")&& !(boolean)request.getAttribute("MAT281IP") && !classadded && (boolean)request.getAttribute("CSC121")) {
    		C.setClassTitle("MAT 281");
    		C.setCredits("3");
    		classadded=true;
    		request.setAttribute("MAT281IP", classadded);
    	}
    	if(!(boolean) request.getAttribute("Physical")&& !(boolean)request.getAttribute("PhysicalIP") && !classadded) {
    		C.setClassTitle("Gen Ed Area B-1 Physical Sciences");
    		C.setCredits("3");
    		classadded=true;
    		request.setAttribute("PhysicalIP", classadded);
    	}
    	if(!(boolean) request.getAttribute("Life")&& !(boolean)request.getAttribute("LifeIP") && !classadded) {
    		C.setClassTitle("Gen Ed Area B-2 Life Sciences");
    		C.setCredits("3");
    		classadded=true;
    		request.setAttribute("LifeIP", classadded);
    	}
    	if(!(boolean) request.getAttribute("ScienceLab")&& !(boolean)request.getAttribute("ScienceLabIP") && !classadded) {
    		C.setClassTitle("Gen Ed Area B-3 Science Laboratory");
    		C.setCredits("1");
    		classadded=true;
    		request.setAttribute("ScienceLabIP", classadded);
    	}
    	if(!(boolean) request.getAttribute("CSC221")&& !(boolean)request.getAttribute("CSC221IP") && !classadded && (boolean)request.getAttribute("CSC121")) {
    		C.setClassTitle("CSC 221");
    		C.setCredits("3");
    		classadded=true;
    		request.setAttribute("CSC221IP", classadded);
    	}
    	//the following is the ideal semester 4
    	if(!(boolean) request.getAttribute("MAT271")&& !(boolean)request.getAttribute("MAT271IP") && !classadded && (boolean)request.getAttribute("MAT193")) {
    		C.setClassTitle("MAT 271");
    		C.setCredits("3");
    		classadded=true;
    		request.setAttribute("MAT271IP", classadded);
    	}
    	if(!(boolean) request.getAttribute("PHY132")&& !(boolean)request.getAttribute("PHY132IP") && !classadded && (boolean)request.getAttribute("PHY130")) {
    		C.setClassTitle("PHY 132");
    		C.setCredits("5");
    		classadded=true;
    		request.setAttribute("PHY132IP", classadded);
    	}
    	if(!(boolean) request.getAttribute("CSC2xx")&& !(boolean)request.getAttribute("CSC2xxIP") && !classadded && (boolean)request.getAttribute("CSC121")) {
    		C.setClassTitle("Lower Division Computer Science Elective");
    		C.setCredits("3");
    		classadded=true;
    		request.setAttribute("CSC2xxIP", classadded);
    	}
    	if(!(boolean) request.getAttribute("Humanities")&& (boolean)request.getAttribute("Arts") && (boolean)request.getAttribute("Letters") && !classadded&& !(boolean)request.getAttribute("ArtsIP") && !(boolean)request.getAttribute("LettersIP")) {
    		C.setClassTitle("Gen Ed Area C either Arts or Letters");
    		C.setCredits("3");
    		classadded=true;
    		request.setAttribute("Humanities", classadded);
    	}
    	if(!(boolean) request.getAttribute("Social")&& (boolean)request.getAttribute("Society") && (boolean)request.getAttribute("Global") && !classadded&& !(boolean)request.getAttribute("SocietyIP") && !(boolean)request.getAttribute("GlobalIP")) {
    		C.setClassTitle("Gen Ed Area D either Perspectives on Individuals, Groups and Society or Perspectives on Individuals, Groups and Society");
    		C.setCredits("3");
    		classadded=true;
    		request.setAttribute("Social", classadded);
    	}
    	//the following is the ideal semester 5
    	if(!(boolean) request.getAttribute("CSC301")&& !(boolean)request.getAttribute("CSC301IP") && !classadded && (boolean)request.getAttribute("CSC121")) {
    		C.setClassTitle("CSC 301");
    		C.setCredits("3");
    		classadded=true;
    		request.setAttribute("CSC301IP", classadded);
    	}
    	if(!(boolean) request.getAttribute("CSC311")&& !(boolean)request.getAttribute("CSC311IP") && !classadded && (boolean)request.getAttribute("CSC123") && (boolean)request.getAttribute("MAT281")) {
    		C.setClassTitle("CSC 311");
    		C.setCredits("3");
    		classadded=true;
    		request.setAttribute("CSC311IP", classadded);
    	}
    	if(!(boolean) request.getAttribute("Lifelong")&& !(boolean)request.getAttribute("LifelongIP") && !classadded) {
    		C.setClassTitle("Gen Ed Area E Objectives for Lifelong Learning and Self-Development ");
    		C.setCredits("3");
    		classadded=true;
    		request.setAttribute("LifelongIP", classadded);
    	}
    	if(!(boolean) request.getAttribute("IntegrativeHumanities")&& !(boolean)request.getAttribute("IntegrativeHumanitiesIP") && !classadded && (boolean) request.getAttribute("Humanities") && (boolean) request.getAttribute("Social")) {
    		C.setClassTitle("Gen Ed Area F-1 Integrative Studies in the Humanities");
    		C.setCredits("3");
    		classadded=true;
    		request.setAttribute("IntegrativeHumanitiesIP", classadded);
    	}
    	if(!(boolean) request.getAttribute("IntegrativeSocial")&& !(boolean)request.getAttribute("IntegrativeSocialIP") && !classadded && (boolean) request.getAttribute("Humanities") && (boolean) request.getAttribute("Social")) {
    		C.setClassTitle("Gen Ed Area F-3 Integrative Studies in Social Sciences");
    		C.setCredits("3");
    		classadded=true;
    		request.setAttribute("IntegrativeSocialIP", classadded);
    	}
    	if(!(boolean) request.getAttribute("CSC321")&& !(boolean)request.getAttribute("CSC321IP") && !classadded && (boolean)request.getAttribute("CSC123")) {
    		C.setClassTitle("CSC 321");
    		C.setCredits("3");
    		classadded=true;
    		request.setAttribute("CSC321IP", classadded);
    	}
    	//the following is the ideal semester 6
    	if(!(boolean) request.getAttribute("CSC331")&& !(boolean)request.getAttribute("CSC331IP") && !classadded && (boolean)request.getAttribute("CSC221") && (boolean)request.getAttribute("MAT281")) {
    		C.setClassTitle("CSC 331");
    		C.setCredits("3");
    		classadded=true;
    		request.setAttribute("CSC331IP", classadded);
    	}
    	if(!(boolean) request.getAttribute("CSC401")&& !(boolean)request.getAttribute("CSC401IP") && !classadded && (boolean)request.getAttribute("CSC311")) {
    		C.setClassTitle("CSC 401");
    		C.setCredits("3");
    		classadded=true;
    		request.setAttribute("CSC401IP", classadded);
    	}
    	if(!(boolean) request.getAttribute("CSC471")&& !(boolean)request.getAttribute("CSC471IP") && !classadded && (boolean)request.getAttribute("CSC221") && (boolean)request.getAttribute("CSC311")) {
    		C.setClassTitle("CSC 471");
    		C.setCredits("3");
    		classadded=true;
    		request.setAttribute("CSC471IP", classadded);
    	}
    	if(!(boolean) request.getAttribute("CSC481")&& !(boolean)request.getAttribute("CSC481IP") && !classadded && (boolean)request.getAttribute("CSC301") && (boolean)request.getAttribute("CSC311") && (boolean)request.getAttribute("CSC321")) {
    		C.setClassTitle("CSC 471");
    		C.setCredits("3");
    		classadded=true;
    		request.setAttribute("CSC481IP", classadded);
    	}
    	if(!(boolean) request.getAttribute("MAT321")&& !(boolean)request.getAttribute("MAT321IP") && !classadded && (boolean)request.getAttribute("MAT271")) {
    		C.setClassTitle("MAT 321");
    		C.setCredits("3");
    		classadded=true;
    		request.setAttribute("MAT321IP", classadded);
    	}
    	if(!(boolean) request.getAttribute("CSCElective1")&& !(boolean)request.getAttribute("CSCElective1IP") && !classadded) {
    		C.setClassTitle("CSC Upper Division Elective");
    		C.setCredits("3");
    		classadded=true;
    		request.setAttribute("MAT321IP", classadded);
    	}
    	//the following is the ideal semester 7
    	if(!(boolean) request.getAttribute("CSC492")&& !(boolean)request.getAttribute("CSC492IP") && !classadded && (boolean)request.getAttribute("CSC301") && (boolean)request.getAttribute("CSC311") && (boolean)request.getAttribute("CSC321")) {
    		C.setClassTitle("CSC 492");
    		C.setCredits("3");
    		classadded=true;
    		request.setAttribute("CSC481IP", classadded);
    	}
    	if(!(boolean) request.getAttribute("CSC341")&& !(boolean)request.getAttribute("CSC341IP") && !classadded && (boolean)request.getAttribute("CSC311") && (boolean)request.getAttribute("CSC331") && (boolean)request.getAttribute("MAT321")) {
    		C.setClassTitle("CSC 341");
    		C.setCredits("3");
    		classadded=true;
    		request.setAttribute("CSC341IP", classadded);
    	}
    	if(!(boolean) request.getAttribute("CSCElective2")&& !(boolean)request.getAttribute("CSCElective2IP") && !classadded) {
    		C.setClassTitle("CSC Upper Division Elective");
    		C.setCredits("3");
    		classadded=true;
    		request.setAttribute("CSCElective2IP", classadded);
    	}
    	return C;
    }
}