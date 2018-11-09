<%--
  Created by IntelliJ IDEA.
  User: JangSinyu
  Date: 2018/11/6
  Time: 10:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <script>



    </script>
</head>
<body>
    <div class="Sbox">
        <c:forEach items="${skuList}" var="sku">
            <a href="/toItemPage.do?skuId=${sku.id}&spuId=${sku.shpId}" target="_blank">
                <div class="list">
                    <div class="img"><img src="images/img_4.jpg" alt=""></div>
                    <div class="price">${sku.jg}</div>
                    <div class="title">${sku.skuMch}</div>
                </div>
            </a>
        </c:forEach>

    </div>
</body>
</html>
