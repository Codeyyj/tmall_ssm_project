<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2020/8/31
  Time: 9:43
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>注册</title>
    <link type="text/css" rel="stylesheet"  href="${pageContext.request.contextPath}/css/first.css">
</head>
<body style="background: #caa8b6">
<header>
    <div class="nav">
        <p>天猫商城注册界面</p>
    </div>
</header>
<mian>
    <div class="login_style">
        <form action="${pageContext.request.contextPath}/register"  method="post">
            <p>请输入注册账号和密码</p>
            <div class="fm">
                <label>账号: <input type="text" name="username"></label><br><br>
                <label>密码: <input type="password" name="password"></label><br><br>
                <button type="submit"  class="bt">提交</button>
                <button type="button" class="bt"
                        onclick="location.href='${pageContext.request.contextPath}/index.jsp'">返回</button>
            </div>
        </form>
    </div>

    <%if ((String)request.getAttribute("user")=="exit"){%>
    <script>
        alert("抱歉，此账号以及存在，不能重复注册！")
    </script>
    <%}%>

    <%--    <jsp:forward page="/pages/main.jsp"></jsp:forward>   自动跳转到哪个页面--%>

</mian>



</body>
</html>
