<%--
  Created by IntelliJ IDEA.
  User: JangSinyu
  Date: 2018/11/8
  Time: 1:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <script>
        function toItemPage(skuId,shpId) {
            location.href="toItemPage.do?skuId="+skuId+"&spuId="+shpId;
        }
    </script>
</head>
<body>

    <c:forEach items="${carList}" var="car">
        <div class="one">
            <img src="images/lec1.png"/>
                <span class="one_name" onclick="toItemPage(${car.skuId}, ${car.shpId})">
                    ${car.skuMch}
                </span>
            <span class="one_prece">
                <b>￥${car.skuJg}*${car.tjshl}</b><br />
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;删除
            </span>
        </div>
    </c:forEach>

    <div class="gobottom">
        共<span>${countSum}</span>件商品&nbsp;&nbsp;&nbsp;&nbsp;
        共计￥<span>${hj}</span>
        <button class="goprice">去购物车</button>
    </div>

</body>
</html>
