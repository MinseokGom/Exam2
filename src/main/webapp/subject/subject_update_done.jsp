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
    <h1>科目管理</h1>
    <form action="/SubjectListAction.java" method="get">
    	<label for="ent_year">入学年度</label>
        <select id="ent_year" name="ent_year">
            <option value="国語">2015</option>
            <option value="数学">2016</option>
            <!-- Add more subject options here -->
        </select>
        <label for="class">クラス</label>
        <select id="class" name="class">
            <option value="国語">1組</option>
            <option value="数学">2組</option>
            <!-- Add more subject options here -->
        </select>
        <label for="subject">科目</label>
        <select id="subject" name="subject">
            <option value="国語">国語</option>
            <option value="数学">数学</option>
            <!-- Add more subject options here -->
        </select>
        <input type="submit" value="検索">
    </form>
  
</body>
</html>
	</div>
</div>

<%@include file="../footer.jsp" %>


 
