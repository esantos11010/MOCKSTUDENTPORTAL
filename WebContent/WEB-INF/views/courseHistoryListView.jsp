<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
 <head>
    <meta charset="UTF-8">
    <title>CLASS RECORDS</title>
 </head>
 <body>
 
    <jsp:include page="_header.jsp"></jsp:include>
    <jsp:include page="_menu2.jsp"></jsp:include>
 
    <h3>Course History</h3>
 
    <p style="color: red;">${errorString}</p>
 
    <table border="1" cellpadding="5" cellspacing="1" >
       <tr>
          <th>Section</th>
          <th>Name</th>
          <th>Year</th>
          <th>Semester</th>
          <th>GRADE</th>

       </tr>
       <c:forEach items="${courseHistoryList}" var="Courses" >
          <tr>
             <td>${Courses.classID}</td>
             <td>${Courses.classType} ${Courses.classNumber} - ${Courses.classTitle}</td>
             <td>${Courses.year}</td>
             <td>${Courses.semester}</td>
             <td>${Courses.grade }</td>
          </tr>
       </c:forEach>
    </table>
 
    <jsp:include page="_footer.jsp"></jsp:include>
 
 </body>
</html>