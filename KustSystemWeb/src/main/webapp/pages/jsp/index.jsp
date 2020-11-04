<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>login</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->
</head>
<body style="background: #f0cc68">
<center>
    <font face = "幼圆" size = "10" color = "#000">欢迎使用后台管理系统</font><hr>
    <div>
        <img alt="" width = "600" height = "400" src="${pageContext.request.contextPath}/img/tianmao.jpg">
    </div>
    <table width = "200" border ="1" bordercolor = "#00F">
        <tr>
            <td><button style="width:400px;height:50px" type="button" class="bt"
                       onclick="location.href='${pageContext.request.contextPath}/pages/jsp/login.jsp'">登录</button></td>
        </tr>
        <tr>
            <td><button style="width:400px;height:50px" type="button" class="bt"
                        onclick="location.href='${pageContext.request.contextPath}/pages/jsp/register.jsp'">注册</button></td>
        </tr>
    </table>
</center>
</body>
</html>
