<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: JangSinyu
  Date: 2018/11/9
  Time: 13:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="/js/jquery-1.11.3.min.js"></script>
    <script>
        function toCheckOrderPage(hjSum) {
            if(hjSum == 0){
                alert("请选择商品");
            } else {
                location.href="toCheckOrderPage.do";
            }
        }
    </script>
</head>
<body>
<div class="Cbox">
    <table class="table table-striped table-bordered table-hover">
        <thead>
        <tr>
            <th>
                <input type="checkbox" name="">
            </th>
            <th>商品图片</th>
            <th>商品名称</th>
            <th>商品属性</th>
            <th>商品价格</th>
            <th>商品数量</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${carList}" var="car">
            <tr>
                <td><input type="checkbox" name="" value="${car.skuId}" onclick="changeState(this.checked,this.value)" ${car.shfxz == 1?"checked":""}></td>
                <td><img src="images/icon_2.jpg" alt=""></td>
                <td>${car.skuMch}</td>
                <td>
                    颜色：<span style='color:#ccc'>白色</span><br>
                    尺码：<span style='color:#ccc'>L</span>
                </td>
                <td>${car.skuJg}</td>
                <td><input type="text" name="min" value="${car.tjshl}" style="width:50px;text-align:center"></td>
                <td>删除</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<div class="Cprice">
    <div class="price">${hjSum}</div>
    <a href="javascript:toCheckOrderPage(${hjSum})">
        <div class="jiesuan">结算</div>
    </a>
</div>
</body>
</html>