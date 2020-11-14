<%--
  Created by IntelliJ IDEA.
  User: zzzzh
  Date: 2020/11/3
  Time: 19:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglibs.jsp" %>
<%
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>更新商品</title>
    <link rel="stylesheet" href="resource/ml/css/style.css">
    <link rel="stylesheet" href="resource/css/pintuer.css">
    <link rel="stylesheet" href="resource/css/admin.css">
    <script src="resource/js/jquery.js"></script>
    <script src="resource/js/pintuer.js"></script>
    <script src="resource/ueditor/ueditor.config.js"></script>
    <script src="resource/ueditor/ueditor.all.min.js"></script>
    <style>
        .tips img{
            width: 100px;
            height: 100px;
        }
    </style>
</head>
<body>
<div class="panel admin-panel">
    <div class="panel-head" id="add">
        <strong><span class="icon-pencil-square-o">更新商品</span> </strong>
    </div>
    <div class="body-content">
        <form action="item/exUpdate" method="post" class="form-x" enctype="multipart/form-data">
            <input type="hidden" value="${item.id}" name="id">
            <div class="form-group">
                <div class="label"><label>商品名称：</label></div>
                <div class="field">
                    <input type="text" class="input w50" name="name" data-validate="required:请输入商品名称" value="${item.name}" />
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label"><label>商品价格：</label></div>
                <div class="field">
                    <input type="text" class="input w50" name="price" data-validate="required:请输入商品价格" value="${item.price}"/>
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label"><label>商品折扣：</label></div>
                <div class="field">
                    <input type="text" class="input w50" name="zk" data-validate="required:请输入商品折扣" value="${item.zk}" />
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label"><label>商品类别：</label></div>
                <div class="field">
                    <select name="category_id_two" class="input w50">
                        <c:forEach items="${obj}" var="data" varStatus="l">
                            <option value="${data.id}" selected="${data.id == item.id?"selected":""}">${data.name}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <div class="form-group">
                <div class="label"><label>主图：</label></div>
                <div class="field">
                    <input type="file" class="input w50" name="file" value="" />
                    <div class="tips"><img src="${item.url1}" alt="加载失败了"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label"><label>副图1：</label></div>
                <div class="field">
                    <input type="file" class="input w50" name="file" />
                    <div class="tips"><img src="${item.url2}" alt="加载失败了"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label"><label>副图2：</label></div>
                <div class="field">
                    <input type="file" class="input w50" name="file" />
                    <div class="tips"><img src="${item.url3}" alt="加载失败了"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label"><label>副图3：</label></div>
                <div class="field">
                    <input type="file" class="input w50" name="file" />
                    <div class="tips"><img src="${item.url4}" alt="加载失败了"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label"><label>副图4：</label></div>
                <div class="field">
                    <input type="file" class="input w50" name="file" />
                    <div class="tips"><img src="${item.url5}" alt="加载失败了"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label"><label>描述：</label></div>
                <div class="field">
                    <script type="text/plain" id="remark_txt_1" name="ms" style="width: 100%;height: 300px;">${item.ms}</script>
                    <script type="text/javascript">
                        var editor = UE.getEditor('remark_txt_1');
                        UE.Editor.prototype._bkGetActionUrl = UE.Editor.prototype.getActionUrl;
                        UE.Editor.prototype.getActionUrl = function (action) {
                            if(action == 'uploadimage' || action == 'uploadscrawl' || action == 'uploadvideo'){
                                return '${ctx}/ueditor/saveFile';
                            }else{
                                return this._bkGetActionUrl.call(this,action);
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
</body>
</html>
