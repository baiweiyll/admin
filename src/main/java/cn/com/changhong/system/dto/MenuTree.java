package cn.com.changhong.system.dto;

import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 功能描述<p>
 * 项目 : admin<p>
 * 类名 : cn.com.changhong.system.dto.MenuTree<p>
 * 时间 : 2016/9/27 15:09<p>
 *
 * @author <a href="mailto:wei.bai@changhong.com">白伟</a>
 */
public class MenuTree implements Serializable{

    private StringBuffer html = new StringBuffer();
    private List<MenuDto> menus;

    public MenuTree(List<MenuDto> menus) {
        this.menus = menus;
    }

    public String buildTree(){
        for (MenuDto menu:menus) {
            //根节点判断
            if (StringUtils.isBlank(menu.getParentId())) {
                //无孩子节点

                html.append("<li class=\"nav-item\">");
                if (StringUtils.isNotBlank(menu.getHref())) {
                    html.append("<a href='"+menu.getHref()+"' class='nav-link"+(StringUtils.isBlank(menu.getChidId())?"":" nav-toggle")+"'>");
                } else {
                    html.append("<a class='nav-link"+(StringUtils.isBlank(menu.getChidId())?"":" nav-toggle")+"'>");
                }
                html.append("<i class=\""+menu.getIcon()+"\"></i>");
                html.append("<span class=\"title\"> "+menu.getName()+"</span>");

                if (!StringUtils.isBlank(menu.getChidId())){
                    html.append(" <span class=\"arrow \"></span>");
                }
                html.append("</a>");
                build(menu);
                html.append("</li>");
            }
        }
        return html.toString();
    }

    public void build(MenuDto menu) {
        List<MenuDto> children = getChildren(menu);
        if (!children.isEmpty()) {
            html.append("<ul class=\"sub-menu\">");
            for (MenuDto child : children) {
                if (StringUtils.isNotBlank(child.getChidId())) {
                    html.append("<li class=\"nav-item\">");
                    if (StringUtils.isNotBlank(child.getHref())) {
                        html.append("<a href=\""+child.getHref()+"\" class=\"nav-link nav-toggle\">");
                    } else {
                        html.append("<a href=\"javascript:;\" class=\"nav-link nav-toggle\">");
                    }
                    html.append("<i class=\""+child.getIcon()+"\"></i>");
                    html.append("<span class=\"title\"> "+child.getName()+"</span>");
                    html.append(" <span class=\"arrow \"></span>");
                    html.append("</a>");
                    build(child);
                } else {
                    html.append("<li class=\"nav-item\">");
                    if (StringUtils.isNotBlank(child.getHref())) {
                        html.append("<a href=\""+child.getHref()+"\" class=\"nav-link\">");
                    } else {
                        html.append("<a href=\"javascript:;\" class=\"nav-link\">");
                    }
                    html.append("<i class=\""+child.getIcon()+"\"></i>");
                    html.append("<span class=\"title\"> "+child.getName()+"</span>");
                    html.append("</a>");
                    html.append("</li>");
                }
            }
            html.append("</ul>");
        }
    }

    private List<MenuDto> getChildren(MenuDto menu) {
        List<MenuDto> children = new ArrayList<MenuDto>();
        String id = menu.getId();
        for (MenuDto m : menus) {
            if (id.equalsIgnoreCase(m.getParentId())) {
                children.add(m);
            }
        }
        return  children;
    }


}
