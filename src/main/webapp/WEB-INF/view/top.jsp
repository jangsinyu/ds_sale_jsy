<%--
  Created by IntelliJ IDEA.
  User: JangSinyu
  Date: 2018/11/5
  Time: 11:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <script type="text/javascript" src='js/jquery-1.11.3.min.js'></script>
    <title>Title</title>
    <script>
        $(function () {
            var yhMch = getCookieByKey("yhMch");
            $("#yhMch_span").html(yhMch);
        })
        function getCookieByKey(key) {
            var str = "您好";
            var cookie  = document.cookie;
            var ckArr = cookie.split("; ");
            for (var i = 0; i< ckArr.length; i++){
                var arr = ckArr[i].split("=");
                if(arr[0] == key){
                    str = arr[1];
                }
            }
            return str;
        }
    </script>
</head>
<body>
<div class="top">
    <c:if test="${empty user}">
        <div class="top_text">
            <a href="toRegistPage.do">免费注册</a>
            <a href="/toLoginPage.do"><font color="red"><span id="yhMch_span"></span>，请登录</font></a>
        </div>
    </c:if>
    <c:if test="${!empty user}">
        <div class="top_text">
            <a href="#">我的京西</a>
            <a href="#">京西会员</a>
            <a href="#">我的订单</a>
            <a href="/toLogout.do">注销</a>
            <a><font color="red">${user.yhMch}</font></a>
        </div>
    </c:if>
    <div class="top_img">
        <img src="./images/top_img.jpg">
    </div>
</div>
</body>
</html>
