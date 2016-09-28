package cn.com.changhong.system.service.impl;

import cn.com.changhong.common.service.impl.BaseServiceImpl;
import cn.com.changhong.system.dto.MenuDto;
import cn.com.changhong.system.dto.MenuTree;
import cn.com.changhong.system.mapper.MenuMapper;
import cn.com.changhong.system.model.Menu;
import cn.com.changhong.system.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Override
    public String getMenuByUserId(String userId) {
        List<MenuDto> menus = menuMapper.getMenuByUserId(userId);
        MenuTree mt = new MenuTree(menus);
        return mt.buildTree();
    }

}
