<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>登录</title>
    <link type="text/css" rel="stylesheet"  href="${pageContext.request.contextPath}/css/first.css">
</head>
<body style="background: #f0e2ce">
<header>
    <div class="nav" >
        <p>天猫商城登录界面</p>
    </div>
</header>
<mian>
    <div class="login_style">
        <form action="${pageContext.request.contextPath}/login"  method="post">
            <p>请输入登录和账号</p>
            <div class="fm" >
                <label>账号: <input type="text" name="username"></label><br><br>
                <label>密码: <input type="password" name="password"></label><br><br>
                <button type="submit"  class="bt">登录</button>
<%--                <button type="button" class="bt"--%>
<%--                        onclick="location.href='${pageContext.request.contextPath}/pages/reset.jsp'">找回密码</button>--%>
            </div>
        </form>
    </div>

    <%if ((String)request.getAttribute("user")=="passerror"){%>
    <script>
        alert("密码有误，请核对后再登录！")
    </script>
    <%}%>
    <%if ((String)request.getAttribute("user")=="notexit"){%>
    <script>
        alert("抱歉，此账号不存在，请注册后再登录！")
    </script>
    <%}%>


    <%--    <jsp:forward page="/pages/main.jsp"></jsp:forward>   自动跳转到哪个页面--%>

</mian>



</body>
</html>
