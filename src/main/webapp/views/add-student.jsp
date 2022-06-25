<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link type="text/css"
	href="${pageContext.request.contextPath}/resources/css/add-student.css"
	rel="stylesheet">
</head>
<body>
	<jsp:include page="../views/header.jsp" />

	<div class="body-wrapper">
		<div class="body-inner">
			<h1 class="add-header">Add Student</h1>
			<c:if test="${not empty student}">
				<form class="add-form" action="updateStudent" method="POST">
					<div class="form-group">
						<label class="form-label">Full name:</label> <input
							class="form-input" type="text" name="fullname"
							placeholder="Enter your full name" value="${student.fullName }" />
					</div>
					<div class="form-group">
						<label class="form-label">Email:</label> <input class="form-input"
							type="email" name="email" placeholder="Enter your email address"
							value="${student.email }" />
					</div>
					<div class="form-group">
						<label class="form-label">Class name:</label> <input
							class="form-input" type="text" name="class"
							placeholder="Enter your class name" value="${student.className}" />
					</div>
					<input type="hidden" name="id" value="${student.id}"/>
					<div class="btn-wrapper">
						<input class="btn-submit" type="submit" value="Update"/>
					</div>
				</form>

			</c:if>
			<c:if test="${empty student }">
				<form class="add-form" action="student?action=add" method="POST">
					<div class="form-group">
						<label class="form-label">Full name:</label> <input
							class="form-input" type="text" name="fullname"
							placeholder="Enter your full name" />
					</div>
					<div class="form-group">
						<label class="form-label">Email:</label> <input class="form-input"
							type="email" name="email" placeholder="Enter your email address" />
					</div>
					<div class="form-group">
						<label class="form-label">Class name:</label> <input
							class="form-input" type="text" name="class"
							placeholder="Enter your class name" />
					</div>
					<div class="btn-wrapper">
						<input class="btn-submit" type="submit" value="Add"/>
					</div>
				</form>
			</c:if>
		</div>
	</div>
</body>
</html>