package com.li.furn.bean;

import org.hibernate.validator.constraints.Range;
import org.springframework.util.StringUtils;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class Furn {
    private Integer id;

    @NotEmpty(message = "请输入家居名")
    private String name;

    @NotEmpty(message = "请输入厂商名")
    private String maker;

    @NotNull(message = "请输入价格")
    @Range(min = 0,message = "价格不能小于0")
    private BigDecimal price;

    @NotNull(message = "请输入销量")
    @Range(min = 0,message = "销量不能小于0")
    private Integer sales;

    @NotNull(message = "请输入库存")
    @Range(min = 0,message = "库存不能小于0")
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