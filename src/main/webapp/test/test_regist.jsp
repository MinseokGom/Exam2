<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../header.jsp" %>

<div style="display: flex;">
    <div style="flex: 1;">
        <%@include file="../menu.jsp" %>
    </div>
    <div style="flex: 5;">

        <h2>成績管理</h2>

        <!-- 検索フォーム -->
        <form action="SearchGrade.jsp" method="get" style="display: flex; align-items: center;">
            <h3 style="margin-right: 10px;">成績検索</h3>
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
                <div style="margin-right: 10px;">
                    回数:
                    <select name="times" required>
                        <option value="">選択してください</option>
                    </select>
                </div>
                <button type="submit" style="margin-left: 10px;">検索</button>
            </div>
        </form>

        <table style="border-collapse: separate; border-spacing: 10px;">
            <c:forEach var="product" items="${list}">
                <tr>
                    <td>商品${product.id}</td>
                    <td><img src="image/${product.id}.jpg" height="64"></td>
                    <td>${product.name}</td>
                    <td>${product.price}円</td>
                    <td><a href="CartAdd.action?id=${product.id}">カートに追加</a></td>
                </tr>
            </c:forEach>
        </table>

 <form action="SearchGrade.jsp" method="get" style="display: flex; align-items: center;">
            <h3 style="margin-right: 10px;">成績登録</h3>
            <div style="display: flex; flex-wrap: wrap;">
                <div style="margin-right: 10px;">
            点数：
            <input type="text" name="score" min="0" max="100" required><br>
            </div>
             <input type="button" onclick="location.href='../test/test_update_done.jsp'" value="登録して終了">
      <!--      <button type="submit" href="../test/test_update_done.jsp" style="margin-left: 10px;">登録して終了</button>-->  
            </div>
        </form>

    </div>
</div>

<%@include file="../footer.jsp" %>
