package cn.com.changhong.system.mapper;

import cn.com.changhong.common.custom.CustomerMapper;
import cn.com.changhong.system.dto.MenuDto;
import cn.com.changhong.system.model.Menu;

import java.util.List;

public interface MenuMapper extends CustomerMapper<Menu> {

    public List<MenuDto> getMenuByUserId(String userId);
}