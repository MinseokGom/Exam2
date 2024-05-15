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
                /* Add your custom CSS styles here */
                /* For example, adjust font size, colors, layout, etc. */
            </style>
        </head>
        <body>

            <h1>科目管理</h1>

<<<<<<< HEAD
            <table border="1">
                <thead>
                    <tr>
                        <th>学校コード</th>
                        <th>科目番号</th>
                        <th>科目名</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        SubjectDAO subjectDAO = new SubjectDAO();
                        List<Subject> subjects = null;
                        try {
                            School school = new School();
                            school.setCd("your_school_code"); // 適切な学校コードを設定してください
                            subjects = subjectDAO.filter(school);
                        } catch (Exception e) {
                            out.println("<tr><td colspan='3'>Error: " + e.getMessage() + "</td></tr>");
                        }
                        if (subjects != null && !subjects.isEmpty()) {
                            request.setAttribute("subjects", subjects);
                        } else {
                            out.println("<tr><td colspan='3'>No subjects found</td></tr>");
                        }
                    %>
=======
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
>>>>>>> branch 'master' of https://github.com/MinseokGom/Exam2.git

                    <c:forEach var="subject" items="${subjects}">
                        <tr>
                            <td>${subject.school.cd}</td>
                            <td>${subject.cd}</td>
                            <td>${subject.name}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>

        </body>
        </html>
    </div>
</div>
<%@ include file="../footer.jsp"%>
