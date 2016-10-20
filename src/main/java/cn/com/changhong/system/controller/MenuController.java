package cn.com.changhong.system.controller;

import cn.com.changhong.system.model.Menu;
import cn.com.changhong.system.service.MenuService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
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

    @RequestMapping(value = "addMenuView",method = RequestMethod.GET)
    public String addMenuView(){
        return "system/addMenu";
    }

    @RequestMapping(value = "addMenu",method = RequestMethod.POST)
    public @ResponseBody JSONObject addMenu(Menu menu){
        menu.setCreateBy("admin");
        menu.setCreateDate(new Date());
        menuService.insert(menu);
        return new JSONObject();
    }

    @RequestMapping(value = "delMenu",method = RequestMethod.GET)
    public @ResponseBody JSONObject delMenu(@RequestParam(name="menuId") String menuId){
        menuService.deleteByPrimaryKey(menuId);
        return new JSONObject();
    }

}
