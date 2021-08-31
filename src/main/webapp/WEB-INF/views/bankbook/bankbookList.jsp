<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<title>Insert title here</title>
	<c:import url="../temp/boot_head.jsp"></c:import>
</head>
<body>
	<c:import url="../temp/boot_nav.jsp"></c:import>
	<h1>List</h1>
	<div class="container-fluid">
		<div class="col-md-8 mx-auto my-0">
			<table class="table table-striped">
				<thead>
					<tr>
						<th>번호</th><th>이름</th><th>이자율</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${list}" var="dto">
						<tr>
							<td>${dto.bookNumber}</td>
							<td>${dto.bookName}</td>
							<td>${dto.bookRate}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>