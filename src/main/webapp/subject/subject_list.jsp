<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.List"%>
<%@ include file="../header.jsp"%>

<div style="display: flex;">

	<div style="flex: 1;">
		<%@ include file="../menu.jsp"%>
	</div>
	<div style="flex: 2;">
		<!DOCTYPE html>
		<html>
<head>
<meta charset="UTF-8">
<title>得点管理システム</title>
<style>
/* Add your custom CSS styles here */
/* For example, adjust font size, colors, layout, etc. */
</style>
</head>
<body>

	<h1>科目管理</h1>
	<thead>
		<tr>
			<th>科目番号</th>
			<th>科目名</th>
		</tr>
	</thead>

	<c:forEach var="subject" items="${subject}">
		<tr>
			<td>${subject.school_cd}</td>
			<td>${subject.cd}</td>
			<td>${subject.name}</td>
		</tr>
	</c:forEach>

</body>

		</html>

	</div>
</div>
<%@ include file="../footer.jsp"%>


