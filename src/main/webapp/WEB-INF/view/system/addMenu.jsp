<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/10/14
  Time: 16:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="modal-header">
    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
    <h3>添加菜单</h3>
</div>
<div class="modal-body">
    <div id="menuTree-modal" class="modal  fade" data-backdrop="static" data-keyboard="false"></div>
    <form class="form-horizontal" role="form" id="addMenuForm">
        <div class="form-body">
            <div class="form-group">
                <label class="col-md-3 control-label">父级菜单<span class="required" aria-required="true"> * </span></label>
                <div class="col-md-9">
                    <input type="text" class="form-control" id="parentId" name="parentId">
                </div>
            </div>
            <div class="form-group">
                <label class="col-md-3 control-label">菜单名称<span class="required" aria-required="true"> * </span></label>
                <div class="col-md-9">
                    <input type="text" class="form-control" id="name" name="name" required>
                </div>
            </div>
            <div class="form-group">
                <label class="col-md-3 control-label">菜单链接</label>
                <div class="col-md-9">
                    <input type="text" class="form-control" placeholder="请输入相对路径" id="href" name="href">
                </div>
            </div>
            <div class="form-group">
                <label class="col-md-3 control-label">菜单权限</label>
                <div class="col-md-9">
                    <input type="text" class="form-control" id="permission" name="permission">
                </div>
            </div>
            <div class="form-group">
                <label class="col-md-3 control-label">菜单排序<span class="required" aria-required="true"> * </span></label>
                <div class="col-md-9">
                    <input type="text" class="form-control" id="sort" name="sort">
                </div>
            </div>
            <div class="form-group">
                <label class="col-md-3 control-label">菜单图标</label>
                <div class="col-md-9">
                    <input type="text" class="form-control" id="icon" name="icon">
                </div>
            </div>
        </div>
    </form>
</div>
<div class="modal-footer">
    <a href="javascript:;" class="btn " id="addMenuOk">
        <i class="fa fa-check"></i>
        确定
    </a>
    <a href="javascript:;" class="btn "  data-toggle="modal" data-target="#ajax-modal">
        <i class="fa fa-times"></i>
        取消
    </a>
</div>

<script type="text/javascript">
    seajs.use("system/menu/addMenu",function(addMenu){
        addMenu.init();
    });
</script>
