package com.li.furn.service.impl;

import com.li.furn.bean.Furn;
import com.li.furn.bean.FurnExample;
import com.li.furn.dao.FurnMapper;
import com.li.furn.service.FurnService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 李
 * @version 1.0
 */
@Service
public class FurnServiceImpl implements FurnService {
    //自动装配 FurnMapper接口对象（代理对象）
    @Resource
    private FurnMapper furnMapper;

    //已经在spring配置文件中开启事务
    @Override
    public void save(Furn furn) {
        furnMapper.insertSelective(furn);
    }

    @Override
    public List<Furn> findAll() {
        //如果传入为null表示返回所有的家居信息
        return furnMapper.selectByExample(null);
    }

    @Override
    public void update(Furn furn) {
        //如果furn的某个属性不为null就进行修改
        furnMapper.updateByPrimaryKeySelective(furn);
    }

    @Override
    public void del(Integer id) {
        furnMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Furn findById(Integer id) {
        return furnMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Furn> findByCondition(String name) {
        FurnExample furnExample = new FurnExample();
        //通过criteria对象可以设置查询条件
        FurnExample.Criteria criteria = furnExample.createCriteria();
        //先判断name是否有具体的内容
        if (StringUtils.hasText(name)) {
            criteria.andNameLike("%" + name + "%");
        }
        //如果name没有
        return furnMapper.selectByExample(furnExample);
    }
}
