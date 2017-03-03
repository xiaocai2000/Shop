<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="/public/head.jspf" %>
</head>
<body>
<a href="send_main_aindex.action">测试到后台</a>
<a href="send_main_left.action">测试到左侧页面</a>

<a href="${pageContext.request.contextPath}/category_update.action?category.id=2&category.type=gaga&category.hot=false">访问update</a>
<a href="category_save.action?id=1&type=lle&hot=true">测试ModelDriven</a>
<a href="category_query.action">查询所有类别</a>

<br/>
<c:forEach items="${requestScope.categoryList}" var="category">
	${category.id} | ${category.type} | ${category.hot} | request
	<br/>
</c:forEach>
<c:forEach items="${sessionScope.categoryList}" var="category">
	${category.id} | ${category.type} | ${category.hot} | session
	<br/>
</c:forEach>
<c:forEach items="${applicationScope.categoryList}" var="category">
	${category.id} | ${category.type} | ${category.hot} | application
	<br/>
</c:forEach>

</body>
</html>