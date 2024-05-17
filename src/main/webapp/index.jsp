<%@page contentType="text/html; charset=UTF-8"%>
<%@include file="../header.jsp"%>


<div style="display: flex;">
	<div style="flex: 1;">
	<%@include file="menu.jsp"%>
	</div>
	<div style="flex: 2;">
		<div>
			<h2>Topページ</h2>
			
			<p>学生とコースの管理をするシステムです。</p>
		
			
            <a href="../test/test_regist.jsp">成績登録</a><br>
          	<a href="../test/test_list.jsp">成績参照</a><br>
            <a href="../subject/subject_list.jsp">科目管理</a><br>
		</div>
	</div>
</div>
<%@include file="../footer.jsp"%>