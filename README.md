# MOCKSTUDENTPORTAL
This is a simple website, its purpose is to represent a student portal for computer science majors at CSU Dominguez Hills.
It requires MySQL database and Tomcat Server. You must create new schema in MySQL and use the SQL to populate it.
Once import is complete, there are 2 things that you will need to do:
	a. Navigate to Java Resources\src\automaticPlanner.conn\MySQLConnUtils.java
		In this class you will need set your specific MySQL connection name and password, 
		we used the default settings, but yours might be different. 
	    String userName = "root"; --> change to your connection name
     	String password = "root"; --> change to your connection password

	b. Once thats done, run the project: Run As -> Run on Server
The server we used was Apache Tomcat 8.0, you might need to download and configure this server.
The project should be good to go after these steps are completed. To log into the application use the information from the "Students" 
table from the provided database. There are 5 created student accounts that can be accessed, the usernames and passwords are found in 
"studentHandle" and "studentPassword" fields respectively.
