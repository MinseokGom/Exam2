<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<%@ page import="dao.StudentDAO" %>
<%@ page import="bean.Student" %>
<%@ page import="bean.School" %>
<%@ include file="../header.jsp" %>
<%@ include file="../menu.jsp" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>学生管理システム</title>
    <style>
        table {
            width: 100%;
            border-collapse: collapse;
        }
        th, td {
            padding: 10px;
            border: 1px solid black;
            text-align: left;
        }
    </style>
</head>
<body>
    <h1>学生管理</h1>
<a href="">学生追加</a>
<br>
<p>フィルター</p>
    <form method="get" action="student_list.jsp">
        <label for="schoolCd">学校コード:</label>
        <select id="schoolCd" name="schoolCd">
            <option value="">すべて</option>
            <option value="omm">大宮校</option>
            <option value="tky">東京校</option>
            <!-- 他の学校コードを追加 -->
        </select>
        <br>
        <label for="entYear">入学年:</label>
        <select id="entYear" name="entYear">
            <option value="">すべて</option>
            <option value="2020">2020</option>
            <option value="2021">2021</option>
            <!-- 他の入学年を追加 -->
        </select>
        <br>
        <label for="classNum">クラス番号:</label>
        <select id="classNum" name="classNum">
            <option value="">すべて</option>
            <option value="1A">1A</option>
            <option value="1B">1B</option>
            <!-- 他のクラス番号を追加 -->
        </select>
        <br>
        <label for="isAttend">出席状況:</label>
        <select id="isAttend" name="isAttend">
            <option value="">すべて</option>
            <option value="true">出席</option>
            <option value="false">欠席</option>
        </select>
        <br>
        <button type="submit">検索</button>
    </form>

    <table>
        <thead>
            <tr>
                <th>学校コード</th>
                <th>学生番号</th>
                <th>名前</th>
                <th>入学年</th>
                <th>クラス番号</th>
                <th>出席状況</th>
            </tr>
        </thead>
        <tbody>
            <%
                StudentDAO studentDAO = new StudentDAO();
                List<Student> students = null;

                try {
                    String schoolCd = request.getParameter("schoolCd");
                    String entYearStr = request.getParameter("entYear");
                    String classNum = request.getParameter("classNum");
                    String isAttendStr = request.getParameter("isAttend");

                    School school = new School();
                    boolean isFilter = false;

                    if (schoolCd != null && !schoolCd.isEmpty()) {
                        school.setCd(schoolCd);
                        isFilter = true;
                    }

                    if (isFilter) {
                        if (entYearStr != null && !entYearStr.isEmpty() && classNum != null && !classNum.isEmpty() && isAttendStr != null && !isAttendStr.isEmpty()) {
                            int entYear = Integer.parseInt(entYearStr);
                            boolean isAttend = Boolean.parseBoolean(isAttendStr);
                            students = studentDAO.filter(school, entYear, classNum, isAttend);
                        } else if (entYearStr != null && !entYearStr.isEmpty() && isAttendStr != null && !isAttendStr.isEmpty()) {
                            int entYear = Integer.parseInt(entYearStr);
                            boolean isAttend = Boolean.parseBoolean(isAttendStr);
                            students = studentDAO.filter(school, entYear, isAttend);
                        } else if (isAttendStr != null && !isAttendStr.isEmpty()) {
                            boolean isAttend = Boolean.parseBoolean(isAttendStr);
                            students = studentDAO.filter(school, isAttend);
                        } else {
                            students = studentDAO.getAllStudents();
                        }
                    } else {
                        students = studentDAO.getAllStudents();
                    }

                    for (Student student : students) {
                        %>
                        <tr>
                            <td><%= student.getSchool().getCd() %></td>
                            <td><%= student.getNo() %></td>
                            <td><%= student.getName() %></td>
                            <td><%= student.getEntYear() %></td>
                            <td><%= student.getClassNum() %></td>
                            <td><%= student.getIsAttend() ? "出席" : "欠席" %></td>
                            <td><a href="">変更</a></td>
                 
                        </tr>
                        <%
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    out.println("<tr><td colspan='6'>データの取得に失敗しました。</td></tr>");
                }
            %>
        </tbody>
    </table>
</body>
</html>
<%@ include file="../footer.jsp" %>
