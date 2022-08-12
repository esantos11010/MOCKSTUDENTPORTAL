package beans;

public class UserAccount {
	 	    
	   private String userName;
	   private String studentLastName;
	   private String studentFirstName;
	   private String studentPhone;
	   private String password;
	   private String studentID;
	   private String studentEmail;
	   private String studentAddress;
	 
	   public UserAccount() {
	        
	   }
	   public String getUserName() {
	       return userName;
	   }
	   public void setUserName(String userName) {
	       this.userName = userName;
	   }
	   public String getPassword() {
	       return password;
	   }
	 
	   public void setPassword(String password) {
	       this.password = password;
	   }
	   public String getStudentLastName() {
		   return studentLastName;
	   }
	   public void setStudentLastName(String studentLastName) {
		   this.studentLastName=studentLastName;
	   }
	   public String getStudentFirstName() {
		   return studentFirstName;
	   }
	   public void setStudentFirstName(String studentFirstName) {
		   this.studentFirstName= studentFirstName;
	   }
	   public String getStudentPhone() {
		   return studentPhone;
	   }
	   public void setStudentPhone(String studentPhone) {
		   this.studentPhone = studentPhone;
	   }
	   public String getStudentID() {
		   return studentID;
	   }
	   public void setStudentID(String ID) {
		   this.studentID = ID;
	   }
	   public String getStudentEmail() {
		   return studentEmail;
	   }
	   public void setStudentEmail(String Email) {
		   this.studentEmail = Email;
	   }
	   public String getStudentAddress() {
		   return studentAddress;
	   }
	   public void setStudentAddress(String Address) {
		   this.studentAddress = Address;
	   }
	}