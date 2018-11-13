<%--
  Created by IntelliJ IDEA.
  User: JangSinyu
  Date: 2018/11/5
  Time: 12:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>京西-欢迎登录</title>
    <meta charset="UTF-8">
    <script type="text/javascript" src='js/jquery-1.11.3.min.js'></script>
    <link rel="shortcut icon" type="image/icon" href="images/jd.ico">
    <link rel="stylesheet" type="text/css" href="css/login.css">
    <script>
        function toMainPage() {
            location.href="/toMainPage.do";
        }
        function toSubmit() {
            $("#login_form").submit();
        }
    </script>
</head>
<body>
    <div class="up">
        <img src="images/logo.jpg" onclick="toMainPage()" height="45px;" class="hy_img"/>
        <div class="hy">
            欢迎登录
        </div>
    </div>
    <div class="middle">
        <div class="login">
            <div class="l1 ">
                <div class="l1_font_01 ">JD会员</div>
                <a class="l1_font_02 " href="/toRegistPage.do">用户注册</a>
            </div>
            <div class="blank_01"></div>
            <div class="ts">
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${err}
            </div>
            <div class="blank_01"></div>
            <form action="/checkUserAndPswd.do" id="login_form" method="post">
                <input type="hidden" name="loginUrl" value="${loginUrl}">
                <div class="input1">
                    <input type="text" class="input1_01" placeholder="请输入用户名" name="userName"/>
                </div>
                <div class="blank_01"></div>
                <div class="blank_01"></div>
                <div class="input2">
                    <input type="text" class="input1_01" placeholder="请输入密码" name="password"/>
                </div>
            </form>
            <div class="blank_01"></div>
            <div class="blank_01"></div>
            <div class="box_01">
                <input type="checkbox" class="box_01_box"/>
                <div class="box_01_both">
                    <div class="box_01_both_1">自动登陆</div>
                    <div class="box_01_both_2">忘记密码？</div>
                </div>
            </div>
            <div class="blank_01"></div>
            <a href="#" class="aline">
                <div class="red_button" onclick="toSubmit()">
                    登&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;录
                </div>
            </a>
            <div class="blank_01"></div>
            <div class="blank_01"></div>
            <div class="box_down">
                <div class="box_down_1">使用合作网站账号登录京东：</div>
                <div class="box_down_1">京东钱包&nbsp;&nbsp;|&nbsp;&nbsp;QQ
                    &nbsp;&nbsp;|&nbsp;&nbsp;微信
                </div>
            </div>
        </div>
    </div>

    <div class="down">
        <br />
        Copyright©2004-2015  xu.jb.com 版权所有
    </div>
</body>
</html>
