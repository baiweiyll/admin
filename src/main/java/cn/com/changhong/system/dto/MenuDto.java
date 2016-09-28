package cn.com.changhong.system.dto;

import cn.com.changhong.system.model.Menu;

/**
 * 功能描述<p>
 * 项目 : admin<p>
 * 类名 : cn.com.changhong.system.dto.MenuDto<p>
 * 时间 : 2016/9/27 17:21<p>
 *
 * @author <a href="mailto:wei.bai@changhong.com">白伟</a>
 */
public class MenuDto extends Menu {

    private String chidId;

    public String getChidId() {
        return chidId;
    }

    public void setChidId(String chidId) {
        this.chidId = chidId;
    }

}
