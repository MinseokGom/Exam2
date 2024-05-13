<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../header.jsp" %>

<div style="display: flex;">
    <div style="flex: 1;">
        <%@include file="../menu.jsp" %>
    </div>
    <div style="flex: 5;">

        <h2>成績一覧（科目）</h2>

        <!-- 検索フォーム -->
        <form action="SearchGrade.jsp" method="get" style="display: flex; align-items: center;">
            <h3 style="margin-right: 10px;">科目情報</h3>
            <div style="display: flex; flex-wrap: wrap;">
                <div style="margin-right: 10px;">
                    入学年度:
                    <select name="entryYear" required>
                        <option value="">選択してください</option>
                    </select>
                </div>
                <div style="margin-right: 10px;">
                    クラス:
                    <select name="class" required>
                        <option value="">選択してください</option>
                    </select>
                </div>
                <div style="margin-right: 10px;">
                    科目:
                    <select name="subject" required>
                        <option value="">選択してください</option>
                    </select>
                </div>
                <button type="submit" style="margin-left: 10px;">検索</button>
            </div>
        </form>

        <!-- 学生番号から検索フォーム -->
        <form action="SearchGrade.jsp" method="get" style="display: flex; align-items: center; margin-top: 10px;">
            <h3 style="margin-right: 10px;">学生情報</h3>
            <div style="margin-right: 10px;">
                学生番号:
                <input type="text" name="studentID" required>
            </div>
            <button type="submit">検索</button>
        </form>

    </div>
</div>

<%@include file="../footer.jsp" %>
