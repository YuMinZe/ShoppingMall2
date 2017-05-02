package com.hxzs.mall.fragment.homefragment.bean;

/**
 * 1. 类的用途
 * 2. @author $Yuminze
 * 3. @date 2017/5/2 14:07
 */
public class EvenBusBean {
    private String name;
    private String images;
    private String price;

    public EvenBusBean(String name, String images, String price) {
        this.name = name;
        this.images = images;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getImages() {
        return images;
    }

    public String getPrice() {
        return price;
    }
}
