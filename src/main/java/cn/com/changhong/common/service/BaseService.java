package cn.com.changhong.common.service;

import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 *
 * 通用服务基类接口<p>
 * 项目:admin <p>
 * 类名: cn.com.changhong.common.service.BaseService.java<p>
 * 创建时间:2016年7月18日下午3:10:44<p>
 * @author <a href="mailto:wei.bai@changhong.com">白伟</a>
 * @see BaseService
 *
 */
public interface BaseService<T>
{
    public PageInfo<T> selectByPage(int pageNum, int pageSize);
    
    public PageInfo<T> selectByPage(T record, int pageNum, int pageSize);
    
    public PageInfo<T> selectByExampleAndPage(Object example, int pageNum, int pageSize);
    
    public List<T> selectAll();
    
    public List<T> selectByExample(Object example);
    
    public int insert(T record);
    
    public int insertSelective(T record);
    
    public T selectOne(T record);
    
    public T selectByPrimaryKey(Object key);
    
    public int updateByPrimaryKeySelective(T record);
    
    public int updateByExampleSelective(T record, Object example);
    
    public int selectCount(T record);
    
    public int selectCountByExample(Object example);

    public int deleteByPrimaryKey(Object key);

    public int delete(T record);

    public int deleteByExample(Object example);
}
