package com.li.furn.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.li.furn.bean.Furn;
import com.li.furn.bean.Msg;
import com.li.furn.service.FurnService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
     * 4.@Validated 对接收的信息进行校验
     * 5.Errors用来接收校验可能出现的错误信息
     *
     * @param furn
     * @return
     */
    @ResponseBody
    @PostMapping("/save")
    public Msg save(@Validated @RequestBody Furn furn, Errors errors) {
        Map<Object, Object> map = new HashMap<>();

        List<FieldError> fieldErrors = errors.getFieldErrors();

        for (FieldError fieldError : fieldErrors) {
            map.put(fieldError.getField(), fieldError.getDefaultMessage());
        }

        if (map.isEmpty()) {//说明后端校验没有出现错误
            furnService.save(furn);
            //如果没有出现异常，就返回成功
            return Msg.success();
        } else {
            //校验失败，将校验错误信息封装到Msg对象，并返回
            return Msg.fail().add("errorMsg", map);
        }
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

    //根据id返回对应的furn对象
    @GetMapping("/find/{id}")
    @ResponseBody
    public Msg findById(@PathVariable Integer id) {
        Furn furn = furnService.findById(id);
        return Msg.success().add("furn", furn);
    }

    /**
     * 分页请求接口
     *
     * @param pageNum  要显示第几页
     * @param pageSize 每一页显示的记录数
     * @return
     * @RequestParam 设置参数默认值
     */
    @ResponseBody
    @RequestMapping("/furnsByPage")
    public Msg listFurnsByPage(@RequestParam(defaultValue = "1") Integer pageNum,
                               @RequestParam(defaultValue = "5") Integer pageSize) {
        //一、设置分页参数
        //1.调用findAll完成查询，底层会进行物理分页，而不是逻辑分页
        //2.也就是说会根据分页参数来计算limit ?,? 在发出sql语句时会带上limit
        PageHelper.startPage(pageNum, pageSize);
        List<Furn> furnList = furnService.findAll();
        //二、将分页查询的结果封装到PageInfo对象中
        //PageInfo对象包含了分页的各种信息，比如当前页数，每页的记录数，共有多少记录等等
        PageInfo pageInfo = new PageInfo(furnList, pageSize);
        //三、将PageInfo封装到Msg对象并返回
        return Msg.success().add("pageInfo", pageInfo);
    }

    /**
     * 根据家居名进行分页查询-条件
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping("/furnsByConditionPage")
    @ResponseBody
    public Msg listFurnsByConditionPage(
            @RequestParam(defaultValue = "1") Integer pageNum,
            @RequestParam(defaultValue = "5") Integer pageSize,
            @RequestParam(defaultValue = "") String search) {
        PageHelper.startPage(pageNum, pageSize);
        List<Furn> furnList = furnService.findByCondition(search);
        PageInfo pageInfo = new PageInfo(furnList, pageSize);
        return Msg.success().add("pageInfo", pageInfo);
    }
}
