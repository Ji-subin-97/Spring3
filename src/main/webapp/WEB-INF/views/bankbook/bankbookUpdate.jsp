<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<c:import url="../temp/boot_head.jsp"></c:import>
</head>
<body>
	<c:import url="../temp/boot_nav.jsp"></c:import>
	<h1>Update Package</h1>
	
	<form action="./bankbookUpdate" method="POST" class="col-md-8 mx-auto my-0">
		<input type="hidden" name="bookNumber" value="${dtov.bookNumber}">
		<div class="container-fluid">
				<table class="table table-dark table-striped" style="text-align:center">
					<tr>
						<td>상품이름</td><td><input type="text" name="bookName" value="${dtov.bookName}"></td>
					</tr>
					<tr>
						<td>이자율</td><td><input type="text" name="bookRate" value="${dtov.bookRate}"></td>
					</tr>
					<c:choose>
						<c:when test="${dtov.bookSale eq 1}">
							<tr>
								<td>현황</td>
								<td>
									<input type="radio" name="bookSale" value="1" checked>YES
									<input type="radio" name="bookSale" value="0">NO
								</td>
							</tr>
						</c:when>
						<c:otherwise>
							<tr>
								<td>현황</td>
								<td>
									<input type="radio" name="bookSale" value="1">YES
									<input type="radio" name="bookSale" value="0" checked>NO
								</td>
							</tr>
						</c:otherwise>
					</c:choose>
					<tr>
						<td colspan="2"><input type="submit" value="업데이트"></td>
					</tr>
				</table>
		</div>
	</form>
	
</body>
</html>