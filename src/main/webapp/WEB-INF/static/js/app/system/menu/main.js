/**
 * Created by baiwei on 2016/10/13.
 */
define(function(require, exports, module) {

    var layout = require("layout/main");
    var dialog = require("util/dialogUtil");
    var addMenu = require("system/menu/addMenu");

    function initTreeTable(){
        //collapsed expanded
        $("#treeTable").treetable({ initialState:"collapsed",expandable: true});
    }

    function bindEvent(){
        //表格树展开，收缩事件
        $("#expanded").click(function(){
            $("#treeTable").treetable("expandAll");
        });
        $("#collapsed").click(function(){
            $("#treeTable").treetable("collapseAll");
        });
        //新建菜单事件
        $("#addMenu").click(function(){
            var $modal = $('#addMenu-modal');
            $modal.load(basePath + 'sys/addMenuView', null, function(){
                $modal.modal();
                addMenu.setParent("-1","根节点");
            });
        });

        //添加子菜单事件
        $("a[id^='addChildMenu']").click(function(){
            var menuId = $(this).attr("data");
            var menuName = $(this).attr("menuName");
            var $modal = $('#addMenu-modal');
            $modal.load(basePath + 'sys/addMenuView', null, function(){
                $modal.modal();
                addMenu.setParent(menuId,menuName);
            });
        });

        //编辑菜单事件
        $("a[id^='editMenu']").click(function(){
            var menuId = $(this).attr("data");
            var $modal = $('#addMenu-modal');
            $modal.load(basePath + 'sys/addMenuView', "menuId=" + menuId, function(){
                $modal.modal();
            });
        });

        $("a[id^='delMenu']").click(function(){
            if(!$(this).closest("tr").hasClass("leaf")){
                toastr.error("请先删除子菜单");
                return;
            }
            var menuId = $(this).attr("data");
            var menuName = $(this).attr("menuName");
            var pid = $(this).attr("pid");
            dialog.showWarningConfirm("确定要删除菜单吗?","请确保被删除菜单["+menuName+"]无孩子节点!",function(){
                //关闭弹窗
                swal.close();
                $("#maincontent").LoadingOverlay("show");
                $.ajax({
                    url:basePath + "sys/delMenu",
                    type:"GET",
                    data:"menuId="+menuId,
                    complete:function(){
                        $("#maincontent").LoadingOverlay("hide");
                    },
                    success:function(data){
                        //刷新父页面
                        layout.refresh(function(){
                            toastr.success('删除菜单['+menuName+']成功');
                            //展开对应节点
                            if (pid && pid.length > 1) {
                                module.exports.expandNode(pid);
                            }
                        });

                    }
                });
            })

        });

    }
    module.exports = {
        expandNode:function(nodeId) {
            if (nodeId) {
                $("#treeTable").treetable("reveal",nodeId);
            }
        },
        init:function(){
            $(document).ready(function(){
                initTreeTable();
                bindEvent();
            });
        }
    }
});