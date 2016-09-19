package cn.com.changhong.common.service.impl;


import cn.com.changhong.common.custom.CustomerMapper;
import cn.com.changhong.common.service.BaseService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 
 * 通用服务基类实现<p>
 * 项目:chop-api<p>
 * 类名:cn.com.changhong.common.service.impl.BaseServiceImpl.java<p>
 * 创建时间:2016年7月18日下午3:10:22<p>
 * @author <a href="mailto:wei.bai@changhong.com">白伟</a>
 * @see BaseServiceImpl
 *
 */
public abstract class BaseServiceImpl<T>  implements BaseService<T> {

    @Autowired
    protected CustomerMapper<T> mapper;
    
    public PageInfo<T> selectByPage(int pageNum,int pageSize){
        PageHelper.startPage(pageNum, pageSize);
        PageInfo<T> page = new PageInfo<>(mapper.selectAll());
        return page;
    }
    
    public PageInfo<T> selectByPage(T record,int pageNum,int pageSize){
        PageHelper.startPage(pageNum, pageSize);
        PageInfo<T> page = new PageInfo<>(mapper.select(record));
        return page;
    }
    
    
    public PageInfo<T> selectByExampleAndPage(Object example, int pageNum, int pageSize){
        PageHelper.startPage(pageNum, pageSize);
        PageInfo<T> page = new PageInfo<>(mapper.selectByExample(example));
        return page;
    }
    
    public List<T> selectAll(){
    	return mapper.selectAll();
    }
    
    public List<T> selectByExample(Object example){
    	return mapper.selectByExample(example);
    }
    
    public int insert(T record){
    	return mapper.insert(record);
    }
    
    public int insertSelective(T record){
    	return mapper.insertSelective(record);
    }
    
    public T selectOne(T record){
    	return mapper.selectOne(record);
    }
    
    public T selectByPrimaryKey(Object key){
    	return mapper.selectByPrimaryKey(key);
    }
    
    public int updateByPrimaryKeySelective(T record){
    	return mapper.updateByPrimaryKeySelective(record);
    }
    
    public int updateByExampleSelective(T record,Object example){
    	return mapper.updateByExampleSelective(record, example);
    }
    
    public int selectCount(T record){
    	return mapper.selectCount(record);
    }
    
    public int selectCountByExample(Object example){
    	return mapper.selectCountByExample(example);
    }
    
    
}
