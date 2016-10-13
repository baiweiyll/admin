/**
 * Created by baiwei on 2016/10/13.
 */
define(function(require, exports, module) {

    module.exports = {
        init:function(){
            //collapsed expanded
            $("#treeTable").treetable({ initialState:"collapsed",expandable: true});
        }
    }
});