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
 
    <h3>Hello: ${user.userName}<br></h3>
    <p style="color: red;">${errorString}</p>
 	<form method="POST" action="${pageContext.request.contextPath}/editUserInfo">
    Student Name:<b>${user.studentFirstName} ${user.studentLastName}</b>
    <br />
    StudentID:  <b>${user.studentID}</b><br />
    Student Email:<b><input type="text" value="${user.studentEmail}" name="email" id="email" /></b>
    <br />
    Student Phone#:  <b><input type="text" value="${user.studentPhone}" name="phone" id="phone" /></b><br />
    Student Address:  <b><input type="text" value="${user.studentAddress}" name="address" id="address" /></b><br />
    <input type="submit" value= "Submit" />
	<a href="${pageContext.request.contextPath}/userInfo">Cancel</a>
 	</form>
    <jsp:include page="_footer.jsp"></jsp:include>
 
 </body>
</html>