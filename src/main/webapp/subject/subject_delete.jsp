<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<%@include file="../header.jsp" %>
<div style="display: flex;">
    <div style="flex: 1;">
        <%@include file="../menu.jsp" %>
    </div>
    <div style="flex: 2;">

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>成績一覧</title>
</head>
<body>
    <h1>科目情報削除</h1>
  		${subject.name }を削除しても良いですか<br>
	
	<button type="submit" id="submit" style="background-color: #00c9e8; color: white;">削除</button><br>
	
	
	<button type="button" onclick="history.back()">戻る</button>
	 


</body>

		</html>
	</div>
</div>

<%@include file="../footer.jsp" %>


 
