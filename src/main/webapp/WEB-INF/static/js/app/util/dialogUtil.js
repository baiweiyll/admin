/**
 * Created by baiwei on 2016/10/20.
 */
define(function(require, exports, module) {

    function showConfirm(title,text,type,callback){
        swal({
                title: title,
                text: text,
                type: type,
                showCancelButton: true,
                confirmButtonClass: "btn-success",
                confirmButtonText: "确定",
                cancelButtonText:"取消",
                closeOnConfirm: false },
            callback
        );
    }
    module.exports = {
        showWarningConfirm:function(title,text,callback){
            showConfirm(title,text,"warning",callback);
        }
    }
});