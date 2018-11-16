<%--
  Created by IntelliJ IDEA.
  User: JangSinyu
  Date: 2018/11/5
  Time: 11:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="/js/jquery-1.11.3.min.js"></script>
    <script>
        function findMiniCar() {
            $.post("/findMiniCar.do",function (data) {
                $("#MiniCarInner").html(data);
            })
            $("#MiniCarInner").show();
        }
        function outMiniCar() {
            $("#MiniCarInner").hide();
        }
    </script>
</head>
<body>
    <div class="search">
       <div class="logo">
            <a href="/toMainPage.do">
                <img src="./images/logo.jpg" alt="">
            </a>
        </div>
        <div class="search_on">
            <div class="se">
                <form action="getSkuListByKey.do" method="get">
                    <input type="text" id="skuMch" name="skuMch" class="lf">
                    <input type="submit" class="clik" value="搜索">
                </form>
            </div>
            <div class="se">
                <a href="">取暖神奇</a>
                <a href="">1元秒杀</a>
                <a href="">吹风机</a>
                <a href="">玉兰油</a>
            </div>
        </div>
        <div class="card" onmouseover="findMiniCar()" onmouseout="outMiniCar()">
            <a href="toShoppingCarPage.do">购物车<div class="num" id="numDiv">0</div></a>
            <!--购物车商品-->
            <div class="cart_pro">
                <!--    内嵌的mini购物车div   -->
                <div id="MiniCarInner" style="display: none"></div>
            </div>
        </div>
    </div>
</body>
</html>
