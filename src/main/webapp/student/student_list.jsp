<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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
            <th>1</th>
            <th>2</th>
            <th>3</th>
            <th>4</th>
            <th>5</th>
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
                	<td>${product.name}</td>
                    <td>${ student.getId}</td>
                    <td>${ student.getName}</td>
                    <td>${ student.getAge}</td>
                    <td>${ student.getGrade}</td>
                    <td>${ student.getSchool}</td> 
                </tr>
        <% } %>
    </table>
</body>
</html>
