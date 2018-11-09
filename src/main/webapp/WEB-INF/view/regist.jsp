<%--
  Created by IntelliJ IDEA.
  User: JangSinyu
  Date: 2018/11/5
  Time: 16:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>个人注册</title>
    <link rel="shortcut icon" type="image/icon" href="/images/jd.ico">
    <link rel="stylesheet" href="/css/sign.css"/>
    <script type="text/javascript" src="/js/jquery-1.11.3.min.js"></script>
    <script type="text/javascript" src="/js/script.js"></script>
</head>
<body>
    <!--头部-->
    <div class="header">
        <a class="logo" href="/toMainPage.do"></a>
        <div class="desc">欢迎注册</div>
    </div>
    <form id="registForm" action="/saveUser.do" method="post" >
        <!--版心-->
        <div class="container">
            <!--京东注册模块-->
            <div class="register">
                <!--用户名-->
                <div class="register-box">
                    <!--表单项-->
                    <div class="box default">
                        <label for="userName">用&nbsp;户&nbsp;名</label>
                        <input type="text" id="userName" name="yhMch" placeholder="您的账户名和登录名"/>
                        <i></i>
                    </div>
                    <!--提示信息-->
                    <div class="tip">
                        <i></i>
                        <span id="userNameTip"></span>
                    </div>
                </div>
                <!--设置密码-->
                <div class="register-box">
                    <!--表单项-->
                    <div class="box default">
                        <label for="pwd">设 置 密 码</label>
                        <input type="password" id="pwd" name="yhMm" placeholder="建议至少两种字符组合"/>
                        <i></i>
                    </div>
                    <!--提示信息-->
                    <div class="tip">
                        <i></i>
                        <span id="pwdTip"></span>
                    </div>
                </div>
                <!--确认密码-->
                <div class="register-box">
                    <!--表单项-->
                    <div class="box default">
                        <label for="pwd2">确 认 密 码</label>
                        <input type="password" id="pwd2" placeholder="请再次输入密码"/>
                        <i></i>
                    </div>
                    <!--提示信息-->
                    <div class="tip">
                        <i></i>
                        <span id="pwd2Tip"></span>
                    </div>
                </div>
                <!--设置邮箱-->
                <div class="register-box">
                    <!--表单项-->
                    <div class="box default">
                        <label for="email">邮 箱 验 证</label>
                        <input type="text" id="email" name="yhYx" placeholder="请输入邮箱"/>
                        <i></i>
                    </div>
                    <!--提示信息-->
                    <div class="tip">
                        <i></i>
                        <span id="emailTip"></span>
                    </div>
                </div>
                <!--手机验证-->
                <div class="register-box">
                    <!--表单项-->
                    <div class="box default">
                        <label for="mobile">手 机 验 证</label>
                        <input type="text" id="mobile" name="yhShjh" placeholder="请输入手机号"/>
                        <i></i>
                    </div>
                    <!--提示信息-->
                    <div class="tip">
                        <i></i>
                        <span id="mobileTip"></span>
                    </div>
                </div>
                <!--注册协议-->
                <div class="register-box xieyi">
                    <!--表单项-->
                    <div class="box default">
                        <input type="checkbox" id="ck"/>
                        <span>我已阅读并同意<a href="##">《京东用户注册协议》</a></span>
                    </div>
                    <!--提示信息-->
                    <div class="tip">
                        <i></i>
                        <span id="checkTip"></span>
                    </div>
                </div>
                <!--注册-->
                <button id="subButton">注册</button>
            </div>
        </div>
    </form>
</body>
</html>
