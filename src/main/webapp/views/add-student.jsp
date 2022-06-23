<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="addStudent" method="POST">
		<div>
			<label>Full name:</label>
			<input type="text" name="name"/>
		</div>
		<div>
			<label>Email:</label>
			<input type="email" name="email"/>
		</div>
		<input type="submit"/>
	</form>
</body>
</html>