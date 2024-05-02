
<%@page contentType="text/html; charset=UTF-8"%>
<%@include file="../header.jsp" %>
<div style="display: flex;">
    <div style="flex: 1;">
        <%@include file="../menu.jsp" %>
    </div>
    <div style="flex: 2;">
        <form action="LoginExecute.action">
            <p>ログイン名<input type="text" name="id" required></p>
            <p>パスワード<input type="password" name="password" required></p>
            <input type="checkbox" name="check_d_ps"><label for="check_d_ps">パスワードを表示</label>
            <p><input type="submit" value="ログイン"></p>
        </form>
    </div>
</div>
<%@include file="../footer.jsp" %>
