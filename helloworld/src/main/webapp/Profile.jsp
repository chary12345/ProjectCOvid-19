<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
body {
  font-family: Arial;
}

* {
  box-sizing: border-box;
}

form.example input[type=text] {
  padding: 10px;
  font-size: 17px;
  border: 1px solid grey;
  float: left;
  width: 80%;
  background: #f1f1f1;
}

form.example button {
  float: left;
  width: 20%;
  padding: 10px;
  background: #2196F3;
  color: white;
  font-size: 17px;
  border: 1px solid grey;
  border-left: none;
  cursor: pointer;
}

form.example button:hover {
  background: #0b7dda;
}

form.example::after {
  content: "";
  clear: both;
  display: table;
}
table, th, td {
  border: 1px solid black;
  border-collapse: collapse;
}
</style>
<script type="text/javascript">
	
	function alertSend(mobile) {
		
		alert('triggered Edit button ' + mobile);
		document.forms[0].action = "${pageContext.request.contextPath}/alert?mobile="+ mobile;
		document.forms[0].method = "post";
		document.forms[0].submit(); 
	} 
</script>
</head>
<body>

<marquee><h3>Search Below with Student Email.....</h3></marquee>
${alert}
<!-- <form action="fetchAll"  style="margin:auto;max-width:150x" method="post">
<input type="submit" value="AllData">
</form><br> -->
<form  action="searchByEmail" style="margin:auto;max-width:300px" method="post">
  <input type="text" placeholder="Search.." name="mobile">
  <button type="submit"><i class="fa fa-search"></i></button>
  <br>
  
	

</form ><br><br>
<h4>${noRecord}</h4>

<!-- Need to write for each in jsp to iterate userList -->
	<table border="3">
		<tr>
		 	<th bgcolor="#FF000">Email</th>
		 	<th >Date-Of-Birth</th>
		 	<th >Phone Number</th>
		 	
		</tr>
		<core:forEach  var="userObject" items="${user}">
			<tr>
				<td>${userObject.email}</td>
				<td>${userObject.dob}</td>
				<td>${userObject.mobile}</td>
				<td><input type="button" onclick="alertSend('${userObject.mobile}')" value="SendAlert"></td>
				
			</tr>
		</core:forEach>
	</table>

	
<%-- <table style="width:50%">
  <tr>
    <th>Email</th>
    <th>Date-Of-Birth</th> 
    <th>Phone Number</th>
  </tr>
  <tr>
    <td>${users.get(0).getEmail()}</td>
    <td>${users.get(0).getDob()}</td>
    <td>${users.get(0).getPhno()}</td>
  </tr>
  
</table> --%>

</body>
</html> 

