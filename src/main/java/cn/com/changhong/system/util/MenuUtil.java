package cn.com.changhong.system.util;

import cn.com.changhong.common.Constants;
import cn.com.changhong.system.model.Menu;

import java.util.List;

/**
 * 菜单工具类<p>
 * 项目 : admin<p>
 * 类名 : cn.com.changhong.system.util.MenuUtil<p>
 * 时间 : 2016/10/10 11:42<p>
 *
 * @author <a href="mailto:wei.bai@changhong.com">白伟</a>
 */
public class MenuUtil {

    private MenuUtil(){}

    public static void sortTreeTable(List<Menu> list, List<Menu> sourcelist,String parentId){
        for (Menu menu : sourcelist) {
            String menuParentId = menu.getParentId();
            if (null != menuParentId && menuParentId.equals(parentId)) {
                list.add(menu);
                // 判断是否还有子节点, 有则继续获取子节点
                for (Menu child : sourcelist) {
                    String childParentId = child.getParentId();
                    if (null != childParentId && childParentId.equals(menu.getId())) {
                        sortTreeTable(list,sourcelist,menu.getId());
                        break;
                    }
                }
            }
        }
    }

}
