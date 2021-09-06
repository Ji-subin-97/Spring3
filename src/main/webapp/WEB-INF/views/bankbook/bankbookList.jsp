<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<title>Insert title here</title>
	<c:import url="../temp/boot_head.jsp"></c:import>
</head>
<style>
	.block:first-child{
		display: inline-block;
		width: 29.5%;
	}
	.block:nth-child(2){
		display: inline-block;
		width: 69.5%;
	}
</style>
<body>
	<c:import url="../temp/boot_nav.jsp"></c:import>
	<h1>List</h1>
	<div class="container-fluid">
		<div class="col-md-8 mx-auto my-0">
			
			<!-- 검색 -->
			
			<div class="row">
				<form action="./bankbookList" method="get">
					<div class="block">
						<select class="form-select input-group mb-3" name="kind" aria-label="Default select example">
						  <option selected>==선택==</option>
						  <option value="num">BookNum</option>
						  <option value="name">BookName</option>
						  <option value="rate">BookRate</option>
						</select>
					</div>
					
					<div class="block">
						<div class="input-group mb-3">
						  <input type="text" name="search" class="form-control" placeholder="Recipient's username" aria-label="Recipient's username" aria-describedby="button-addon2">
						  <button class="btn btn-outline-secondary" type="submit" id="button-addon2">Search</button>
						</div>
					</div>
				</form>
			</div>
			
			<!-- 검색 끝 -->
		
		
			<table class="table table-dark table-striped">
				<thead>
					<tr>
						<th>번호</th><th>이름</th><th>이자율</th><th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${list}" var="list">
						<tr>
							<td>${list.bookNumber}</td>
							<td><a href="${pageContext.request.contextPath}/bankbook/bankbookSelect?bookNumber=${list.bookNumber}">${list.bookName}</a></td>
							<td>${list.bookRate}</td>
							<td><a href="${pageContext.request.contextPath}/bankbook/bankbookUpdate?bookNumber=${list.bookNumber}">업데이트</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			
			<!-- Paging -->
			<nav aria-label="Page navigation example">
			  <ul class="pagination">
			    <li class="page-item">
			      <a class="page-link" href="./bankbookList?kind=${pager.kind}&search=${pager.search}" aria-label="Previous">
			        <span aria-hidden="true">&laquo;</span>
			      </a>
			    </li>
			    
			    <li class="page-item">
			      <a class="page-link" href="./bankbookList?pn=${pager.startNum - 1}&kind=${pager.kind}&search=${pager.search}" aria-label="Previous">
			        <span aria-hidden="true">&lt;</span>
			      </a>
			    </li>
			    
			    <c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="n">
			    	<li class="page-item"><a class="page-link" href="./bankbookList?pn=${n}&kind=${pager.kind}&search=${pager.search}">${n}</a></li>
			    </c:forEach>
			    
			   	<li class="page-item">
			      <a class="page-link" href="./bankbookList?pn=${pager.lastNum + 1}&kind=${pager.kind}&search=${pager.search}" aria-label="Next">
			        <span aria-hidden="true">&gt;</span>
			      </a>
			    </li>
			    
			    <li class="page-item">
			      <a class="page-link" href="./bankbookList?pn=${pager.totalPage}&kind=${pager.kind}&search=${pager.search}" aria-label="Next">
			        <span aria-hidden="true">&raquo;</span>
			      </a>
			    </li>
			  </ul>
			</nav>
			
			<a href="./bankbookInsert" class="btn btn-outline-primary">BankBook Insert</a>
		</div>
	</div>
</body>
</html>