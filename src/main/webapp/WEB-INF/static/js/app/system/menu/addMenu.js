/**
 * Created by baiwei on 2016/10/17.
 */
define(function(require, exports, module){

    function addMenu(){
       $("#addMenuForm").valid();
    }

    function addFormValidate(){
        $("#addMenuForm").validate({
            rules:{
                menuName:{required:true},
                menuUrl: {
                    minlength: 2,
                    required: true
                }
            },
            errorElement: 'span', //default input error message container
            errorClass: 'help-block help-block-error', // default input error message class
            highlight: function(element) { // hightlight error inputs
                $(element)
                    .closest("div[class^='col']").addClass('has-error').removeClass( "has-success" );; // set error class to the control group
            },

            unhighlight: function(element) { // revert the change done by hightlight
                $(element)
                    .closest("div[class^='col']").addClass( "has-success" ).removeClass('has-error'); // set error class to the control group
            },
            success: function(label) {
                label
                    .closest("div[class^='col']").removeClass('has-error'); // set success class to the control group
            }
        });
    }

    function bindEvent(){
        $("#addMenuOk").click(function(){
            addMenu();
        });
    }

    module.exports = {
        init:function(){
            $(document).ready(function() {
                addFormValidate();
                bindEvent();
            });

        }
    }

});
