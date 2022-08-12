<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <head>
      <meta charset="UTF-8">
      <title>Class Search</title>
   </head>
   <body>
      <jsp:include page="_header.jsp"></jsp:include>
      <jsp:include page="_menu2.jsp"></jsp:include>
 
      <h3>CLASS SEARCH PAGE</h3>
      <h2>Enter class type and class number.( CSC 101, MAT 436, CSC 492, etc..)</h2>
      <p style="color: red;">${errorString}</p>
 
 
      <form method="POST" action="${pageContext.request.contextPath}/classSearch">
         <table border="0">
            <tr>
               <td>Class Type</td>
               <td><input type="text" name="classType" value= "${course.classType}" /> </td>
            </tr>
            <tr>
               <td>Class Number</td>
               <td><input type="text" name="classNumber" value= "${course.classNumber}" /> </td>
            </tr>

            <tr>
               <td colspan ="2">
                  <input type="submit" value= "Submit" />
                  <a href="${pageContext.request.contextPath}/courses">Cancel</a>
               </td>
            </tr>
         </table>
      </form>
 
 
      <jsp:include page="_footer.jsp"></jsp:include>
   </body>
</html>