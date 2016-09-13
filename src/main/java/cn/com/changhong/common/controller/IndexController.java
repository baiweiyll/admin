package cn.com.changhong.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 功能描述<p>
 * 项目 : admin<p>
 * 类名 : cn.com.changhong.common.controller.IndexController<p>
 * 时间 : 2016/8/30 15:56<p>
 *
 * @author <a href="mailto:wei.bai@changhong.com">白伟</a>
 */
@Controller
public class IndexController {

    @RequestMapping(value = "index",method = RequestMethod.GET)
    public String index(){
        return "index";
    }
}
