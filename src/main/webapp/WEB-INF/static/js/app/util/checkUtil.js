/**
 * Created by baiwei on 2016/10/13.
 */
define(function(require, exports, module) {
    module.exports = {

        /**
         * 判断是否为空
         * @param obj
         * @returns {boolean}
         */
        isNull:function(obj){
            if (obj && obj.length > 0){
                return false;
            }
            return true;
        },
        getQueryString:function(name){
            var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)","i");
            var r = window.location.search.substr(1).match(reg);
            if (r!=null) return (decodeURIComponent(r[2])); return null;
        },
        ajaxError:function(xhr, textStatus, errorThrown){

            console.log(errorThrown);
            var result = {};
            try{
                result = jQuery.parseJSON(xhr.responseText);
            }catch(e){console.log(e);}
            console.log(textStatus);
            console.log(xhr);
            switch (xhr.status) {
                case 100:break;
                case 200:break;
                case 201:break;
                case 202:break;
                case 203:break;
                case 204:break;
                // In case of error it sends an error message to `callbackError`.
                case 400:
                        if (result && result.errorMsg) {
                            toastr.error(result.errorMsg);
                        } else {
                            toastr.error("错误的请求");
                        }

                    break;
                case 401:
                        if (result && result.errorMsg) {
                            toastr.error(result.errorMsg);
                        } else {
                            toastr.error("请求未授权");
                        }

                    break;
                case 403:
                        if (result && result.errorMsg) {
                            toastr.error(result.errorMsg);
                        } else {
                            toastr.error("请求被禁止");
                        }
                    break;
                case 404:
                        if (result && result.errorMsg) {
                            toastr.error(result.errorMsg);
                        } else {
                            toastr.error("资源不存在");
                        }

                    break;
                case 405:
                    break;
                case 409:

                    break;
                case 413:

                    break;
                case 422:


                    break;
                case 500:
                        if (result && result.errorMsg) {
                            toastr.error(result.errorMsg);
                        } else {
                            toastr.error("系统错误");
                        }

                    break;
                default:
                    toastr.error("请求错误");
            }
            return false;

        }
    }
});
