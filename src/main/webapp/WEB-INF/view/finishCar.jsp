<%--
  Created by IntelliJ IDEA.
  User: JangSinyu
  Date: 2018/11/7
  Time: 23:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="css/css.css"/>
    <link rel="stylesheet" type="text/css" href="css/finishCart.css"/>
    <link rel="shortcut icon" type="image/icon" href="images/jd.ico">
    <script>
        function toItemPage(){
            var skuId = ${skuId}
            var spuId = ${spuId}
            location.href="toItemPage.do?skuId="+skuId+"&spuId="+spuId;
        }
    </script>
</head>
<body>

    <jsp:include page="search.jsp"></jsp:include>
    <div class="cartPro">
        <span class="dec">该商品已加入购物车</span>
        <div class="lec">
            <a href="###"><img src="images/lec1.png"/></a>
        </div>
        <span class="lec_name">
            ${skuName}
        </span>
        <span class="lec_des">
            ${tjshul}
        </span>
        <div class="shop_des">
            <a href="javascript:toItemPage()"><img src="images/shop_des.png"/></a>
        </div>
        <div class="shop_cart">
            <a href="toShoppingCarPage.do"><img src="images/shop_cart.png"/></a>
        </div>
    </div>



</body>
</html>
