/**
 * Created by baiwei on 2016/10/13.
 */
define(function(require, exports, module) {

    var layout = require("layout/main");

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
            var $modal = $('#ajax-modal');
            $modal.load('http://localhost:8888/admin/sys/addMenu', null, function(){
                $modal.modal();
            });
            //layout.refresh();
        });
    }
    module.exports = {
        init:function(){
            initTreeTable();
            bindEvent();
        }
    }
});