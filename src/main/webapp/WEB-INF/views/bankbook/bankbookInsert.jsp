<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert page</title>
	<c:import url="../temp/boot_head.jsp"></c:import>
</head>
<body>
	<c:import url="../temp/boot_nav.jsp"></c:import>
	<h1>Bankbook Insert Page 입니다.</h1>
	
	<form action="./bankbookInsert" method="POST" class="col-md-8 mx-auto my-0">
		<div class="container-fluid">
				<table class="table table-dark table-striped" style="text-align:center">
					<tr>
						<td>상품이름</td><td><input type="text" name="bookName"></td>
					</tr>
					<tr>
						<td>이자율</td><td><input type="text" name="bookRate"></td>
					</tr>
					<tr>
						<td>현황</td>
						<td>
							<input type="radio" name="bookSale" value="1" checked>YES
							<input type="radio" name="bookSale" value="0">NO
						</td>
					</tr>
					<tr>
						<td colspan="2"><input type="submit" value="제출하기"></td>
					</tr>
				</table>
		</div>
	</form>
	
</body>
</html>