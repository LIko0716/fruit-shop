<%--
  Created by IntelliJ IDEA.
  User: zzzzh
  Date: 2020/11/3
  Time: 12:39
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
    <title>管理员首页</title>
    <link rel="stylesheet" href="${ctx}/resource/ml/css/style.css">
    <link rel="stylesheet" href="${ctx}/resource/css/pintuer.css">
    <link rel="stylesheet" href="${ctx}/resource/css/admin.css">
    <script src="${ctx}/resource/js/jquery.js"></script>
    <script src="${ctx}/resource/js/pintuer.js"></script>
</head>
<body style="background: #f2f9fd">
    <div class="header bg-main">
        <div class="logo margin-big-left fadein-top">
            <h1>管理员后台</h1>
        </div>
        <div class="head-l">
            <a href="" target="_blank" class="button button-little bg-green">
                <span class="icon-home"></span>前台首页
            </a>
            <a href="" target="_blank" class="button button-little bg-blue">
                <span class="icon-wrench"></span>清除缓存
            </a>
            <a href="login/mLogout" target="_blank" class="button button-little bg-red">
                <span class="icon-power-off"></span>退出登录
            </a>
        </div>
    </div>
    <div class="leftnav">
        <div class="leftnav-title"><strong><span class="icon-list">菜单列表</span></strong></div>
        <h2><span class="icon-user"></span>基本设置</h2>
        <ul style="display: block">
            <li><a href="itemCategory/findBySql" target="right"><span class="icon-caret-right"></span>类目管理</a> </li>
            <li><a href="user/findBySql" target="right"><span class="icon-caret-right"></span>用户管理</a> </li>
            <li><a href="item/findBySql" target="right"><span class="icon-caret-right"></span>商品管理</a> </li>
            <li><a href="itemOrder/findBySql" target="right"><span class="icon-caret-right"></span>订单管理</a> </li>
            <li><a href="news/findBySql" target="right"><span class="icon-caret-right"></span>公告管理</a> </li>
            <li><a href="message/findBySql" target="right"><span class="icon-caret-right"></span>留言管理</a> </li>
        </ul>
    </div>
    <ul class="bread">
        <li><a href="{:}" target="right" class="icon-home"></a></li>
        <li><a href="#">网站信息</a></li>
        <li><b>当前语言:</b><span style="color: red">中文</span>
        &nbsp;&nbsp;&nbsp;&nbsp;切换语言: <a href="javascript:void(0);">中文</a>&nbsp;&nbsp;<a href="javascript:void(0);">英文</a>
        </li>
    </ul>
<div class="admin">
    <iframe name="right" scrolling="auto" frameborder="0" width="100%" height="100%"></iframe>
</div>
</body>
</html>
