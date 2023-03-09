package com.li.furn.service;

import com.li.furn.bean.Furn;

import java.util.List;

/**
 * @author 李
 * @version 1.0
 */
public interface FurnService {
    //添加
    public void save(Furn furn);
    //查询所有的家居信息
    public List<Furn> findAll();
    //修改家居信息
    public void update(Furn furn);
    //删除家居信息
    public void del(Integer id);
}
