<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<c:import url="../temp/boot_head.jsp"></c:import>
</head>
<body>
	<c:import url="../temp/boot_nav.jsp"></c:import>
	<h1>BankbookSelect Page 입니다.</h1>
	<h1>Test : ${test}</h1>
	<h1>BookNumber : ${dtov.bookNumber}</h1>
	<h1>BookName : ${dtov.bookName}</h1>
	<h1>BookRate : ${dtov.bookRate}</h1>
	<h1>BookSale : ${dtov.bookSale}</h1>
	
</body>
</html>