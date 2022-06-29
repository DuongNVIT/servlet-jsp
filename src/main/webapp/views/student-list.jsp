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
			<c:if test="${USERMODEL.roleModel.name == 'ADMIN'}">
				<div class="add-wrapper">
					<a class="btn-add" href='<c:url value="/student?action=add"/>'>Add
						Student</a>
				</div>
			</c:if>
			<table>
				<tr>
					<th>ID</th>
					<th>Avatar</th>
					<th>Fullname</th>
					<th>Email</th>
					<th>Class</th>
					<th>Created Date</th>
					<th>Created By</th>
					<th>Modified Date</th>
					<th>Modified By</th>
					<c:if test="${USERMODEL.roleModel.name == 'ADMIN'}">
						<th>Action</th>
					</c:if>
				</tr>
				<c:forEach var="student" items="${students}">
					<tr>
						<td>${student.id}</td>
						<td><img class="avatar"
							src="https://blogphanmem.vn/wp-content/uploads/2021/12/0baa4ce4a38e06e825013a8b6f858528.jpeg" />
						</td>
						<td class="name">${student.fullName}</td>
						<td>${student.email}</td>
						<td>${student.className}</td>
						<td>${student.createdDate}</td>
						<td>${student.createdBy}</td>
						<td>${student.modifiedDate}</td>
						<td>${student.modifiedBy}</td>
						<c:if test="${USERMODEL.roleModel.name == 'ADMIN'}">
							<td>
								<div class="action">
									<form action="deleteStudent?id=${student.id}" method="POST">
										<button class="btn-delete" type="submit">Delete</button>
									</form>
									<a class="btn-update" href="updateStudent?id=${student.id}">Update</a>
								</div>
							</td>
						</c:if>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>

</html>