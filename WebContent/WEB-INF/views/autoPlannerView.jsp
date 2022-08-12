<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
 <head>
    <meta charset="UTF-8">
    <title>General Education Requirements List</title>
 </head>
 <body>
 
    <jsp:include page="_header.jsp"></jsp:include>
    <jsp:include page="_menu2.jsp"></jsp:include>
 
    <h3>Suggested Classes to Take based on Class Records and Current Class Enrollment</h3>
 
    <p style="color: red;">${errorString}</p>
 	
    <table border="10" cellpadding="5" cellspacing="1" width="1000" >
       <tr>
          <th>NOTE these classes are suggestions you may choose different class if you wish but following the suggestions ensures a path to graduation.</th>
          
       </tr>
       <c:forEach items="${tryitout}" var="Courses" >
          <tr>
             <td>${Courses.classTitle}</td>
             
          </tr>
       </c:forEach>
       
       
    </table>
    
    
    
 
    <jsp:include page="_footer.jsp"></jsp:include>
 
 </body>
</html>