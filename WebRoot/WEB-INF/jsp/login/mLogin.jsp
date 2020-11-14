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
    <title>用户登录</title>
    <link rel="stylesheet" href="${ctx}/resource/ml/css/style.css">
    <link rel="stylesheet" href="${ctx}/resource/css/pintuer.css">
    <link rel="stylesheet" href="${ctx}/resource/css/admin.css">
    <script src="${ctx}/resource/js/jquery.js"></script>
    <script src="${ctx}/resource/js/pintuer.js"></script>
</head>
<body>
<div class="bg">
    <div class="container">
        <div class="line bouncein">
            <div class="xs6 xm4 xs3-move xm4-move">
                <div style="height: 150px;"></div>
                <div class="media media-y margin-big-bottom"></div>
                <form action="${ctx}/login/toLogin" method="post">
                    <div class="panel login-box">
                        <div class="text-center margin-big padding-big-top"><h1>管理员登陆</h1></div>
                        <div class="panel-body" style="padding: 30px;padding-bottom: 10px; padding-top:10px";>
                            <div class="form-group">
                                <div class="field field-icon-right">
                                    <input type="text" class="input input-bg" name="userName" value="admin" placeholder="登陆账号" data-validate="required:请填写账号">
                                    <span class="icon icon-user margin-small"></span>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="field field-icon-right">
                                    <input type="password" class="input input-bg" name="passWord" value="111111" placeholder="登陆密码" data-validate="required:请填写密码">
                                    <span class="icon icon-user margin-small"></span>
                                </div>
                            </div>
                            <div style="padding: 30px">
                                <input type="submit" class="button button-block bg-main text-big input-big" value="登录">
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

</body>
</html>
