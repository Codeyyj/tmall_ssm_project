<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2020/9/2
  Time: 12:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="../include/admin/adminHeader.jsp"%>
<%@include file="../include/admin/adminNavigator.jsp"%>
<html>
<head>
    <title>用户编辑</title>
</head>
<body>
<div class="panel-body">
    <form method="post" id="editForm" action="admin_user_update"  enctype="multipart/form-data">
        <table class="editTable">
            <tr>+
                <td>用户名</td>
                <td><input  id="name1" name="name" value="${user.name}" type="text" class="form-control"></td>
            </tr>
            <tr>
                <td>用户密码</td>
                <td><input  id="name2" name="password" value="${user.password}" type="text" class="form-control"></td>

            </tr>
            <tr class="submitTR">
                <td colspan="2" align="center">
                    <input type="hidden" name="id" value="${user.id}">
                    <button type="submit" class="btn btn-success" >提 交</button>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
