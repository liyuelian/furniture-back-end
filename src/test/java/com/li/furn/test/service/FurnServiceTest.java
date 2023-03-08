package com.li.furn.test.service;

import com.li.furn.bean.Furn;
import com.li.furn.service.FurnService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author 李
 * @version 1.0
 */
public class FurnServiceTest {
    //spring容器
    private ApplicationContext ioc;
    //从spring容器中获取的是FurnService接口的代理对象
    private FurnService furnService;

    @Before
    public void init() {
        ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
        //通过FurnService.class类型获取FurnService接口对象的代理对象
        furnService = ioc.getBean(FurnService.class);
    }

    @Test
    public void FurnServiceTest() {
        //添加数据
        Furn furn = new Furn(null, "复古沙发", "森林之家",
                new BigDecimal(1088), 12, 28,
                "/assets/images/product-image/7.jpg");
        furnService.save(furn);
        System.out.println("添加成功");
        //关闭sqlSession的动作底层会自动释放
    }

    @Test
    public void findAll() {
        List<Furn> all = furnService.findAll();
        for (Furn furn : all) {
            System.out.println("furn=" + furn);
        }
    }
}
