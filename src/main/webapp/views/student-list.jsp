<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link type="text/css"
	href="${pageContext.request.contextPath}/resources/css/student-list.css"
	rel="stylesheet">
</head>
<body>

	<jsp:include page="../views/header.jsp" />

	<div class="body-wrapper">
		<div class="body-inner">
			<table>
				<tr>
					<th>ID</th>
					<th>Avatar</th>
					<th>Fullname</th>
					<th>Email</th>
					<th>Action</th>
				</tr>
				<tr>
					<td>1</td>
					<td><img class="avatar"
						src="https://colorlib.com/cdn-cgi/image/width=1200,height=871,fit=crop,quality=80,format=auto,onerror=redirect,metadata=none/wp-content/uploads/sites/2/css-table-templates.jpg" />
					</td>
					<td class="name">Nguyễn Văn Đương</td>
					<td>duongnv@rabiloo.com</td>
					<td><a href='<c:url value="/edit"/>'>Edit</a> <a
						href='<c:url value="/delete"/>'>Delete</a></td>
				</tr>
				<tr>
					<td>1</td>
					<td><img class="avatar"
						src="https://colorlib.com/cdn-cgi/image/width=1200,height=871,fit=crop,quality=80,format=auto,onerror=redirect,metadata=none/wp-content/uploads/sites/2/css-table-templates.jpg" />
					</td>
					<td class="name">Nguyễn Văn Đương</td>
					<td>duongnv@rabiloo.com</td>
					<td><a href='<c:url value="/edit"/>'>Edit</a> <a
						href='<c:url value="/delete"/>'>Delete</a></td>
				</tr>
				<tr>
					<td>1</td>
					<td><img class="avatar"
						src="https://colorlib.com/cdn-cgi/image/width=1200,height=871,fit=crop,quality=80,format=auto,onerror=redirect,metadata=none/wp-content/uploads/sites/2/css-table-templates.jpg" />
					</td>
					<td class="name">Nguyễn Văn Đương</td>
					<td>duongnv@rabiloo.com</td>
					<td><a href='<c:url value="/edit"/>'>Edit</a> <a
						href='<c:url value="/delete"/>'>Delete</a></td>
				</tr>
				<tr>
					<td>1</td>
					<td><img class="avatar"
						src="https://colorlib.com/cdn-cgi/image/width=1200,height=871,fit=crop,quality=80,format=auto,onerror=redirect,metadata=none/wp-content/uploads/sites/2/css-table-templates.jpg" />
					</td>
					<td class="name">Nguyễn Văn Đương</td>
					<td>duongnv@rabiloo.com</td>
					<td><a href='<c:url value="/edit"/>'>Edit</a> <a
						href='<c:url value="/delete"/>'>Delete</a></td>
				</tr>
			</table>
			<a href='<c:url value="/addStudent"/>'>Add Student</a>
		</div>
	</div>
</body>

</html>