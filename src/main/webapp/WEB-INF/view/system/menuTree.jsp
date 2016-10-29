<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link href="${ctx}/static/js/assets/global/plugins/jstree/dist/themes/default/style.min.css" rel="stylesheet" type="text/css" />

<div class="modal-header">
    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
    <h3>选择父级菜单</h3>
</div>
<div class="modal-body">
    <div id="menuTree-modal" class="modal  fade" data-backdrop="static" data-keyboard="false"></div>
    <div class="row">
        <div class="form-group">
            <div class="input-icon ">
                <i class="fa fa fa-search font-green"></i>
                <input type="text" class="form-control input-circle" placeholder="搜索菜单" id="searchMenu">
            </div>
        </div>
        <div id="menuTree" class="tree-demo"></div>
    </div>
</div>
<div class="modal-footer">
    <a href="javascript:;" class="btn " id="menuTreeOk">
        <i class="fa fa-check"></i>
        确定
    </a>
    <a href="javascript:;" class="btn "  data-toggle="modal" data-target="#menuTree-modal">
        <i class="fa fa-times"></i>
        取消
    </a>
</div>

<script src="${ctx}/static/js/assets/global/plugins/jstree/dist/jstree.min.js" type="text/javascript"></script>
<script type="text/javascript">
    seajs.use("system/menu/menuTree",function(menuTree){
        menuTree.init();
    });
</script>
