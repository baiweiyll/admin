package cn.com.changhong.common.util;

import com.alibaba.fastjson.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * 功能描述<p>
 * 项目 : admin<p>
 * 类名 : cn.com.changhong.common.util.ResponseUtil<p>
 * 时间 : 2016/11/24 10:03<p>
 *
 * @author <a href="mailto:wei.bai@changhong.com">白伟</a>
 */
public class ResponseUtil {

    //bw test
    public static final String ERROR_MESSAGE_KEY = "errorMsg";

    private ResponseUtil(){}

    public static ResponseEntity<JSONObject> badRequest(String msg){
        JSONObject json = new JSONObject();
        json.put(ERROR_MESSAGE_KEY,msg);
        return ResponseEntity.badRequest().body(json);
    }

    public static ResponseEntity<JSONObject> notFound(String msg){
        JSONObject json = new JSONObject();
        json.put(ERROR_MESSAGE_KEY,msg);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(json);
    }

    public static ResponseEntity<JSONObject> ok(){
        return ResponseEntity.ok(new JSONObject());
    }
}
