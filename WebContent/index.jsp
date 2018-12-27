<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>
</head>
<body>
	<h1>Indiatechsoft Registration page</h1>
	<form action="RegisterServlet" method="post">
		First Name: <input type="text" name="fname" id="n1"><br>
		Last Name: <input type="text" name="lname" id="n2"><br>
		Email: <input type="text" name="email" id="n3"><br>
		Password: <input type="password" name="pword" id="n4"><br>
		<input type="submit" name="submit" value="submit"> 
	</form>
</body>
</html>