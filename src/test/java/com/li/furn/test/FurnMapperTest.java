package com.li.furn.test;

import com.li.furn.bean.Furn;
import com.li.furn.dao.FurnMapper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.math.BigDecimal;

/**
 * @author 李
 * @version 1.0
 */
public class FurnMapperTest {
    @Test
    public void insertSelective() {
        //初始化spring容器
        ApplicationContext ioc =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        //获取到 FurnMapper的代理对象(类型=class com.sun.proxy.$Proxy17)
        FurnMapper furnMapper = ioc.getBean(FurnMapper.class);
        //添加数据
        Furn furn = new Furn(null, "小电灯", "一等家居",
                new BigDecimal(66), 123, 45,
                "/assets/images/product-image/1.jpg");
        int affected = furnMapper.insertSelective(furn);
        System.out.println("操作影响行数=" + affected + ",操作成功!");
    }

    @Test
    public void deleteByPrimaryKey() {
        ApplicationContext ioc =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        FurnMapper furnMapper = ioc.getBean(FurnMapper.class);
        int affected = furnMapper.deleteByPrimaryKey(6);
        System.out.println("操作影响行数=" + affected + ",操作成功!");
    }
}
