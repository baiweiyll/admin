package cn.com.changhong.system.controller;

import cn.com.changhong.system.dto.JsTree;
import cn.com.changhong.system.model.Menu;
import cn.com.changhong.system.service.MenuService;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

/**
 * 功能描述<p>
 * 项目 : admin<p>
 * 类名 : cn.com.changhong.system.controller.MenuController<p>
 * 时间 : 2016/9/23 13:35<p>
 *
 * @author <a href="mailto:wei.bai@changhong.com">白伟</a>
 */
@Controller
@RequestMapping("/sys")
public class MenuController {

    @Autowired
    MenuService menuService;

    @RequestMapping(value = "layout",method = RequestMethod.GET)
    public String layout(Model model){
        model.addAttribute("menus",menuService.getMenuByUserId("4a5f7522-8478-11e6-b3c3-005056b14ad6"));
        return "layout/layout";
    }

    @RequestMapping(value = "menu",method = RequestMethod.GET)
    public String menu(Model model){
        model.addAttribute("menus",menuService.getTreeTable());
        return "system/menuList";
    }

    @RequestMapping(value = "menu/tree",method = RequestMethod.GET)
    public String menuTree( String menuId,Model model){
        model.addAttribute("selectMenuId",menuId);
        return "system/menuTree";
    }

    @RequestMapping(value = "addMenuView",method = RequestMethod.GET)
    public String addMenuView(String menuId,Model model){
        if (StringUtils.isNotBlank(menuId)) {
            Menu menu = menuService.selectByPrimaryKey(menuId);
            if (null != menu) {
                if (StringUtils.isBlank(menu.getParentId())) {
                    menu.setParentId("");
                    menu.setRemarks("根节点");
                } else {
                    Menu p = menuService.selectByPrimaryKey(menu.getParentId());
                    if (null != p) {
                        menu.setRemarks(p.getName());
                    }
                }
                model.addAttribute("menu",menu);
            }
        }
        return "system/addMenu";
    }

    @RequestMapping(value = "addMenu",method = RequestMethod.POST)
    public @ResponseBody ResponseEntity<JSONObject> addMenu(Menu menu){
        return menuService.addOrUpdate(menu);
    }

    @RequestMapping(value = "delMenu",method = RequestMethod.GET)
    public @ResponseBody ResponseEntity<JSONObject> delMenu(@RequestParam(name="menuId") String menuId){
        return menuService.delMenu(menuId);
    }

    @RequestMapping(value = "jstree",method = RequestMethod.GET)
    public @ResponseBody  List<JsTree> getJsTree(){
        return menuService.getJsTree();
    }

    @RequestMapping(value = "validMenuParent",method = RequestMethod.POST)
    public @ResponseBody Boolean validMenuParent( String menuId,String parentId){
        if (StringUtils.isBlank(menuId)) {
            return true;
        }
        Menu condition = new Menu();
        condition.setId(parentId);
        condition.setParentId(menuId);
        if (menuService.selectCount(condition) > 0) {
            return false;
        }
        return true;
    }

}
