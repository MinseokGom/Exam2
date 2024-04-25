<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../header.jsp" %>

<h2>成績管理</h2>

<!-- 検索フォーム -->
<form action="SearchGrade.jsp" method="get">
    <h3>成績検索</h3>
    入学年度:
    <select name="entryYear" required>
        <option value="">選択してください</option>
    </select><br>
    
    クラス:
    <select name="class" required>
        <option value="">選択してください</option>
    </select><br>

    科目:
    <select name="subject" required>
        <option value="">選択してください</option>
    </select><br>

    回数:
    <select name="times" required>
        <option value="">選択してください</option>
    </select><br>

    <button type="submit">検索</button>
</form>

<%@include file="../footer.jsp" %>
