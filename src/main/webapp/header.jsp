<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>学生管理システム</title>
<style>
  body, html {
    margin: 0;
    padding: 0;
    height: 100%;
  }
  .header {
    background-color: rgb(128, 128, 128);
    color: #fff;
    padding: 20px;
    text-align: center;
  }
  .title {
    font-size: 24px;
    padding: 20px;
    text-align: center;
  }
</style>
</head>
<body>
<%-- ログイン後のユーザ名とログアウトリンクを表示 --%>
<header class="header">
  <h1>得点管理システム</h1>
      ${teacher.name}様
</header>
</body>
</html>
