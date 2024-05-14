<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../header.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Student List</title>
</head>
<body>
    <h1>Student List</h1>
    <table border="1">
        <tr>
            <th>Student ID</th>
            <th>Name</th>
            <th>Entrance Year</th>
            <th>Class Number</th>
            <th>Is Attend</th>
        </tr>
        <%@ page import="dao.StudentDAO" %>
        <%@ page import="bean.Student" %>
        <%@ page import="java.util.ArrayList" %> <!-- 追加 -->
        <%@ page import="java.util.List" %> <!-- 追加 -->
        <%@ page import="bean.School" %>
        <%-- 学校情報の準備 --%>
        <% School school = new School(); %>
        <% school.setCd("YOUR_SCHOOL_CODE"); // 学校コードを設定 %>
        <% 
            StudentDAO studentDAO = new StudentDAO();
            List<Student> students = new ArrayList<>();
            try {
                // 学生データの取得
                students = studentDAO.filter(2024, "A", school); // ここで条件を指定して絞り込み
            } catch (Exception e) {
                out.println("Error occurred while filtering students: " + e.getMessage());
            }
            // 学生データの表示
            for (Student student : students) {
        %>
                <tr>
                    <td><c:out value="${student.no}" /></td>
                    <td><c:out value="${student.name}" /></td>
                    <td><c:out value="${student.entYear}" /></td>
                    <td><c:out value="${student.classNum}" /></td>
                    <td><c:out value="${student.isAttend}" /></td>
                </tr>
        <% } %>
    </table>
</body>
</html>
<%@ include file="../footer.jsp" %>
