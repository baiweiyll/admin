/**
 * Created by baiwei on 2016/10/13.
 */
define(function(require, exports, module) {

    var check = require("util/checkUtil");

    /**
     * 框架中间板块内容加载
     * @param url
     */
    function loadMainContent(current,callback){
        var loadUrl = $(current).attr('href');
        var menuId = $(current).attr('id');
        if (!check.isNull(loadUrl)) {
            HoldOn.open();
            //  $("#test").LoadingOverlay("show");
            $("#maincontent").load(basePath + loadUrl,null,function(response,status,xhr){
                HoldOn.close();
                if ("success" == status) {
                    //修改pageBar内容
                    updatePagebar(current);

                    $("#menu > li.active").removeClass("active");
                    activeMenu(current);
                    $("#currentMenuId").val(menuId);
                }
                (callback && typeof(callback) === "function") && callback();
                //$("#test").LoadingOverlay("hide");
            });

        }
    }

    /**
     * 选中菜单上色
     * @param currentDom
     */
    function activeMenu(currentDom){
        var pDom = $(currentDom).parent();
        if (pDom && pDom.hasClass("page-sidebar-menu")) {
            $(currentDom).addClass("active");
            //无孩子节点
            if (!currentDom.hasClass("open")) {
                $("#menu > li.open").children('a').children('.arrow').removeClass('open');
                $("#menu > li.open").children('.sub-menu:not(.always-open)').slideUp(200);
                $("#menu > li.open").removeClass('open');
            }
        } else {
            activeMenu(pDom);
        }
    }

    /**
     * 面包削修改
     * @param menu
     */
    function updatePagebar(menu){
        var pageBarHtml='';
        var menus = $(menu).parents('li');
        if (menus){
            var menuSize = menus.size();
            for(var i= menuSize,menu;i;){
                menu = menus[--i];
                var menuName = $(menu).children('a').children('span.title').text();
                pageBarHtml = pageBarHtml + '<li><span>' + menuName + '</span>';
                if (i) {
                    pageBarHtml = pageBarHtml + '<i class="fa  fa-long-arrow-right"></i>';
                }
                pageBarHtml = pageBarHtml + '</li>';
            }
            $("#pageBar").html(pageBarHtml);
        }
    }

    /**
     * 页面导航绑定点击事件
     */
    function bindEvent(){
        $("a[class=nav-link]").click(function(event){
            event.preventDefault();
            loadMainContent(this);

        });
    }

    function ajaxDefaultSet(){
        $.ajaxSetup({
            error:check.ajaxError
        });
    }
    module.exports = {
        refresh:function(callback){
            var currentMenuId = $('#currentMenuId').val();
           // $('#'+currentMenuId).trigger('click');
            loadMainContent($('#'+currentMenuId),callback);
        },
        init:function(){
            ajaxDefaultSet();
            bindEvent();
            //加载首页
            loadMainContent($("#index"));
        }
    }

});
