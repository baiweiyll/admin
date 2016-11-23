/**
 * Created by baiwei on 2016/10/20.
 */
define(function(require, exports, module) {

    var addMenu = require("system/menu/addMenu");

    function initTree(){
        HoldOn.open();
        $.ajax({
            url:basePath + "sys/jstree",
            contentType: "application/json",
            dataType:"json",
            complete:function(){
                HoldOn.close();
            },
            success:function(dataArray){
                createTree(dataArray);
            }
        });
    }

    function createTree(dataArray){
        $('#menuTree').jstree({
            "core" : {
                "themes" : {
                    "responsive": false
                },
            "data":dataArray
            },
            "types" : {
                "default" : {
                    "icon" : "fa fa-folder icon-state-warning icon-lg"
                },
                "file" : {
                    "icon" : "fa fa-file icon-state-warning icon-lg"
                }
            },
            "plugins": ["types","search"]
        });
    }

    function bindEvent(){
        var to = false;
        $('#searchMenu').keyup(function () {
            if(to) { clearTimeout(to); }
            to = setTimeout(function () {
                var v = $('#searchMenu').val();
                $('#menuTree').jstree(true).search(v);
            }, 250);
        });

        $('#menuTreeOk').click(function(){
            var sNode = $.jstree.reference('#menuTree').get_selected(true);
            if (sNode && sNode.length ==1) {
                addMenu.setParent(sNode[0].id,sNode[0].text);
                $('#menuTree-modal').modal('hide');
            } else {
                toastr.error("请选择菜单");
            }
        });
    }
    module.exports = {
        init:function(){
            $(document).ready(function() {
                initTree();
                bindEvent();
            });
        }
    }
});