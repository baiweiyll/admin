/**
 * Created by baiwei on 2016/10/20.
 */
define(function(require, exports, module) {

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