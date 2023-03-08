package com.li.furn.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 李
 * @version 1.0
 * 用来返回给前端Json数据的通用类
 */
public class Msg {
    //状态码 200-成功 , 400-失败
    private int code;
    //信息-对返回的数据的说明
    private String msg;
    //返回给浏览器的数据-Map集合
    private Map<String, Object> extend = new HashMap<>();

    //几个常用的方法-封装好msg

    //返回一个success的 msg说明
    public static Msg success() {
        Msg msg = new Msg();
        msg.setCode(200);
        msg.setMsg("success");
        return msg;
    }

    //返回一个fail的 msg说明
    public static Msg fail() {
        Msg msg = new Msg();
        msg.setCode(400);
        msg.setMsg("fail");
        return msg;
    }

    //给返回的msg设置数据
    public Msg add(String key, Object value) {
        extend.put(key, value);
        return this;//返回的是当前Msg对象
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Map<String, Object> getExtend() {
        return extend;
    }

    public void setExtend(Map<String, Object> extend) {
        this.extend = extend;
    }
}
