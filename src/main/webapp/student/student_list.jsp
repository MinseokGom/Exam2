<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="dao.StudentDAO" %>
<%@ page import="bean.Student" %>
<%@ page import="bean.School" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>

<!DOCTYPE html>
<html>
<head>


<%@include file="../header.jsp" %>


<%@include file="../menu.jsp" %>

    <meta charset="UTF-8">
    <title>学生管理画面</title>
</head>
<body>
    <h1>学生管理</h1>
    <%
        StudentDAO studentDAO = new StudentDAO();
        List<Student> students = new ArrayList<>();
        
        try {
            students = studentDAO.getAllStudents();
        } catch (Exception e) {
            out.println("<p>Error: " + e.getMessage() + "</p>");
        }

        if (students.isEmpty()) {
            out.println("<p>No students found.</p>");
        } else {
            out.println("<table border='1'>");
            out.println("<tr>");
            out.println("<th>No</th>");
            out.println("<th>Name</th>");
            out.println("<th>Enrollment Year</th>");
            out.println("<th>Class Number</th>");
            out.println("<th>Is Attend</th>");
            out.println("<th>School Code</th>");
            out.println("<th>School Name</th>");
            out.println("</tr>");

            for (Student student : students) {
                out.println("<tr>");
                out.println("<td>" + student.getNo() + "</td>");
                out.println("<td>" + student.getName() + "</td>");
                out.println("<td>" + student.getEntYear() + "</td>");
                out.println("<td>" + student.getClassNum() + "</td>");
                out.println("<td>" + student.getIsAttend() + "</td>");
                out.println("<td>" + student.getSchool().getCd() + "</td>");
                out.println("<td>" + student.getSchool().getName() + "</td>");
                out.println("</tr>");
            }

            out.println("</table>");
        }
    %>
</body>
</html>
<%@include file="../footer.jsp" %>

