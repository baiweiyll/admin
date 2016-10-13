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
        }
    }
});
