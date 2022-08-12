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
 	<div style="float: left">
    <h3>Gen. Ed. List</h3>
 
    <p style="color: red; float: left">${errorString}</p>
 	
    <table border="10" cellpadding="5" cellspacing="1" width="1000" >
       <tr>
          <th>A. Basic Skills (9 Units) Must do 1 from each</th>
          
       </tr>
       <tr>
       	  <th>1. Composition (3 Units)</th>
       </tr>
       <c:choose>
       	<c:when test="${Composition}">
       		<td>REQUIREMENT MET</td>
       	</c:when>
       	<c:otherwise>
       		<tr>
             <td>ENG 108 - Freshman Composition I Stretch I <a href="genEdClassSearch?classType=ENG&classNumber=108">Search For This Class</a></td>
          	</tr>
          	<tr>
             <td>ENG 109 - Freshman Composition I Stretch II <a href="genEdClassSearch?classType=ENG&classNumber=109">Search For This Class</a></td>
          	</tr>
          	<tr>
             <td>ENG 110 - Freshman Composition I <a href="genEdClassSearch?classType=ENG&classNumber=110">Search For This Class</a></td>
          	</tr>
          	<tr>
             <td>ENG 112 - Freshman Composition Supported <a href="genEdClassSearch?classNumber=ENG&classNumber=112">Search For This Class</a></td>
          	</tr>
          	<tr>
             <td>**Note ENG 108 and 109 must be taken in sequence</td>
          	</tr>
       	</c:otherwise>
       </c:choose>
       
       <tr><th>2.Logic/Critical Reasoning (3 Units)</th></tr>
       <c:choose>
       	<c:when test="${Logic}">
       		<td>REQUIREMENT MET</td>
       	</c:when>
       	<c:otherwise>
          	<tr>
             <td>MAT 271 - Higher Mathematics <a href="genEdClassSearch?classType=MAT&classNumber=271">Search For This Class</a></td>
          	</tr>
          	<tr>
             <td>PHI 120 - Critical Reasoning <a href="genEdClassSearch?classType=PHI&classNumber=120">Search For This Class</a></td>
          	</tr>
          	<tr>
             <td>PSY 110 - Critical Thinking and Problem Solving <a href="genEdClassSearch?classType=PSY&classNumber=110">Search For This Class</a></td>
          	</tr>
       	</c:otherwise>
       </c:choose>

       <tr><th>3. Oral Communication (3 Units)</th></tr>
       <c:choose>
       	<c:when test="${Oral}">
       		<td>REQUIREMENT MET</td>
       	</c:when>
       	<c:otherwise>
          	<tr>
             <td>THE 120 - Fundamentals of Speech <a href="genEdClassSearch?classType=THE&classNumber=120">Search For This Class</a></td>
          	</tr>
          	
       	</c:otherwise>
       </c:choose>
    </table>
    
    <table border="10" cellpadding="5" cellspacing="1" width="1000" >
       <tr>
          <th>B. Area of the Natural Sciences and Quantitative Reasoning (10 Units) Must do 1 from each</th>
          
       </tr>
       <tr>
       	  <th>1. Physical Sciences (3 Units)</th>	  
       </tr>
       <c:choose>
       	<c:when test="${Physical}">
       		<td>REQUIREMENT MET</td>
       	</c:when>
       	<c:otherwise>
          	<tr>
             <td>CHE 102 - Chemistry for the Citizen <a href="genEdClassSearch?classType=CHE&classNumber=102">Search For This Class</a></td>
          	</tr>
          	<tr>
             <td>EAR 100 - Physical Geology <a href="genEdClassSearch?classType=EAR&classNumber=100">Search For This Class</a></td>
          	</tr>
          	<tr>
             <td>GEO 200 - Physical Geography <a href="genEdClassSearch?classType=GEO&classNumber=200">Search For This Class</a></td>
          	</tr>
          	<tr>
             <td>PHY 100 - Patterns in Nature <a href="genEdClassSearch?classType=PHY&classNumber=100">Search For This Class</a></td>
          	</tr>   	
       	</c:otherwise>
       </c:choose>
       
       <tr><th>2.Life Science (3 Units)</th></tr>
       <c:choose>
       	<c:when test="${Life}">
       		<td>REQUIREMENT MET</td>
       	</c:when>
       	<c:otherwise>
          	<tr>
             <td>ANT 101 - Intro to Biological Anthropology <a href="genEdClassSearch?classType=ANT&classNumber=101">Search For This Class</a></td>
          	</tr>
          	<tr>
             <td>BIO 102 - General Biology <a href="genEdClassSearch?classType=BIO&classNumber=102">Search For This Class</a></td>
          	</tr>
       	</c:otherwise>
       </c:choose>
       
       <tr><th>3. Science Laboratory (1 Unit)</th></tr>
       <c:choose>
       	<c:when test="${ScienceLab}">
       		<td>REQUIREMENT MET</td>
       	</c:when>
       	<c:otherwise>
          	<tr>
             <td>BIO 103 - General Biology Lab <a href="genEdClassSearch?classType=BIO&classNumber=103">Search For This Class</a></td>
          	</tr>
          	<tr>
             <td>EAR 101 - Physical Geology Lab <a href="genEdClassSearch?classType=EAR&classNumber=101">Search For This Class</a></td>
          	</tr>
          	<tr>
             <td>CHE 103 - Chemistry Lab for the Citizen <a href="genEdClassSearch?classType=CHE&classNumber=103">Search For This Class</a></td>
          	</tr>
       	</c:otherwise>
       </c:choose>
       
       <tr><th>4. Quantitative Reasoning and Problem Solving  (3 Units)</th></tr>
       <c:choose>
       	<c:when test="${Quantitative}">
       		<td>REQUIREMENT MET</td>
       	</c:when>
       	<c:otherwise>
          	<tr>
             <td>MAT 105 - Finite Mathematics <a href="genEdClassSearch?classType=MAT&classNumber=105">Search For This Class</a></td>
          	</tr>
          	<tr>
             <td>MAT 131 - Elementary Statistics and Probability <a href="genEdClassSearch?classType=MAT&classNumber=131">Search For This Class</a></td>
          	</tr>
          	<tr>
             <td>MAT 132 - Elementary Statistics and Probability with Algebra Review <a href="genEdClassSearch?classType=MAT&classNumber=132">Search For This Class</a></td>
          	</tr>
          	<tr>
             <td>MAT 151 - College Algebra with Intermediate Algebra Review <a href="genEdClassSearch?classType=MAT&classNumber=151">Search For This Class</a></td>
          	</tr>
          	<tr>
             <td>MAT 153 - Precalculas <a href="genEdClassSearch?classType=MAT&classNumber=153">Search For This Class</a></td>
          	</tr>
          	<tr>
             <td>MAT 171 - Survey Calculus for Management and Life Sciences <a href="genEdClassSearch?classType=MAT&classNumber=171">Search For This Class</a></td>
          	</tr>
          	<tr>
             <td>MAT 191 - Calculus I <a href="genEdClassSearch?classType=MAT&classNumber=191">Search For This Class</a></td>
          	</tr>
          	<tr>
             <td>MAT 193 - Calculus II <a href="genEdClassSearch?classType=MAT&classNumber=193">Search For This Class</a></td>
          	</tr>
       	</c:otherwise>
       </c:choose>
    </table>
	
	<table border="10" cellpadding="5" cellspacing="1" width="1000" >
       <tr>
          <th>C. Area of the Humanities (9 Units) </th>
          
       </tr>
       	  <c:choose>
       		<c:when test="${Humanities}">
       		<tr><th>1. Student MUST take a 3 unit arts course and a 3 unit letters course. A student may not take all 3 courses from a single academic department.
       			REQUIREMENT MET </th></tr>
       		</c:when>
       		<c:otherwise>
       		<tr><th>1. Student MUST take a 3 unit arts course and a 3 unit letters course. A student may not take all 3 courses from a single academic department.</th></tr>
       		</c:otherwise>
       		</c:choose>
       
       <tr><th>2. Arts Courses (at least 3 Units)</th></tr>
       <c:choose>
       	<c:when test="${Arts}">
       		<td>REQUIREMENT MET</td>
       	</c:when>
       	<c:otherwise>
          	<tr>
             <td>AFS 205 - Intro to Hip Hop <a href="genEdClassSearch?classType=AFS&classNumber=205">Search For This Class</a></td>
          	</tr>
          	<tr>
             <td>APP 225 - Pacific Islander Culture in Oceania and the U.S. <a href="genEdClassSearch?classType=APP&classNumber=101">Search For This Class</a></td>
          	</tr>
          	<tr>
             <td>ART 100 - Looking at Art <a href="genEdClassSearch?classType=ART&classNumber=100">Search For This Class</a></td>
          	</tr>
          	<tr>
             <td>ART 101 - Experiencing Creative Art <a href="genEdClassSearch?classType=ART&classNumber=101">Search For This Class</a></td>
          	</tr>
          	<tr>
             <td>CHS 125 - Chicana and Latino Musical Culture <a href="genEdClassSearch?classType=CHS&classNumber=125">Search For This Class</a></td>
          	</tr>
          	<tr>
             <td>COM 130 - Film Classics <a href="genEdClassSearch?classType=COM&classNumber=130">Search For This Class</a></td>
          	</tr>
          	<tr>
             <td>DAN 130 - Dance Perceptions <a href="genEdClassSearch?classType=DAN&classNumber=130">Search For This Class</a></td>
          	</tr>
          	<tr>
             <td>ENG 271 - Intro to Creative Writing <a href="genEdClassSearch?classType=ENG&classNumber=271">Search For This Class</a></td>
          	</tr>
          	<tr>
             <td>MUS 101 - Introducing Music <a href="genEdClassSearch?classType=MUS&classNumber=101">Search For This Class</a></td>
          	</tr>
          	<tr>
             <td>MUS 110 - Music Fundamentals <a href="genEdClassSearch?classType=MUS&classNumber=110">Search For This Class</a></td>
          	</tr>
          	<tr>
             <td>MUS 201 - From the Silent Era to the Lord of the Rings <a href="genEdClassSearch?classType=MUS&classNumber=201">Search For This Class</a></td>
          	</tr>
          	<tr>
             <td>MUS 250 - History of Rock <a href="genEdClassSearch?classType=MUS&classNumber=250">Search For This Class</a></td>
          	</tr>
          	<tr>
             <td>THE 100 - Television, Films, and Theatre <a href="genEdClassSearch?classType=THE&classNumber=100">Search For This Class</a></td>
          	</tr>
          	<tr>
             <td>THE 160 - Intro to Acting <a href="genEdClassSearch?classType=THE&classNumber=160">Search For This Class</a></td>
          	</tr>
       	</c:otherwise>
       </c:choose>
       <tr><th>3. Letters Courses (at least 3 Units)</th></tr>
       <c:choose>
       	<c:when test="${Letters}">
       		<td>REQUIREMENT MET</td>
       	</c:when>
       	<c:otherwise>
          	<tr>
             <td>AFS 200 - Intro to Africana Studies <a href="genEdClassSearch?classType=AFS&classNumber=200">Search For This Class</a></td>
          	</tr>
          	<tr>
             <td>AFS 231 - Africana Literary Traditions <a href="genEdClassSearch?classType=AFS&classNumber=231">Search For This Class</a></td>
          	</tr>
          	<tr>
             <td>APP 101 - Intro to Asian Studies <a href="genEdClassSearch?classType=APP&classNumber=101">Search For This Class</a></td>
          	</tr>
          	<tr>
             <td>APP 201 - Intro to Asian American Studies <a href="genEdClassSearch?classType=APP&classNumber=201">Search For This Class</a></td>
          	</tr>
          	<tr>
             <td>CHS 100 - The Americas: European Cultural and Historical Synthesis <a href="genEdClassSearch?classType=CHS&classNumber=100">Search For This Class</a></td>
          	</tr>
          	<tr>
             <td>CHS 205 - Intro to Chicano Literature <a href="genEdClassSearch?classType=CHS&classNumber=205">Search For This Class</a></td>
          	</tr>
          	<tr>
             <td>COM 100 - Media and Society <a href="genEdClassSearch?classType=COM&classNumber=100">Search For This Class</a></td>
          	</tr>
          	<tr>
             <td>ENG 230 - Literature and Popular Culture <a href="genEdClassSearch?classType=ENG&classNumber=230">Search For This Class</a></td>
          	</tr>
          	<tr>
             <td>FRE 220 - Second-Year French <a href="genEdClassSearch?classType=FRE&classNumber=220">Search For This Class</a></td>
          	</tr>
          	<tr>
             <td>HUM 200 - Intro to the Humanities <a href="genEdClassSearch?classType=HUM&classNumber=200">Search For This Class</a></td>
          	</tr>
          	<tr>
             <td>HUM 212 - Intro to African American Culture <a href="genEdClassSearch?classType=HUM&classNumber=212">Search For This Class</a></td>
          	</tr>
          	<tr>
             <td>JPN 110 - Beginning Japanese I <a href="genEdClassSearch?classType=JPN&classNumber=110">Search For This Class</a></td>
          	</tr>
          	<tr>
             <td>JPN 111 - Beginning Japanese II <a href="genEdClassSearch?classType=JPN&classNumber=111">Search For This Class</a></td>
          	</tr>
          	<tr>
             <td>PHI 101 - Values and Society <a href="genEdClassSearch?classType=PHI&classNumber=101">Search For This Class</a></td>
          	</tr>
          	<tr>
             <td>PHI 102 - Humanity, Nature and God <a href="genEdClassSearch?classType=PHI&classNumber=102">Search For This Class</a></td>
          	</tr>
          	<tr>
             <td>PHI 201 - The Good Life <a href="genEdClassSearch?classType=PHI&classNumber=201">Search For This Class</a></td>
          	</tr>
          	<tr>
             <td>PHI 202 - The Devil You Don't Know <a href="genEdClassSearch?classType=PHI&classNumber=202">Search For This Class</a></td>
          	</tr>
          	<tr>
             <td>SPA 151 - Intro to Hispanic Culture <a href="genEdClassSearch?classType=SPA&classNumber=151">Search For This Class</a></td>
          	</tr>
          	<tr>
             <td>SPA 221 - Intermediate Spanish <a href="genEdClassSearch?classType=SPA&classNumber=221">Search For This Class</a></td>
          	</tr>
          	<tr>
             <td>WMS 100 - Gender, Sex, the Body, and Politics: An Introduction <a href="genEdClassSearch?classType=WMS&classNumber=100">Search For This Class</a></td>
          	</tr>
       	</c:otherwise>
       </c:choose>
       
    </table>
    
    <table border="10" cellpadding="5" cellspacing="1" width="1000" >
       <tr>
          <th>D. Area of the Social Sciences (9 Units)</th>
          
       </tr>
       <c:choose>
       		<c:when test="${Social}">
       		<tr><th>1. Students must take one course from Perspectives on Individuals, Groups and Society and one course from Global and Historical Perspectives. A student may not take all 3 courses in this area from a single academic department. 
       			REQUIREMENT MET </th></tr>
       		</c:when>
       		<c:otherwise>
       		<tr><th>1. Students must take one course from Perspectives on Individuals, Groups and Society and one course from Global and Historical Perspectives. A student may not take all 3 courses in this area from a single academic department.</th></tr>
       		</c:otherwise>
       		</c:choose>
       
       <tr><th>2.Perspectives on Individuals, Groups and Society</th></tr>
       <c:choose>
       	<c:when test="${Society}">
       		<td>REQUIREMENT MET</td>
       	</c:when>
       	<c:otherwise>
          	<tr>
             <td>AFS 100 - The African American Experience <a href="genEdClassSearch?classType=AFS&classNumber=100">Search For This Class</a></td>
          	</tr>
          	<tr>
             <td>AFS 220 - African World Peoples and Culture <a href="genEdClassSearch?classType=AFS&classNumber=220">Search For This Class</a></td>
          	</tr>
          	<tr>
             <td>ANT 100 - Intro to Cultures <a href="genEdClassSearch?classType=ANT&classNumber=100">Search For This Class</a></td>
          	</tr>
          	<tr>
             <td>APP 212 - Intro to Comparative Ethnic and Global Societies <a href="genEdClassSearch?classType=APP&classNumber=212">Search For This Class</a></td>
          	</tr>
          	<tr>
             <td>CHS 212 - Intro to Comparative Ethnic and Global Societies <a href="genEdClassSearch?classType=CHS&classNumber=212">Search For This Class</a></td>
          	</tr>
          	<tr>
             <td>ECO 210 - Economic Theory 1A- Microeconomics <a href="genEdClassSearch?classType=ECO&classNumber=210">Search For This Class</a></td>
          	</tr>
          	<tr>
             <td>ECO 211 - Economic Theory 1B- Macroeconomics <a href="genEdClassSearch?classType=ECO&classNumber=211">Search For This Class</a></td>
          	</tr>
          	<tr>
             <td>IDS 210 - Intro to Environmental Studies <a href="genEdClassSearch?classType=IDS&classNumber=210">Search For This Class</a></td>
          	</tr>
          	<tr>
             <td>LBS 205 - Child and Adolescent Development <a href="genEdClassSearch?classType=LBS&classNumber=205">Search For This Class</a></td>
          	</tr>
          	<tr>
             <td>LAW 240 - Legal Environment of Business <a href="genEdClassSearch?classType=LAW&classNumber=240">Search For This Class</a></td>
          	</tr>
          	<tr>
             <td>PSY 101 - General Studies Psychology: Understanding Human Behavior <a href="genEdClassSearch?classType=PSY&classNumber=101">Search For This Class</a></td>
          	</tr>
          	<tr>
             <td>SOC 101 - The Individual in Society <a href="genEdClassSearch?classType=SOC&classNumber=101">Search For This Class</a></td>
          	</tr>
          	<tr>
             <td>SOC 102 - Understanding Social Relationships <a href="genEdClassSearch?classType=SOC&classNumber=102">Search For This Class</a></td>
          	</tr>
          	<tr>
             <td>WMS 250 - Intro to Women's Studies <a href="genEdClassSearch?classType=PHI&classNumber=101">Search For This Class</a></td>
          	</tr>
       	</c:otherwise>
       </c:choose>
       <tr><th>3. Global and Historical Perspectives</th></tr>
       <c:choose>
       	<c:when test="${Global}">
       		<td>REQUIREMENT MET</td>
       	</c:when>
       	<c:otherwise>
          	<tr>
             <td>AFS 201 - African World Civilization <a href="genEdClassSearch?classType=AFS&classNumber=201">Search For This Class</a></td>
          	</tr>
          	<tr>
             <td>ANT 102 - Ancient Civilizations <a href="genEdClassSearch?classType=ANT&classNumber=102">Search For This Class</a></td>
          	</tr>
          	<tr>
             <td>CHS 200 - Key Themes in Chicano and Latino History <a href="genEdClassSearch?classType=CHS&classNumber=200">Search For This Class</a></td>
          	</tr>
          	<tr>
             <td>ENG 150 - Languages of the World <a href="genEdClassSearch?classType=ENG&classNumber=150">Search For This Class</a></td>
          	</tr>
          	<tr>
             <td>GEO 100 - Human Geography <a href="genEdClassSearch?classType=GEO&classNumber=100">Search For This Class</a></td>
          	</tr>
          	<tr>
             <td>HIS 120 - World Civilizations I <a href="genEdClassSearch?classType=HIS&classNumber=120">Search For This Class</a></td>
          	</tr>
          	<tr>
             <td>HIS 121 - World Civilizations II <a href="genEdClassSearch?classType=HIS&classNumber=121">Search For This Class</a></td>
          	</tr>
          	<tr>
             <td>LBR 200 - Labor and the Environment <a href="genEdClassSearch?classType=LBR&classNumber=200">Search For This Class</a></td>
          	</tr>
          	<tr>
             <td>MGT 200 - Global Organizational Ethics and Social Responsibility <a href="genEdClassSearch?classType=MGT&classNumber=200">Search For This Class</a></td>
          	</tr>
          	<tr>
             <td>POL 100 - General Studies Political Science: World Perspectives <a href="genEdClassSearch?classType=POL&classNumber=100">Search For This Class</a></td>
          	</tr>
       	</c:otherwise>
       </c:choose>     
    </table>
    
    <table border="10" cellpadding="5" cellspacing="1" width="1000" >
       <tr>
          <th>E. Objectives for Lifelong Learning and Self-Development (3 Units)</th>
          
       </tr>
       
       <c:choose>
       	<c:when test="${Lifelong}">
       		<td>REQUIREMENT MET</td>
       	</c:when>
       	<c:otherwise>
          	<tr>
             <td>BUS 100 - Entrepreneurship for Everyone <a href="genEdClassSearch?classType=BUS&classNumber=100">Search For This Class</a></td>
          	</tr>
          	<tr>
             <td>CIS 275 - Internet Literacy <a href="genEdClassSearch?classType=CIS&classNumber=275">Search For This Class</a></td>
          	</tr>
          	<tr>
             <td>FIN 200 - Personal Finance for Non-Finance Majors <a href="genEdClassSearch?classType=FIN&classNumber=200">Search For This Class</a></td>
          	</tr>
          	<tr>
             <td>HEA 100 - Health and Lifestyles <a href="genEdClassSearch?classType=HEA&classNumber=100">Search For This Class</a></td>
          	</tr>
          	<tr>
             <td>HEA 201 - Health Care Systems and Perspectives <a href="genEdClassSearch?classType=HEA&classNumber=201">Search For This Class</a></td>
          	</tr>
          	<tr>
             <td>KIN 235 - Lifetime Fitness <a href="genEdClassSearch?classType=KIN&classNumber=235">Search For This Class</a></td>
          	</tr>
          	<tr>
             <td>LIB 151 - Fundamentals of Information Literacy <a href="genEdClassSearch?classType=LIB&classNumber=151">Search For This Class</a></td>
          	</tr>
          	<tr>
             <td>REC 100 - Dimensions of Leisure <a href="genEdClassSearch?classType=REC&classNumber=100">Search For This Class</a></td>
          	</tr>
          	<tr>
             <td>UNV 101 - Personal, Social, Intellectual Development <a href="genEdClassSearch?classType=UNV&classNumber=101">Search For This Class</a></td>
          	</tr>
       	</c:otherwise> 
       	</c:choose>  
    </table>
    
    <table border="10" cellpadding="5" cellspacing="1" width="1000" >
       <tr>
          <th>F. Upper Division Integrative Studies (9 Units)</th>
          
       </tr>
       <tr><th>Select one course from each category. Courses in this category are to be taken after 60 semester units and ALL lower division General Education courses have been completed.</th>
       </tr> 
       
       <tr><th>1. Integrative Studies in the Humanities</th></tr>
       <c:choose>
       	<c:when test="${IntegrativeHumanities}">
       		<td>REQUIREMENT MET</td>
       	</c:when>
       	<c:otherwise>
          	<tr>
             <td>AFS 331 - Key Movements: African Literature and Culture <a href="genEdClassSearch?classType=AFS&classNumber=331">Search For This Class</a></td>
          	</tr>
          	<tr>
             <td>AFS 332 - Key Movements: Harlem Renaissance <a href="genEdClassSearch?classType=AFS&classNumber=332">Search For This Class</a></td>
          	</tr>
          	<tr>
             <td>AFS 333 - Black Movements of the Sixties <a href="genEdClassSearch?classType=AFS&classNumber=333">Search For This Class</a></td>
          	</tr>
          	<tr>
             <td>AFS 334 - African Culture and Art <a href="genEdClassSearch?classType=AFS&classNumber=334">Search For This Class</a></td>
          	</tr>
          	<tr>
             <td>APP 314 - Asian Americans and the Media <a href="genEdClassSearch?classType=APP&classNumber=314">Search For This Class</a></td>
          	</tr>
          	<tr>
             <td>APP 315 - Asian Pop Culture and Globalization <a href="genEdClassSearch?classType=APP&classNumber=315">Search For This Class</a></td>
          	</tr>
          	<tr>
             <td>APP 325 - Asian Pacific Art, Music and Literature <a href="genEdClassSearch?classType=APP&classNumber=325">Search For This Class</a></td>
          	</tr>
          	<tr>
             <td>APP 339 - Asian Diaspora and Transnational Asian Religions <a href="genEdClassSearch?classType=APP&classNumber=339">Search For This Class</a></td>
          	</tr>
          	<tr>
             <td>APP 343 - Asian-Pacific Film and Literature <a href="genEdClassSearch?classType=APP&classNumber=343">Search For This Class</a></td>
          	</tr>
          	<tr>
             <td>ARH 370 - Art and Social Protest <a href="genEdClassSearch?classType=ARH&classNumber=370">Search For This Class</a></td>
          	</tr>
          	<tr>
             <td>CHS 340 - Native American and Chicana Women's Prose <a href="genEdClassSearch?classType=CHS&classNumber=340">Search For This Class</a></td>
          	</tr>
          	<tr>
             <td>CHS 345 - Latino Identity in the Americas <a href="genEdClassSearch?classType=CHS&classNumber=345">Search For This Class</a></td>
          	</tr>
          	<tr>
             <td>ENG 308 - Critical Approaches to Children's Literature <a href="genEdClassSearch?classType=ENG&classNumber=308">Search For This Class</a></td>
          	</tr>
          	<tr>
             <td>HIS 355 - American Civil Rights History <a href="genEdClassSearch?classType=HIS&classNumber=355">Search For This Class</a></td>
          	</tr>
          	<tr>
             <td>HIS 375 - Popular Cultures in History <a href="genEdClassSearch?classType=HIS&classNumber=375">Search For This Class</a></td>
          	</tr>
          	<tr>
             <td>HIS 376 - Film as History <a href="genEdClassSearch?classType=HIS&classNumber=376">Search For This Class</a></td>
          	</tr>
          	<tr>
             <td>HUM 310 - Key Concepts <a href="genEdClassSearch?classType=HUM&classNumber=310">Search For This Class</a></td>
          	</tr>
          	<tr>
             <td>HUM 312 - Key Movements <a href="genEdClassSearch?classType=HUM&classNumber=312">Search For This Class</a></td>
          	</tr>
          	<tr>
             <td>HUM 314 - Key Issues <a href="genEdClassSearch?classType=HUM&classNumber=314">Search For This Class</a></td>
          	</tr>
          	<tr>
             <td>IDS 312 - Interdisciplinary Approach to the Humanities <a href="genEdClassSearch?classType=IDS&classNumber=312">Search For This Class</a></td>
          	</tr>
          	<tr>
             <td>LBR 310 - Success and Values <a href="genEdClassSearch?classType=LBR&classNumber=310">Search For This Class</a></td>
          	</tr>
          	<tr>
             <td>LBR 312 - Decade of the Sixties <a href="genEdClassSearch?classType=LBR&classNumber=312">Search For This Class</a></td>
          	</tr>
          	<tr>
             <td>LBR 314 - Key Issues: American Dream <a href="genEdClassSearch?classType=LBR&classNumber=314">Search For This Class</a></td>
          	</tr>
          	<tr>
             <td>MUS 312 - The Jazz Age <a href="genEdClassSearch?classType=MUS&classNumber=312">Search For This Class</a></td>
          	</tr>
          	<tr>
             <td>MUS 345 - Global Popular Music: Identity and Social Change <a href="genEdClassSearch?classType=MUS&classNumber=345">Search For This Class</a></td>
          	</tr>
          	<tr>
             <td>MUS 486 - Late Romantic- 20th/21st Century Music <a href="genEdClassSearch?classType=MUS&classNumber=486">Search For This Class</a></td>
          	</tr>
          	<tr>
             <td>PHI 351 - Death and Dying <a href="genEdClassSearch?classType=PHI&classNumber=351">Search For This Class</a></td>
          	</tr>
          	<tr>
             <td>PHI 352 - Myth as Reality <a href="genEdClassSearch?classType=PHI&classNumber=352">Search For This Class</a></td>
          	</tr>
          	<tr>
             <td>PHI 353 - Age of Revolt <a href="genEdClassSearch?classType=PHI&classNumber=353">Search For This Class</a></td>
          	</tr>
          	<tr>
             <td>PHI 383 - Comparative Religions <a href="genEdClassSearch?classType=PHI&classNumber=383">Search For This Class</a></td>
          	</tr>
          	<tr>
             <td>SPA 310 - Romantic Love in the Western Tradition <a href="genEdClassSearch?classType=SPA&classNumber=310">Search For This Class</a></td>
          	</tr>
          	<tr>
             <td>SPA 312 - Hispanic Literature, Art and Culture <a href="genEdClassSearch?classType=SPA&classNumber=312">Search For This Class</a></td>
          	</tr>
          	<tr>
             <td>SPA 313 - Encountering the Other <a href="genEdClassSearch?classType=SPA&classNumber=313">Search For This Class</a></td>
          	</tr>
          	<tr>
             <td>THE 313 - Voices of Contemporary Women Playwrights <a href="genEdClassSearch?classType=THE&classNumber=313">Search For This Class</a></td>
          	</tr>
          	<tr>
             <td>THE 315 - The American Musical <a href="genEdClassSearch?classType=THE&classNumber=315">Search For This Class</a></td>
          	</tr>
          	<tr>
             <td>THE 317 - Theatre of Revolt <a href="genEdClassSearch?classType=THE&classNumber=317">Search For This Class</a></td>
          	</tr>
          	<tr>
             <td>THE 319 - The Power of Masks <a href="genEdClassSearch?classType=THE&classNumber=319">Search For This Class</a></td>
          	</tr>
          	<tr>
             <td>WMS 310 - The Witch in Literature <a href="genEdClassSearch?classType=WMS&classNumber=310">Search For This Class</a></td>
          	</tr>
          	<tr>
             <td>WMS 311 - Comedy, Sex and Gender <a href="genEdClassSearch?classType=WMS&classNumber=311">Search For This Class</a></td>
          	</tr>
          	<tr>
             <td>WMS 314 - Feminism and Film <a href="genEdClassSearch?classType=WMS&classNumber=314">Search For This Class</a></td>
          	</tr>
          	<tr>
             <td>WMS 315 - Literature and the Rights of Women <a href="genEdClassSearch?classType=WMS&classNumber=315">Search For This Class</a></td>
          	</tr>
       	</c:otherwise>
       </c:choose>
       <tr><th>2. Integrative Studies in the Natural Sciences</th></tr>
       <c:choose>
       	<c:when test="${IntegrativeNatural}">
       		<td>REQUIREMENT MET</td>
       	</c:when>
       	<c:otherwise>
          	<tr>
             <td>BIO 336 - Environmental Biology <a href="genEdClassSearch?classType=BIO&classNumber=336">Search For This Class</a></td>
          	</tr>
          	<tr>
             <td>BIO 340 - Genetics <a href="genEdClassSearch?classType=BIO&classNumber=340">Search For This Class</a></td>
          	</tr>
          	<tr>
             <td>CSC 301 - Computers and Society <a href="genEdClassSearch?classType=CSC&classNumber=301">Search For This Class</a></td>
          	</tr>
          	<tr>
             <td>EAR 312 - Natural Disasters <a href="genEdClassSearch?classType=EAR&classNumber=312">Search For This Class</a></td>
          	</tr>
          	<tr>
             <td>EAR 416 - Earth Sciences for Teachers <a href="genEdClassSearch?classType=EAR&classNumber=416">Search For This Class</a></td>
          	</tr>
          	<tr>
             <td>IDS 310 - Global Climate Change <a href="genEdClassSearch?classType=IDS&classNumber=310">Search For This Class</a></td>
          	</tr>
          	<tr>
             <td>LBS 380 - Blended Science Methods <a href="genEdClassSearch?classType=LBS&classNumber=380">Search For This Class</a></td>
          	</tr>
          	<tr>
             <td>SMT 310 - Science and Technology <a href="genEdClassSearch?classType=SMT&classNumber=310">Search For This Class</a></td>
          	</tr>
          	<tr>
             <td>SMT 314 - Introduction to Cosmology <a href="genEdClassSearch?classType=SMT&classNumber=314">Search For This Class</a></td>
          	</tr>
       	</c:otherwise>
       </c:choose>   
       <tr><th>3. Integrative Studies in Social Sciences</th></tr>
       <c:choose>
       	<c:when test="${IntegrativeSocial}">
       		<td>REQUIREMENT MET</td>
       	</c:when>
       	<c:otherwise>
          	<tr>
             <td>AFS 310 - The African American Experience in the US <a href="genEdClassSearch?classType=AFS&classNumber=310">Search For This Class</a></td>
          	</tr>
          	<tr>
             <td>AFS 311 - Afro Latinidad & the Caribbean <a href="genEdClassSearch?classType=AFS&classNumber=311">Search For This Class</a></td>
          	</tr>
          	<tr>
             <td>AFS 312 - Cultural Pluralism: Ethnic and Global Society <a href="genEdClassSearch?classType=AFS&classNumber=312">Search For This Class</a></td>
          	</tr>
          	<tr>
             <td>ANT 312 - Language and Culture <a href="genEdClassSearch?classType=ANT&classNumber=312">Search For This Class</a></td>
          	</tr>
          	<tr>
             <td>ANT 334 - Cultural Pluralism: Mesoamerica Past and Present <a href="genEdClassSearch?classType=ANT&classNumber=334">Search For This Class</a></td>
          	</tr>
          	<tr>
             <td>ANT 336 - Comparative Cultures: Culture, Environments, and Globalization <a href="genEdClassSearch?classType=ANT&classNumber=336">Search For This Class</a></td>
          	</tr>
          	<tr>
             <td>ANT 337 - Ethnography and Film <a href="genEdClassSearch?classType=ANT&classNumber=337">Search For This Class</a></td>
          	</tr>
          	<tr>
             <td>ANT 338 - Mainland Southeast Asia <a href="genEdClassSearch?classType=ANT&classNumber=338">Search For This Class</a></td>
          	</tr>
          	<tr>
             <td>ANT 342 - South America <a href="genEdClassSearch?classType=ANT&classNumber=342">Search For This Class</a></td>
          	</tr>
          	<tr>
             <td>ANT 371 - Historical and Cultural Perspectives in Disability Studies <a href="genEdClassSearch?classType=ANT&classNumber=371">Search For This Class</a></td>
          	</tr>
          	<tr>
             <td>APP 311 - Contemporary Issues in Asian American Communities <a href="genEdClassSearch?classType=APP&classNumber=311">Search For This Class</a></td>
          	</tr>
          	<tr>
             <td>APP 318 - Vietnamese, Cambodian, and Lao Americans: Culture, History and Identity <a href="genEdClassSearch?classType=APP&classNumber=318">Search For This Class</a></td>
          	</tr>
          	<tr>
             <td>APP 327 - Values and Communication of Asian Pacific Cultures <a href="genEdClassSearch?classType=APP&classNumber=327">Search For This Class</a></td>
          	</tr>
          	<tr>
             <td>APP 350 - Asian Pacific Gender & Family <a href="genEdClassSearch?classType=APP&classNumber=350">Search For This Class</a></td>
          	</tr>
          	<tr>
             <td>APP 335 - Asian Pacific Culinary Culture <a href="genEdClassSearch?classType=APP&classNumber=335">Search For This Class</a></td>
          	</tr>
          	<tr>
             <td>CHS 323 - U.S. Immigration and Citizenship: A Latina/o Perspective <a href="genEdClassSearch?classType=CHS&classNumber=323">Search For This Class</a></td>
          	</tr>
          	<tr>
             <td>CHS 330 - Mexican and Latino Identities in the United States <a href="genEdClassSearch?classType=CHS&classNumber=330">Search For This Class</a></td>
          	</tr>
          	<tr>
             <td>CHS 335 - Urban Youth Gangs in Los Angeles <a href="genEdClassSearch?classType=CHS&classNumber=335">Search For This Class</a></td>
          	</tr>
          	<tr>
             <td>GEO 318 - Cultural Pluralism: The Human Environment: Methods of Knowledge and Truth <a href="genEdClassSearch?classType=GEO&classNumber=318">Search For This Class</a></td>
          	</tr>
          	<tr>
             <td>HEA 468 - Multicultural Health <a href="genEdClassSearch?classType=HEA&classNumber=468">Search For This Class</a></td>
          	</tr>
          	<tr>
             <td>HIS 340 - The American West <a href="genEdClassSearch?classType=HIS&classNumber=340">Search For This Class</a></td>
          	</tr>
          	<tr>
             <td>HIS 348 - Labor in American Society <a href="genEdClassSearch?classType=HIS&classNumber=348">Search For This Class</a></td>
          	</tr>
          	<tr>
             <td>HIS 352 - Topics in United States Foreign Relations History <a href="genEdClassSearch?classType=HIS&classNumber=352">Search For This Class</a></td>
          	</tr>
          	<tr>
             <td>HIS 354 - History of American Immigration <a href="genEdClassSearch?classType=HIS&classNumber=354">Search For This Class</a></td>
          	</tr>
          	<tr>
             <td>HIS 380 - Women in History <a href="genEdClassSearch?classType=HIS&classNumber=380">Search For This Class</a></td>
          	</tr>
          	<tr>
             <td>IDS 304 - Global Politics, Economics, Environment and Society <a href="genEdClassSearch?classType=IDS&classNumber=304">Search For This Class</a></td>
          	</tr>
          	<tr>
             <td>IDS 318 - Interdisciplinary Approaches to Cultural Pluralism: Immigration in the United States <a href="genEdClassSearch?classType=IDS&classNumber=318">Search For This Class</a></td>
          	</tr>
          	<tr>
             <td>LBS 370 - Multicultural Studies <a href="genEdClassSearch?classType=LBS&classNumber=370">Search For This Class</a></td>
          	</tr>
          	<tr>
             <td>SBS 318 - Cultural Pluralism <a href="genEdClassSearch?classType=SB&classNumber=318">Search For This Class</a></td>
          	</tr>
          	<tr>
             <td>WMS 318 - Race, Class and Gender <a href="genEdClassSearch?classType=WMS&classNumber=318">Search For This Class</a></td>
          	</tr>
       	</c:otherwise>
       </c:choose>  
    </table>
 
    <jsp:include page="_footer.jsp"></jsp:include>
 	</div>
 </body>
</html>