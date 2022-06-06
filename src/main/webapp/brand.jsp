<%@ page import="com.itheima.pojo.Brand" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: 李轩
  Date: 2022/5/30
  Time: 22:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>

<h1>${user.username},欢迎你！！！</h1>
<input type="button" value="新增" id="add"><br>
<hr>
<table border="1" cellspacing="0" width="800">
    <tr>
        <th>序号</th>
        <th>品牌名称</th>
        <th>企业名称</th>
        <th>排序</th>
        <th>品牌介绍</th>
        <th>状态</th>
        <th>操作</th>

    </tr>

    <c:forEach items="${brands}" var="brand">
        <tr align="center">
            <td>${brand.id}
            </td>
            <td>${brand.brandName}
            </td>
            <td>${brand.companyName}
            </td>
            <td>${brand.ordered}
            </td>
            <td>${brand.description}
            </td>

            <td>
                <c:if test="${brand.status==1}">
                    启用
                </c:if>
                <c:if test="${brand.status==0}">
                    禁用
                </c:if>
            </td>
            <td><a href="/brand_demo/selectByIdServlet?id=${brand.id}">修改</a> <a href="/brand_demo/deleteServlet?id=${brand.id}">删除</a></td>
        </tr>
    </c:forEach>

</table>
</body>
<script>
    document.getElementById("add").onclick=function () {
        location.href="addBrand.jsp";
    }
</script>

</html>
