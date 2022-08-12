<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
  <head>
	<style>
	html, body{
	margin: 0;
	padding: 0;
	}
	.header {
  	font-family: 'Share Tech Mono', monospace;
  	background-color: #860038;
 	height : 150px;
  	padding:5px;
  	margin: 0;
 	}
 	.header h1 {
 	color: #ebebeb;
 	}
	</style>
  </head>
<div class="header">
     <h1>Online Academic Planner</h1>
     <c:choose>
     	<c:when test = "${loginedUser ==null}" >
     		<h2>SIGN IN <b>${loginedUser.userName}</b></h2>
     	</c:when>
     	<c:otherwise>
     		<h2> Hello <b>${loginedUser.userName}</b></h2>
     	</c:otherwise>
     </c:choose>
     <br>
</div>
</html>