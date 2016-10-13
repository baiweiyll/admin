<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@  taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib  prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<link href="${ctx}/static/js/treetable/css/jquery.treetable.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/static/js/treetable/css/jquery.treetable.theme.default.css" rel="stylesheet" type="text/css" />
<script src="${ctx}/static/js/treetable/jquery.treetable.js" type="text/javascript"></script>
<div class="portlet box red-sunglo">
    <div class="portlet-title">
        <div class="caption">
            <i class="icon-grid"></i> 系统菜单
        </div>
        <div class="tools">
            <a href="" class="fullscreen" style='text-decoration:none;'> </a>
        </div>
    </div>
    <div class="portlet-body">
        <div class="table-responsive">
            <table id="treeTable" class="table table-striped table-bordered table-hover treetable">
                <thead>
                <tr>
                    <th>名称</th>
                    <th>链接</th>
                    <th>排序</th>
                    <th>target</th>
                    <th>权限</th>
                    <th>创建人</th>
                    <th>创建时间</th>
                    <th>修改人</th>
                    <th>修改时间</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${menus}" var="menu">
                    <tr data-tt-id="${menu.id}"   data-tt-parent-id="${menu.parentId}" >
                        <td>
                            <c:if test="${not empty menu.icon}">
                                <i class="${menu.icon}"></i>
                            </c:if>
                                ${menu.name}
                        </td>
                        <td>
                                ${menu.href}
                        </td>
                        <td>
                                ${menu.sort}
                        </td>
                        <td>
                                ${menu.target}
                        </td>
                        <td>
                                ${menu.permission}
                        </td>
                        <td>
                                ${menu.createBy}
                        </td>
                        <td>
                            <fmt:formatDate value="${menu.createDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
                        </td>
                        <td>
                                ${menu.updateBy}
                        </td>
                        <td>
                            <fmt:formatDate value="${menu.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
                        </td>

                    </tr>
                </c:forEach>
                </tbody>

            </table>
        </div>
    </div>
</div>


<script type="text/javascript">
    seajs.use("system/menu/main",function(menu){
        menu.init();
    });
</script>