package cn.com.changhong.common.custom;


import tk.mybatis.mapper.common.BaseMapper;
import tk.mybatis.mapper.common.ExampleMapper;


/**
 * 
 * 项目自定义通用mapper<p>
 * 项目:admin<p>
 * 类名:cn.com.changhong.common.CustomerMapper.java<p>
 * 创建时间:2016年7月18日下午3:13:22<p>
 * @author <a href="mailto:wei.bai@changhong.com">白伟</a>
 * @see CustomerMapper
 *
 */
public interface CustomerMapper<T> extends BaseMapper<T>, ExampleMapper<T>{

}
