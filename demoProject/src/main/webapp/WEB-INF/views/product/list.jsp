<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:if test="${requestScope.status !=null}">

<h5>Last Action Taken:${requestScope.status}</h5>
</c:if>
<table style="background-color: cyan; margin: auto;" border="1">
<caption>Product List</caption>
<tr>
<th>Name</th>
<th>Price</th>
<th>Exp</th>
<th>Product_delete</th>
</tr>
<c:forEach var="p" items="${requestScope.product_list}">
<tr>
<td>${p.name}</td>
<td>${p.price}</td>
<td>${p.expDate}</td>

<td><a href="<spring:url value='/product/delete?prodId=${p.id}'/>">Delete product</a></td>
</tr>
</c:forEach>
</table>
</body>
</html>