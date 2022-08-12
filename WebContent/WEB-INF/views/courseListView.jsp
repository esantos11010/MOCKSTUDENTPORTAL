<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
 <head>
    <meta charset="UTF-8">
    <title>CURRENT SCHEDUALE</title>
 </head>
 <body>
 
    <jsp:include page="_header.jsp"></jsp:include>
    <jsp:include page="_menu2.jsp"></jsp:include>
 
    <h3>Course List</h3>
 
    <p style="color: red;">${errorString}</p>
 
    <table border="1" cellpadding="5" cellspacing="1" >
       <tr>
          <th>Section</th>
          <th>Name</th>
          <th>Days Time</th>
          <th>Contact Info</th>
          <th>Drop</th>
       </tr>
       <c:forEach items="${courseList}" var="Courses" >
          <tr>
             <td>${Courses.classID}</td>
             <td>${Courses.classType} ${Courses.classNumber} - ${Courses.classTitle}</td>
             <td>${Courses.classDays} ${Courses.classStartTime} - ${Courses.classEndTime}</td>
             <td>
                <a href="instructor?intructorID=${Courses.classInstructorEmployeeID}">VIEW</a>
             </td>
             <td>
                <a href="drop?classID=${Courses.classID}">Drop</a>
             </td>
          </tr>
       </c:forEach>
    </table>
 
    <a href="${pageContext.request.contextPath}/classSearch" >Search for Class</a>
 
    <jsp:include page="_footer.jsp"></jsp:include>
 
 </body>
</html>