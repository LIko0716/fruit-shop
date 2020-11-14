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
    <title>新增新闻</title>
    <link rel="stylesheet" href="resource/ml/css/style.css">
    <link rel="stylesheet" href="resource/css/pintuer.css">
    <link rel="stylesheet" href="resource/css/admin.css">
    <script src="resource/js/jquery.js"></script>
    <script src="resource/js/pintuer.js"></script>
    <script src="resource/ueditor/ueditor.config.js"></script>
    <script src="resource/ueditor/ueditor.all.min.js"></script>
</head>
<body>
<div class="panel admin-panel">
    <div class="panel-header" id="add">
        <strong><span class="icon-pencil-square-o">新增新闻</span></strong>
    </div>
    <div class="body-content">
        <form action="news/exAdd" type="post" class="form-x">
            <div class="form-group">
                <div class="label">
                    <lable>新闻名称</lable>
                </div>
                <div class="field">
                    <input type="text" class="input w50" name="name" data-validate="required:请输入名称">
                    <div class="tips"></div>
                </div>
            </div>
                <div class="form-group">
                    <div class="label"><label>描述：</label></div>
                    <div class="field">
                        <script type="text/plain" id="remark_txt_1" name="content"
                                style="width: 100%;height: 300px;"></script>
                        <script type="text/javascript">
                            var editor = UE.getEditor('remark_txt_1');
                            UE.Editor.prototype._bkGetActionUrl = UE.Editor.prototype.getActionUrl;
                            UE.Editor.prototype.getActionUrl = function (action) {
                                if (action == 'uploadimage' || action == 'uploadscrawl' || action == 'uploadvideo') {
                                    return '${ctx}/ueditor/saveFile';
                                } else {
                                    return this._bkGetActionUrl.call(this, action);
                                }
                            }
                        </script>
                        <div class="tips"></div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="label"></div>
                    <div class="field">
                        <button class="button bg-main icon-check-square-o" type="submit">提交</button>
                    </div>
                </div>

        </form>
    </div>
</div>
</body>
</html>
