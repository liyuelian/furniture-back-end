package com.li.furn.controller;

import com.li.furn.bean.Furn;
import com.li.furn.bean.Msg;
import com.li.furn.service.FurnService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 李
 * @version 1.0
 */
@Controller//由springmvc来处理
public class FurnController {
    @Resource
    private FurnService furnService;

    /**
     * 1.响应客户端添加家居的请求
     * 2.@RequestBody 注解将客户端提交的json数据封装成 Javabean 对象。
     * 3.@ResponseBody 服务器返回的数据是按照json来返回的（底层是按照 http协议进行协商）
     *
     * @param furn
     * @return
     */
    @ResponseBody
    @PostMapping("/save")
    public Msg save(@RequestBody Furn furn) {
        furnService.save(furn);
        //如果没有出现异常，就返回成功
        Msg success = Msg.success();
        return success;
    }

    @RequestMapping("/furns")
    @ResponseBody
    public Msg listFurns() {
        List<Furn> furnList = furnService.findAll();
        //将数据封装到 Meg对象中返回
        Msg msg = Msg.success();
        msg.add("furnList", furnList);
        return msg;
    }

    @PutMapping("/update")
    @ResponseBody
    public Msg update(@RequestBody Furn furn) {
        furnService.update(furn);
        return Msg.success();
    }

    @DeleteMapping("/del/{id}")
    @ResponseBody
    public Msg del(@PathVariable Integer id) {
        furnService.del(id);
        return Msg.success();
    }
}
