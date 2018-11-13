<%--
  Created by IntelliJ IDEA.
  User: JangSinyu
  Date: 2018/11/13
  Time: 9:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title></title>
    <link rel="stylesheet" type="text/css" href="css/checkedstand.css"/>
</head>
<body>
<div class="warp">
    <div class="money">${sum}</div>
    <input type="text" class="password" placeholder="请输入京东支付密码"/>
    <div class="pay">
        <img src="images/pay.gif"/>
    </div>
</div>
</body>
</html>
