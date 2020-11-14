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
    <style>

    </style>
</head>
<body>
<div class="width100 hidden_yh" style="border-top: 1px solid #ddd">
    <div class="width1200 hidden_yh center_yh" style="margin-top: 75px">
        <form action="login/toRes" method="post">
            <div class="center_yh hidden_yh" style="width: 530px;margin-bottom: 40px">
                <span style="margin-right: 40px;height: 42px;line-height: 42px;width: 100px" class="left_yh block_yh tright">用户名:</span>
                <input type="text" name="userName" placeholder="请输入您的用户名" value="${user.userName}" style="border: 1px solid #c9c9c9; width: 292px;height: 42px;font-size: 16px;text-indent: 22px;" class="left_yh">
                <c:if test="${re.error1 !=null}">${re.error1}</c:if>
                <c:if test="${re.error3 !=null}">${re.error3}</c:if>
            </div>
            <div class="center_yh hidden_yh" style="width: 530px;margin-bottom: 40px">
                <span style="margin-right: 40px;height: 42px;line-height: 42px;width: 100px" class="left_yh block_yh tright">密码:</span>
                <input type="text" name="passWord" placeholder="建议使用两种字符组合" value="${user.passWord}" style="border: 1px solid #c9c9c9; width: 292px;height: 42px;font-size: 16px;text-indent: 22px;" class="left_yh">
                <c:if test="${re.error2 !=null}">${re.error2}</c:if>
            </div>
            <div class="center_yh hidden_yh" style="width: 530px;margin-bottom: 40px">
                <span style="margin-right: 40px;height: 42px;line-height: 42px;width: 100px" class="left_yh block_yh tright">手机号:</span>
                <input type="text" name="phone" placeholder="建议使用常用手机" value="${user.phone}" style="border: 1px solid #c9c9c9; width: 292px;height: 42px;font-size: 16px;text-indent: 22px;" class="left_yh">
            </div>
            <div class="center_yh hidden_yh" style="width: 530px;margin-bottom: 40px">
                <span style="margin-right: 40px;height: 42px;line-height: 42px;width: 100px" class="left_yh block_yh tright">电子邮箱:</span>
                <input type="text" name="email" placeholder="建请输入邮箱" value="${user.email}" style="border: 1px solid #c9c9c9; width: 292px;height: 42px;font-size: 16px;text-indent: 22px;" class="left_yh">
            </div>
            <p class="font14 c_66" style="text-indent: 500px;margin-top: 30px">
                <input type="checkbox">我已阅读并同意<a href="javasrcpit:void(0);" class="red">《会员注册协议》</a>和<a href="javasrcpit:void(0);" class="red">《隐私保护政策》</a>
            </p>
            <input type="submit" value="提交" class="ipt_tj" style="width: 295px;height: 44px;margin-left: 500px;">
        </form>
    </div>
</div>
    <%@include file="/common/ufootter.jsp"%>
</body>
</html>
