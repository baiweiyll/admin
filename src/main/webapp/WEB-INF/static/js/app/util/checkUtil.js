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
        }
    }
});
