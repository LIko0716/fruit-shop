<%--
  Created by IntelliJ IDEA.
  User: zzzzh
  Date: 2020/11/3
  Time: 19:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>新增类目</title>
    <link rel="stylesheet" href="resource/ml/css/style.css">
    <link rel="stylesheet" href="resource/css/pintuer.css">
    <link rel="stylesheet" href="resource/css/admin.css">
    <script src="resource/js/jquery.js"></script>
    <script src="resource/js/pintuer.js"></script>
</head>
<body>
    <div class="panel admin-panel">
        <div class="panel-header" id="add">
            <strong><span class="icon-pencil-square-o">新增类目</span></strong>
        </div>
        <div class="body-content">
            <form action="itemCategory/add" type="post" class="form-x">
                <div class="form-group">
                    <div class="label"><lable>一级类目名称:</lable></div>
                    <div class="field">
                        <input type="text" class="input w50" name="name" data-validate="required:请输入名称">
                        <div class="tips"></div>
                    </div>
                    <div class="form-group">
                        <div class="label"></div>
                        <div class="field">
                            <button class="button bg-main icon-check-square-o" type="submit">提交</button>
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </div>
</body>
</html>
