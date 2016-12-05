/**
 * Created by baiwei on 2016/10/20.
 */
define(function(require, exports, module) {

    var check = require("util/checkUtil");
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
        }).on("ready.jstree", function (e,data) {

            var selectId = $('#selectMenuId').val();
            if (selectId && selectId.length > 1) {
                data.instance.select_node(selectId);
            } else {
                data.instance.select_node("-1");
            }
            //module.exports.selectNode("df7ce823c5b24ff9bada43d992f373e6");
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
                $('#menuTree-modal').modal('hide');
                addMenu.setParent(sNode[0].id,sNode[0].text);
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