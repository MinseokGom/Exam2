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
    <h1>科目情報変更</h1>
  
	<thead>
		<tr>
			<th>科目コード</th><br>
			<br>
			<th>科目名</th><br>
			<input type="registration" id="registration_code" style="width: 500px; height: 1em;" placeholder="科目名を入力してください" name="registration_code" required><br>
			
		</tr>
	</thead>
	

	
	<button type="submit" id="submit" style="background-color: #00c9e8; color: white;">変更</button><br>
	
	
	<button type="button" onclick="history.back()">戻る</button>
	 


</body>

		</html>
	</div>
</div>

<%@include file="../footer.jsp" %>


 
