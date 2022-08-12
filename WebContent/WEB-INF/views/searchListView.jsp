<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
 <head>
    <meta charset="UTF-8">
    <title>Search Results</title>
 </head>
 <body>
 
    <jsp:include page="_header.jsp"></jsp:include>
    <jsp:include page="_menu2.jsp"></jsp:include>
 
    <h2>Course List</h2>
 	<h3>SEARCH RESULTS LIST</h3>
    <p style="color: red;">${errorString}</p>
 
    <table border="1" cellpadding="5" cellspacing="1" >
       <tr>
          <th>Section</th>
          <th>Name</th>
          <th>Days Time</th>
          <th>Contact Info</th>
          <th>Add</th>
       </tr>
       <c:forEach items="${searchList}" var="Courses" >
          <tr>
             <td>${Courses.classID}</td>
             <td>${Courses.classType} ${Courses.classNumber} - ${Courses.classTitle}</td>
             <td>${Courses.classDays} ${Courses.classStartTime} - ${Courses.classEndTime}</td>
             <td>
                <a href="instructor2?intructorID=${Courses.classInstructorEmployeeID}">VIEW</a>
             </td>
             <td>
                <a href="add?classID=${Courses.classID}">ADD</a>
             </td>
          </tr>
       </c:forEach>
    </table>
 
    <a href="${pageContext.request.contextPath}/classSearch" >New Search</a>
 
    <jsp:include page="_footer.jsp"></jsp:include>
 
 </body>
</html>