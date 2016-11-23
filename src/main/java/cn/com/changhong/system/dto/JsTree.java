package cn.com.changhong.system.dto;

import cn.com.changhong.system.model.Menu;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;

/**
 * 功能描述<p>
 * 项目 : admin<p>
 * 类名 : cn.com.changhong.system.dto.JsTree<p>
 * 时间 : 2016/10/29 14:59<p>
 *
 * @author <a href="mailto:wei.bai@changhong.com">白伟</a>
 */
public class JsTree implements Serializable{


    public JsTree() {
        this.id = "-1";
        this.parent = "#";
        this.text = "根节点";
        this.icon = "icon-settings";
    }

    public JsTree(Menu menu) {
        if (null != menu) {
            setId(menu.getId());
            setText(menu.getName());
            setIcon(menu.getIcon());
            if (StringUtils.isBlank(menu.getParentId())) {
                setParent("#");
            } else {
                setParent(menu.getParentId());
            }
        }
    }

    private String id;

    private String text;

    private String icon;

    private String parent;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }
}
