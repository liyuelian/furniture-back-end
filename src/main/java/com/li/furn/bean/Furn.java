package com.li.furn.bean;

import org.springframework.util.StringUtils;

import java.math.BigDecimal;

public class Furn {
    private Integer id;

    private String name;

    private String maker;

    private BigDecimal price;

    private Integer sales;

    private Integer stock;

    private String imgPath = "/assets/images/product-image/1.jpg";

    //声明无参构造器
    public Furn() {
    }

    //增加一个全参构造器
    public Furn(Integer id, String name, String maker, BigDecimal price,
                Integer sales, Integer stock, String imgPath) {
        this.id = id;
        this.name = name;
        this.maker = maker;
        this.price = price;
        this.sales = sales;
        this.stock = stock;
        //如果新的家具信息的图片不为空，或者不为空串时，就设置，否则为默认值
        //imgPath != null && !imgPath.equals("")
        // =>使用StringUtils.hasText()代替
        if (StringUtils.hasText(imgPath)) {
            this.imgPath = imgPath;
        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getMaker() {
        return maker;
    }

    public void setMaker(String maker) {
        this.maker = maker == null ? null : maker.trim();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getSales() {
        return sales;
    }

    public void setSales(Integer sales) {
        this.sales = sales;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath == null ? null : imgPath.trim();
    }
}