package cn.com.changhong.system.service.impl;

import cn.com.changhong.common.Constants;
import cn.com.changhong.common.service.impl.BaseServiceImpl;
import cn.com.changhong.common.util.ResponseUtil;
import cn.com.changhong.system.dto.JsTree;
import cn.com.changhong.system.dto.MenuDto;
import cn.com.changhong.system.dto.MenuTree;
import cn.com.changhong.system.mapper.MenuMapper;
import cn.com.changhong.system.mapper.RoleMenuMapper;
import cn.com.changhong.system.model.Menu;
import cn.com.changhong.system.model.RoleMenu;
import cn.com.changhong.system.service.MenuService;
import cn.com.changhong.system.service.RoleMenuService;
import cn.com.changhong.system.util.MenuUtil;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

/**
 * 功能菜单服务实现类<p>
 * 项目 : admin<p>
 * 类名 : cn.com.changhong.system.service.impl.MenuServiceImpl<p>
 * 时间 : 2016/9/20 16:01<p>
 *
 * @author <a href="mailto:wei.bai@changhong.com">白伟</a>
 */
@Service
public class MenuServiceImpl extends BaseServiceImpl<Menu> implements MenuService {

    @Autowired
    MenuMapper menuMapper;

    @Autowired
    RoleMenuService roleMenuService;

    @Override
    public String getMenuByUserId(String userId) {
        List<MenuDto> menus = menuMapper.getMenuByUserId(userId);
        MenuTree mt = new MenuTree(menus);
        return mt.buildTree();
    }

    @Override
    public List<Menu> getTreeTable() {
        Example example = new Example(Menu.class);
        example.orderBy("sort").asc();
        List<Menu> menus = super.selectByExample(example);
        List<Menu> list = new ArrayList<>();
        MenuUtil.sortTreeTable(list,menus, Constants.TREE_ROOT_ID);
        return list;
    }

    @Override
    public List<JsTree> getJsTree() {
        Example example = new Example(Menu.class);
        example.orderBy("sort").desc();
        List<Menu> list = super.selectByExample(example);
        List<JsTree> result = new ArrayList<JsTree>();
        JsTree root = new JsTree();
        result.add(root);
        for (Menu menu:list) {
            result.add(new JsTree(menu));
        }
        return result;
    }

    @Override
    public ResponseEntity<JSONObject> delMenu(String menuId) {
        //检查父子关系
        Menu condition = new Menu();
        condition.setParentId(menuId);
        int count = selectCount(condition);
        if (count > 0) {
            return ResponseUtil.badRequest("请先删除子菜单");
        }
        //检查与角色关联关系
        RoleMenu rm = new RoleMenu();
        rm.setMenuId(menuId);
        if (roleMenuService.selectCount(rm) > 0) {
            return ResponseUtil.badRequest("菜单已与角色关联，不能删除");
        }
        deleteByPrimaryKey(menuId);
        return ResponseUtil.ok();
    }

}
