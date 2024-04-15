<!DOCTYPE html>
<html>

<%@page pageEncoding="UTF-8" %>
   

<head>
<meta charset="UTF-8">
 <style>
            .container {
                display: flex;
                width: 100%;
                
            }
            .sidebar {
                width: 15%;
                height:800px;
                border-right: 2px #000 solid;
                
            }
            .body {
                height:800px;
                text-align: center;
                color: #fff;
                width: 980px;
                margin-left: auto;
                margin-right: auto;
                overflow: hidden;
                
            }
            
</style>      
</head>
  
<body>
    <div class="container">
      <div class="sidebar">
        <h3>メニュー</h3>
        <h2>学生管理</h2>
        <ul>
          <li><a href="../1/test.jsp">学生一覧表示</a></li>
          <li><a href="">学生追加</a><br></li>
          <li><a href="">学生情報変更</a><br></li>
          <li><a href="">学生削除</a><br></li>
        </ul>
      </div>
  </body>
</html>


