<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="../include/admin/adminHeader.jsp"%>
<%@include file="../include/admin/adminNavigator.jsp"%>

<script>
    $(function() {

        $("#addForm").submit(function() {
            if (checkEmpty("name", "属性名称"))
                return true;
            return false;
        });
    });
</script>

<title>属性管理</title>

<div class="workingArea">

    <ol class="breadcrumb">
        <li><a href="listCategory_list">所有分类</a></li>
        <li class="active">属性管理</li>
    </ol>

    <div class="listDataTableDiv">
        <table class="table table-striped table-bordered table-hover  table-condensed">
            <thead>
            <tr class="success">
                <th>属性名称</th>
                <th>属性值</th>

            </tr>
            </thead>
            <tbody>
<%--            遍历property目录下的propertyvalue--%>
            <c:forEach items="${propertyValueList}" var="p">

                <tr>
                    <td>${p.propertyName}</td>
                    <td><input type="text" value="${p.value}"></td>
                </tr>
                <tr>

                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>



</div>

<%@include file="../include/admin/adminFooter.jsp"%>