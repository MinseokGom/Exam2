<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.List"%>
<%@ page import="dao.SubjectDAO"%>
<%@ page import="bean.Subject"%>
<%@ page import="bean.School"%>
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
              .right {
   				 text-align: right;
						}
            </style>
        </head>
        <body>

            <h1>科目管理</h1>
            <div class="right">
            <a href="subject_create.jsp">新規登録</a>
            </div>
            <table border="1">
                <thead>
                    <tr>
                        <th>科目コード</th>
                        <th>科目名</th>
                    </tr>
                </thead>
                <tbody>
                
                ${subject }
                    
<!--
	<h1>科目管理</h1>
	
	<div style="margin: 0 0 0 auto; width: 30%;">
    <div style="margin-left: auto;"><a href="subject_create.jsp">新規登録</a>
    </div>
	</div>
	<thead>
		<tr>
			<th>科目番号</th>
			<div style="width: 100px;"><th>科目名</th></div>
		</tr>
	</thead>
 -->

                    <c:forEach var="subject" items="${subject}">
                        <tr>
                            <td>${subject.school_cd}</td>
                            <td>${subject.cd}</td>
                            <td>${subject.name}</td>
                        </tr>
                    </c:forEach>
                </tbody>
                
            </table>
				<a href="subject_update.jsp">変更</a><br>
				 <a href="subject_delete.jsp">削除</a>
        </body>
        </html>
    </div>
</div>
<%@ include file="../footer.jsp"%>
