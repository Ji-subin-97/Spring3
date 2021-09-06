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
			      <a class="page-link" href="./bankbookList" aria-label="Previous">
			        <span aria-hidden="true">&laquo;</span>
			      </a>
			    </li>
			    
			    <li class="page-item">
			      <a class="page-link" href="./bankbookList?pn=${pager.startNum - 1}" aria-label="Previous">
			        <span aria-hidden="true">&lt;</span>
			      </a>
			    </li>
			    
			    <c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="n">
			    	<li class="page-item"><a class="page-link" href="./bankbookList?pn=${n}">${n}</a></li>
			    </c:forEach>
			    
			   	<li class="page-item">
			      <a class="page-link" href="./bankbookList?pn=${pager.lastNum + 1}" aria-label="Next">
			        <span aria-hidden="true">&gt;</span>
			      </a>
			    </li>
			    
			    <li class="page-item">
			      <a class="page-link" href="./bankbookList?pn=${pager.totalPage}" aria-label="Next">
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