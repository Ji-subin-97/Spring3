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
			<table class="table table-dark table-striped">
				<thead>
					<tr>
						<th>번호</th><th>이름</th><th>이자율</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${list}" var="list">
						<tr>
							<td>${list.bookNumber}</td>
							<td><a href="${pageContext.request.contextPath}/bankbook/bankbookSelect?bookNumber=${list.bookNumber}">${list.bookName}</a></td>
							<td>${list.bookRate}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>