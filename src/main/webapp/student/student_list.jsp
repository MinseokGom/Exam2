<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="../header.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Student List</title>
</head>
<body>
<%@ page import="java.util.ArrayList" %>

    <h1>Student List</h1>
    <table border="1">
        <tr>
            <th>Student ID</th>
            <th>Name</th>

        </tr>
        <%@ page import="java.util.List" %>
        <%@ page import="dao.StudentDAO" %>
        <%@ page import="bean.Student" %>
        <%-- データベースから学生データを取得 --%>
        <% 
            StudentDAO studentDAO = new StudentDAO();
            List<Student> students = new ArrayList<>();
            try {
                students = studentDAO.getAllStudents(); // StudentDAO から全学生データを取得
            } catch (Exception e) {
                out.println("Error occurred while retrieving student data: " + e.getMessage());
            }
            // 取得したデータを表示
            for (Student student : students) {
        %>
                <tr>
                	
<td style="hight: 10px;">${student.getNo()}</td>
<td style="hight: 20px;">${student.getName()}</td>


                </tr>
        <% } %>
    </table>
</body>
</html>
<%@include file="../footer.jsp" %>
