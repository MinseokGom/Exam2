<%@page contentType="text/html; charset=UTF-8"%>
<%@include file="../header.jsp" %>
<div style="display: flex;">
   <div style="flex: 1;">
   </div>
   <div style="flex: 2;">
       <form action="LoginExecute.action">
           <p>ログイン名<input type="text" name="id" required></p>
           <p>パスワード<input type="password" id="password" name="password" required></p>
           <input type="checkbox" id="showPassword" onclick="togglePasswordVisibility()"><label for="showPassword">パスワードを表示</label>
           <p><input type="submit" value="ログイン"></p>
       </form>
   </div>
</div>
<script>
function togglePasswordVisibility() {
    var passwordField = document.getElementById("password");
    if (passwordField.type === "password") {
        passwordField.type = "text"; // パスワードフィールドのタイプをテキストに変更することで、伏字を解除します
    } else {
        passwordField.type = "password"; // パスワードフィールドのタイプを再びパスワードに変更して、伏字を復活させます
    }
}
</script>
<%@include file="../footer.jsp" %>
