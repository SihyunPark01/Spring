<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>list</title>
</head>
<body>
	<h3>고객목록</h3>
	<a href="/ch07/cumtomer/register.do"> 고객등록 </a>
	<table border="1">
		<tr>
			<th>아이디</th>
			<th>이름</th>
			<th>주소</th>
			<th>휴대폰</th>
			<th>기타</th>
		</tr>
		
		<c:forEach var="customer" items="${customers}">
		<tr>
			<td>${customer.custid}</td>
			<td>${customer.name}</td>
			<td>${customer.address}</td>
			<td>${customer.phone}</td>
			<td>
				<a href="/ch07/customer/modify.do?uid=${customer.uid}">수정</a>
				<a href="/ch07/customer/delete.do?uid=${customer.uid}">삭제</a>
			</td>
		</tr>
		</c:forEach>
	</table>

</body>
</html>