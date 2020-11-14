<%@include file="/common/taglibs.jsp" %>
<%--
  Created by IntelliJ IDEA.
  User: zzzzh
  Date: 2020/11/3
  Time: 18:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>Title</title>
    <link rel="stylesheet" href="resource/ml/css/style.css">
    <link rel="stylesheet" href="resource/css/pintuer.css">
    <link rel="stylesheet" href="resource/css/admin.css">
    <script src="resource/js/jquery.js"></script>
    <script src="resource/js/pintuer.js"></script>
</head>
<body>
    <div class="panel admin-panel">
        <form action="message/findBySql" id="listform" method="post">
        <div class="padding border-bottom">
            <ul>
                <li>
                    <input type="text" placeholder="请输入商品名称" name="name" value="${obj.name}" class="input" style="width: 250px;line-height: 17px;display: inline-block">
                    <a href="javascript:void(0);" onclick="changeSearch()" class="button border-main icon-search">搜索</a>
              <%--      <a class="button border-main icon-plus-square-o" href="itemCategory/toAddCateGory">新增类目</a>--%>
                </li>
            </ul>
        </div>
        </form>
        <table class="table table-hover text-center">
            <tr>
                <th>留言人姓名</th>
                <th>手机号</th>
                <th>操作</th>
            </tr>
            <c:forEach items="${pagers.datas}" var="data" varStatus="1">
                <tr>
                    <td>${data.name}</td>
                    <td>${data.phone}</td>
                    <td>
                        <a class="button border-main" href="message/update?id=${data.id}"><span class="icon-edit">修改</span></a>
                        <a class="button border-red" href="message/delete?id=${data.id}"><span class="icon-trash-o">删除</span></a>
                    </td>
                </tr>
            </c:forEach>
            <tr>
                <td colspan="8">
                    <div class="pagelist">
                        <pg:pager url="message/findBySql" maxIndexPages="5" items="${pagers.total}" maxPageItems="15" export="curPage=pageNumber">
                            <pg:last>
                                共${pagers.total}记录,共${pageNumber}页,
                            </pg:last>
                            当前第${curPage}页
                            <pg:first>
                                <a href="${pageUrl}">首页</a>
                            </pg:first>
                            <pg:prev>
                                <a href="${pageUrl}">上一页</a>
                            </pg:prev>
                            <pg:pages>
                                <c:choose>
                                    <c:when test="${curPage eq pageNumber}">
                                        <font color="red">[${pageNumber}]</font>
                                    </c:when>
                                    <c:otherwise>
                                        <a href="${pageUrl}">${pageNumber}</a>
                                    </c:otherwise>
                                </c:choose>
                            </pg:pages>
                            <pg:next>
                                <a href="${pageUrl}">下一页</a>
                            </pg:next>
                            <pg:last>
                                <c:choose>
                                    <c:when test="${curPage eq pageNumber}">
                                        <font color="red">[尾页]</font>
                                    </c:when>
                                    <c:otherwise>
                                        <a href="${pageUrl}">尾页</a>
                                    </c:otherwise>
                                </c:choose>
                            </pg:last>
                        </pg:pager>
                    </div>
                </td>
            </tr>
        </table>
    </div>

</body>
<script>
    function changeSearch() {
        $("#listform").submit();
    }
</script>
</html>
