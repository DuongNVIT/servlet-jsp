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

	<h1 style="margin-top: 60px">Xin chao</h1>

	<div class="body">
		<table>
			<th>
				<td>STT</td>
				<td>Full Nam</td>
				<td>Email</td>
				<td>Option</td>
			</th>
			<tbody>
				<tr>
					<td>1</td>
					<td>Nguyễn Văn Đương</td>
					<td>duongnv@rabiloo.com</td>
					<td>
						<a href='<c:url value="/addStudent"/>'>Add Student</a>
					</td>
				</tr>

				<tr>
					<td>2</td>
					<td>Nguyễn Văn Đương</td>
					<td>duongnv@rabiloo.com</td>
					<td>Thêm Xóa</td>
				</tr>

				<tr>
					<td>3</td>
					<td>Nguyễn Văn Đương</td>
					<td>duongnv@rabiloo.com</td>
					<td>Thêm Xóa</td>
				</tr>

				<tr>
					<td>4</td>
					<td>Nguyễn Văn Đương</td>
					<td>duongnv@rabiloo.com</td>
					<td>Thêm Xóa</td>
				</tr>
			</tbody>
		</table>
		<a href='<c:url value="/addStudent"/>'>Add Student</a>
	</div>
</body>

</div>



</html>