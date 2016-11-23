<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@  taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib  prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<link href="${ctx}/static/js/treetable/css/jquery.treetable.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/static/js/treetable/css/jquery.treetable.theme.default.css" rel="stylesheet" type="text/css" />
<script src="${ctx}/static/js/treetable/jquery.treetable.js" type="text/javascript"></script>
<div class="portlet box red-sunglo">
    <!-- add menu modal-->
    <div id="addMenu-modal" class="modal  fade" data-backdrop="static" data-keyboard="false"></div>
    <div class="portlet-title">
        <div class="caption">
            <i class="icon-grid"></i> 系统菜单
        </div>
        <div class="tools">
            <a href="" class="fullscreen" style='text-decoration:none;'> </a>
        </div>
    </div>
    <div class="portlet-body">
        <div>
            <a href="javascript:;" class="btn " id="addMenu">
                <i class="fa fa-plus"></i>
                新建菜单
            </a>
        </div>
        <div class="table-responsive">
            <table id="treeTable" class="table table-striped table-bordered table-hover treetable">
                <thead>
                    <tr>
                        <th>
                            <div class="task-status">
                                <a  style='text-decoration:none;' href="javascript:;" id="expanded">
                                    <li class="fa fa-plus-square"></li>
                                </a>
                                <a style='text-decoration:none;' href="javascript:;" id="collapsed">
                                    <li class="fa fa-minus-square"></li>
                                </a>
                            </div>
                        </th>
                        <th>链接</th>
                        <th>排序</th>
                        <th>权限</th>
                        <th>创建人</th>
                        <th>创建时间</th>
                        <th>修改人</th>
                        <th>修改时间</th>
                        <th>操作</th>
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
                        <td>
                            <a class="btn btn-circle btn-icon-only btn-default" href="javascript:;" pid="${menu.parentId}"   data="${menu.id}" menuName="${menu.name}" id="addChildMenu-${menu.id}">
                                <i class="fa fa-plus"></i>
                            </a>
                            <a class="btn btn-circle btn-icon-only btn-default" href="javascript:;" pid="${menu.parentId}" data="${menu.id}" menuName="${menu.name}" id="editMenu-${menu.id}">
                                <i class="fa fa-pencil-square-o"></i>
                            </a>
                            <a class="btn btn-circle btn-icon-only btn-default" href="javascript:;" pid="${menu.parentId}" data="${menu.id}" menuName="${menu.name}" id="delMenu-${menu.id}">
                                <i class="fa fa-times"></i>
                            </a>
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