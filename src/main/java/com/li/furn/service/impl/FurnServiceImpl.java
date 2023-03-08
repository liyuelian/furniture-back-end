package com.li.furn.service.impl;

import com.li.furn.bean.Furn;
import com.li.furn.dao.FurnMapper;
import com.li.furn.service.FurnService;
import org.springframework.stereotype.Service;

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
}
