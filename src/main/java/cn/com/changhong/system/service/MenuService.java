package cn.com.changhong.system.service;

import cn.com.changhong.common.service.BaseService;
import cn.com.changhong.system.dto.JsTree;
import cn.com.changhong.system.model.Menu;
import com.alibaba.fastjson.JSONObject;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * 功能菜单服务接口<p>
 * 项目 : admin<p>
 * 类名 : cn.com.changhong.system.service.MenuService<p>
 * 时间 : 2016/9/20 15:59<p>
 *
 * @author <a href="mailto:wei.bai@changhong.com">白伟</a>
 */
public interface MenuService extends BaseService<Menu>{

    public String getMenuByUserId(String userId);

    public List<Menu> getTreeTable();

    public List<JsTree> getJsTree();

    public ResponseEntity<JSONObject> delMenu(String menuId);

    public ResponseEntity<JSONObject> addOrUpdate(Menu menu);

}
