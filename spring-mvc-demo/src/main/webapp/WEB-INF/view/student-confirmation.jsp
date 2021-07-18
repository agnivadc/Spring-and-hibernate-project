 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
 <!DOCTYPE html>
<html>

<head>
	<title>Student Confirmation</title>
</head>

<body>

The Student is Confirmed: ${student.firstName } ${student.lastName }

<br><br>

Country: ${student.country }

<br><br>

Favourite Language: ${student.favouriteLanguage }
 
 </body>
 
 Operating Systems: ${student.favouriteLanguage }
 
 <ul>
 	<c:forEach var="temp" items="${student.operatingSystems }">
 	
 		<li>${temp }</li>
 	
 	</c:forEach>
 </ul>
 
 </body>
 
 </html>