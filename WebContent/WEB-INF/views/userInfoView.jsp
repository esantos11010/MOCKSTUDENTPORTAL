<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
 <head>
    <meta charset="UTF-8">
    <title>User Info</title>
 </head>
 <body>
 
    <jsp:include page="_header.jsp"></jsp:include>
    <jsp:include page="_menu2.jsp"></jsp:include>
 
    <h3>Hello: ${user.userName}</h3>
 
    Student Name:<b>${user.studentFirstName}    ${user.studentLastName}</b>
    <br />
    StudentID:  <b>${user.studentID}</b><br />
    Student Email:<b>${user.studentEmail} </b>
    <br />
    Student Phone#:   <b>${user.studentPhone}</b><br />
    Student Address:  <b>${user.studentAddress}</b><br />
    
	<a href="${pageContext.request.contextPath}/editUserInfo">Edit</a>
 	
    <jsp:include page="_footer.jsp"></jsp:include>
 
 </body>
</html>