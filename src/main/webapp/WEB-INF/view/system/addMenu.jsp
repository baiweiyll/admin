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
    <form class="form-horizontal" role="form" id="addMenuForm">
        <div class="form-body">
            <div class="form-group">
                <label class="col-md-3 control-label">菜单名称<span class="required" aria-required="true"> * </span></label>
                <div class="col-md-9">
                    <input type="text" class="form-control" id="menuName" name="menuName" required>
                </div>
            </div>
            <div class="form-group">
                <label class="col-md-3 control-label">菜单链接</label>
                <div class="col-md-9">
                    <input type="text" class="form-control" placeholder="请输入相对路径" id="menuUrl" name="menuUrl">
                </div>
            </div>
            <div class="form-group">
                <label class="col-md-3 control-label">菜单权限</label>
                <div class="col-md-9">
                    <input type="text" class="form-control" id="menuP">
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
    <a href="javascript:;" class="btn " id="addMenuCancel">
        <i class="fa fa-times"></i>
        取消
    </a>
</div>

<script type="text/javascript">
    seajs.use("system/menu/addMenu",function(addMenu){
        addMenu.init();
    });
</script>
