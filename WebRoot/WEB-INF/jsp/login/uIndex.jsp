<%--
  Created by IntelliJ IDEA.
  User: zzzzh
  Date: 2020/11/3
  Time: 9:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglibs.jsp"%>
<%
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>用户首页</title>
    <link rel="stylesheet" href="resource/user/css/style.css">
    <script src="resource/user/js/jquery-1.8.3.min.js"></script>
    <script src="resource/user/js/jquery.luara.0.0.1.min.js"></script>
</head>
<body>
    <%@include file="/common/utop.jsp"%>
<div class="width100" style="height:45px;background:#dd4545;margin-top: 40px;position:relative;z-index: 100">
    <div class="width1200 center_yh relative_yh" style="height: 45px">
        <div class="left_yh Selected" style="width:230px;height: 45px;" id="hiddenShow">
            <img src="resource/user/images/cd.png" class="left_yh " style="margin-left: 24px" alt="">
            <span class="block_yh left_yh fff" style="height: 45px;line-height: 44px;margin-left: 10px">分类</span>
            <div class="downSlide">
                <c:forEach items="${lbs}" var="data" varStatus="l" >
                    <div class="n1Nav">
                        <font>${data.father.name}</font>
                        <img src="resource/user/images/jt.png" alt="">
                        <div class="n2Nav">
                            <div class="n3Nav">
                                <h3>${data.father.name}</h3>
                                <c:forEach items="${data.children}" var="child" varStatus="11">
                                    <a href="item/shopList?category_id_two=${child.id}">${child.name}</a>
                                </c:forEach>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
        <div class="left-yh font16 " id="pageNav">
            <a href="login/uIndex">首页</a>
            <a href="news/list">公告</a>
            <a href="message/add">留言</a>
            <a href="car/findBySql">我的购物车</a>

        </div>
    </div>
</div>
<div class="width1200 center_yh hidden_yh" style="position: relative; z-index: 80">
    <div class="example2" style="width: 1200px;height: 490px;overflow: hidden;margin-left:230px ">
        <ul>
            <li><img src="resource/images/a.webp" alt=""></li>
            <li><img src="resource/images/b.webp" alt=""></li>
            <li><img src="resource/images/c.webp" alt=""></li>
            <li><img src="resource/images/d.webp" alt=""></li>
        </ul>
    </div>
    <script>
        $(function () {
            $(".example2").luara({width:"996",height:"490",interval:2000,selected:"selected",deriction:"left"});
        })
    </script>
</div>
<div class="width1200 center_yh hidden_yh">
    <div class="width100" style="height: 45px;line-height: 45px;border-bottom: 2px solid #dd4545">
        <font class="left_yh font20">折扣大促销</font>
    </div>
    <div class="width100 hidden_yh" style="height: 480px">
        <div class="normalPic">
            <c:forEach items="${zks}" var="data" varStatus="1">
                <a href="item/view?id=${data.id}">
                    <h3 class="yihang c_33 font14 font100" style="padding-left: 10px;padding-right: 10px">${data.name}</h3>
                    <p class="red font14" style="padding-left: 10px">${data.price}</p>
                    <img src="${data.url1}" width="105px" height="118px" alt="" style="margin: 0 auto">
                </a>
            </c:forEach>
        </div>
    </div>
</div>
    <div class="width1200 center_yh hidden_yh">
        <div class="width100" style="height: 45px;line-height: 45px;border-bottom: 2px solid #dd4545">
            <font class="left_yh font20">热门大促销</font>
        </div>
        <div class="width100 hidden_yh" style="height: 480px">
            <div class="normalPic">
                <c:forEach items="${rxs}" var="data" varStatus="1l">
                    <a href="item/view?id=${data.id}">
                        <h3 class="yihang c_33 font14 font100" style="padding-left: 10px;padding-right: 10px">${data.name}</h3>
                        <p class="red font14" style="padding-left: 10px">${data.price}</p>
                        <img src="${data.url1}" width="105px" height="118px" alt="" style="margin: 0 auto">
                    </a>
                </c:forEach>
            </div>
        </div>
    </div>
    <%@include file="/common/ufootter.jsp"%>
</body>
</html>
