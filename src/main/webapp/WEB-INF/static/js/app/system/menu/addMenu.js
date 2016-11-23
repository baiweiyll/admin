/**
 * Created by baiwei on 2016/10/17.
 */
define(function(require, exports, module){
    var layout = require("layout/main");

    function addMenu(){
      if($("#addMenuForm").valid()){
          var data = $('#addMenuForm').serialize();
          HoldOn.open();
          $.ajax({
              url:basePath + "sys/addMenu",
              type:"POST",
             // contentType: "application/json",
             // dataType:"json",
              data:data,
              complete:function(){
                  HoldOn.close();
              },
              success:function(){
                  //关闭窗口
                  $('#addMenu-modal').modal('hide');
                  //刷新父页面
                  layout.refresh(function(){
                      var menuList = require("system/menu/main");
                      //展开对应节点
                      menuList.expandNode($("#parentId").val());
                  });

              }
          });
      }
    }

    function addFormValidate(){
        $("#addMenuForm").validate({
            rules:{
               // parentId:{required:true},
                name:{required:true,maxlength:20},
                href:{maxlength:200},
                permission:{maxlength:200},
                sort:{required:true,digits:true},
                icon:{maxlength:100}
            }
        });
    }

    function bindEvent(){
/*        $( '#ajax-modal' ).on( 'hidden.bs.modal' ,function(e){
            alert("close");
        });*/
        $("#addMenuOk").click(function(){
            addMenu();
        });
        $("#parentName").click(function(){
            var $modal = $('#menuTree-modal');
            $modal.load(basePath + 'sys/menu/tree',"menuId="+$("#parentId").val(), function(){
                $modal.modal();
            });
        });
    }

    module.exports = {
        init:function(){
            $(document).ready(function() {
                addFormValidate();
                bindEvent();
            });

        },
        setParent:function(id,name){
            if ("-1" != id) {
                $("#parentId").val(id);
            }
            $("#parentName").val(name);
        }
    }

});
