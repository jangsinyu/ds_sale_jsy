<%--
  Created by IntelliJ IDEA.
  User: JangSinyu
  Date: 2018/11/13
  Time: 9:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>支付</title>
    <link rel="stylesheet" type="text/css" href="css/checkedstand.css"/>
    <script src="/js/jquery-1.11.3.min.js"></script>
    <script>
        function paySuccess() {
            $("#tjSkuForm").submit()
        }
    </script>
</head>
<body>
<div class="warp">
    <div class="money">${sum}</div>
    <input type="text" class="password" placeholder="请输入京东支付密码"/>
    <div class="pay">
        <a href="javascript:paySuccess()">
            <img src="images/pay.gif"/>
        </a>
    </div>
    <form id="tjSkuForm" action="paySuccess.do" method="post">
        <c:forEach items="${carList}" var="car" varStatus="i">
            <input type="text" name="carList[${i.index}].skuId" value="${car.skuId}">
            <input type="text" name="carList[${i.index}].tjshl" value="${car.tjshl}">
        </c:forEach>
        <input>
    </form>
</div>
</body>
</html>
