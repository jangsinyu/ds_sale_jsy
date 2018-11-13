<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: JangSinyu
  Date: 2018/11/12
  Time: 14:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>订单支付</title>
    <link rel="stylesheet" type="text/css" href="css/css.css"/>
    <script src="/js/jquery-1.11.3.min.js"></script>
    <script>
        function chooseAddr(dzMch,shjr,lxfsh,dzhId) {
            var addrStr = "寄送至 ： "+dzMch+"     &nbsp;"+shjr+"（收）  "+lxfsh;
            $(".msg_sub_adds").html(addrStr);
            $("#dzhId").val(dzhId);
            $("#dzMch").val(dzMch);
            $("#shjr").val(shjr);
        }
        function saveOrder() {
            $("#saveOrderForm").submit();
        }
    </script>
</head>
<body>
    <form id="saveOrderForm" action="/saveOrder.do" method="post">
        <input type="hidden" name="id" id="dzhId">
        <input type="hidden" name="dzMch" id="dzMch">
        <input type="hidden" name="shjr" id="shjr">

    </form>
    <jsp:include page="top.jsp"></jsp:include>

    <jsp:include page="search.jsp"></jsp:include>

    <div class="message">
        <div class="msg_title">
            收货人信息
        </div>
        <c:forEach items="${addrList}" var="addr">
            <div class="msg_addr">
                <span class="msg_left">
                    <input type="radio" onclick="chooseAddr('${addr.dzMch}','${addr.shjr}',${addr.lxfsh},${addr.id})">
                    姓名：${addr.shjr}
                </span>
                <span class="msg_right">
                    ${addr.dzMch}
                </span>
            </div>
        </c:forEach>
        <span class="addrs">查看更多地址信息</span>
        <div class="msg_line"></div>

        <div class="msg_title">
            送货清单
        </div>
        <c:forEach items="${carList}" var="car">
            <c:if test="${car.shfxz == 1}">
                <div class="msg_list">
                    <div class="msg_list_left">
                        配送方式
                        <div class="left_title">
                            京东快递
                        </div>
                    </div>
                    <div class="msg_list_right">
                        <div class="msg_img">
                            <img src="images/msgImg.png"/>
                        </div>
                        <div class="msg_name">
                            ${car.skuMch}
                        </div>
                        <div class="msg_price">
                            ￥${car.skuJg}
                        </div>
                        <div class="msg_mon">
                            *${car.tjshl}
                        </div>
                        <div class="msg_state">
                            有货
                        </div>
                    </div>
                </div>
            </c:if>
        </c:forEach>

        <div class="msg_line"></div>
        <div class="msg_sub">
            <div class="msg_sub_tit">
                应付金额：
                <b>￥${sum}</b>
            </div>
            <div class="msg_sub_adds">
                <%--寄送至 ： 北京市 昌平区     &nbsp;某某某（收）  185****1222--%>
            </div>
            <a><button class="msg_btn" onclick="saveOrder()">提交订单</button></a>
        </div>
    </div>
</body>
</html>
