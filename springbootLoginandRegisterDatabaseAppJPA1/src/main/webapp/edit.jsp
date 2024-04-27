<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="update">
<pre>
<input type="hidden" name="rollno" value="${dataadd.rollno}">
Name: <input type="text" name="name" value="${dataadd.name}">
Username: <input type="text" name="username" value="${dataadd.username}">
Password: <input type="text" name="password" value="${dataadd.password}">
<input type="submit" value="Update">
</pre>
</form>


</body>
</html>