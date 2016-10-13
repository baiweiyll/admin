<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link href="${ctx}/static/treetable/css/jquery.treetable.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/static/treetable/css/jquery.treetable.theme.default.css" rel="stylesheet" type="text/css" />
<script src="${ctx}/static/treetable/jquery.treetable.js" type="text/javascript"></script>
<div class="table-responsive">
    <table id="treeTable" class="table table-striped table-bordered table-hover treetable">
        <thead>
            <tr>
                <th>名称</th>
                <th>链接</th>
                <th>排序</th>
                <th>target</th>
                <th>权限</th>
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


                </tr>
            </c:forEach>
        </tbody>

    </table>
</div>

<script type="text/javascript">
    $(document).ready(function() {
        $("#treeTable").treetable({ initialState:"expanded",expandable: true});
    });
</script>