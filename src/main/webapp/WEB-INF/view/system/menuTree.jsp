<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link href="${ctx}/static/js/assets/global/plugins/jstree/dist/themes/default/style.min.css" rel="stylesheet" type="text/css" />
<div class="col-md-3">
    <div class="form-group  ">
        <div class="input-icon ">
            <i class="fa fa fa-search font-green"></i>
            <input type="text" class="form-control input-circle" placeholder="搜索菜单" id="searchMenu">
        </div>
    </div>
    <div id="menuTree" class="tree-demo"></div>
</div>

<script src="${ctx}/static/js/assets/global/plugins/jstree/dist/jstree.min.js" type="text/javascript"></script>
<script type="text/javascript">
    seajs.use("system/menu/menuTree",function(menuTree){
        menuTree.init();
    });
</script>
