<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Reg Form</title>
</head>
<body>
<h1>Registration Form</h1>
<form action="guru_register" method="post">
			<table style="with: 50%">
				<tr>
					<td>Name</td>
					<td><input type="text" name="name" /></td>
				</tr>
				<tr>
					<td>Email</td>
					<td><input type="text" name="email" /></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="password" name="password" /></td>
				</tr>
					<tr>
					<td>Phonenumber</td>
					<td><input type="text" name="phonenumber" /></td>
				</tr>
			  </table>
			<input type="submit" value="Submit" /></form><a href="/RegLog/login.jsp">Login</a>
</body>
</html>