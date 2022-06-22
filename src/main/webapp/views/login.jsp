<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link type="text/css"
	href="${pageContext.request.contextPath}/resources/css/login.css"
	rel="stylesheet">
</head>
<body>
	<div>
		<form class="wrapper" action="login" method="POST">
			<div class="inner">
				<h1 class="header">Welcome</h1>
				<div class="body">
					<div>
						<input class="input" type="text" name="username"
							placeholder="Username" />
					</div>
					<div>
						<input class="input" type="text" name="password"
							placeholder="Password" />
					</div>
					
					<!-- <div class="login-fail">Incorrect username or password</div> -->
					<!-- <div class="logout-success">Logout successfully</div> -->
					<!-- <div class="empty"></div> -->
					<div class="empty"></div>
					<button class="btn-login" type="submit">Login</button>
				</div>
			</div>
		</form>
	</div>
</body>
</html>