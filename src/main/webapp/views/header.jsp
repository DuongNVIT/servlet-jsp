<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link type="text/css"
	href="${pageContext.request.contextPath}/resources/css/header.css"
	rel="stylesheet">
</head>
<body>
	<header class="header">
		<div class="inner">
			<h1 class="appname">Student management application</h1>
			<div class="user">
				<h1 class="welcome">Welcome Nguyen Van Duong</h1>
				<a class="btn-logout" href='<c:url value="/logout"/>'>Logout</a>
			</div>
		</div>
	</header>
</body>
</html>