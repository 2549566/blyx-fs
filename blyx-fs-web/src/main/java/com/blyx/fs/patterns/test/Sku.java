package com.blyx.fs.patterns.test;

import lombok.Data;

/**
 * @author quyang5
 * @description
 * @date 15:53 2021/1/13
 */
@Data
public class Sku {

    private String name;

    private Boolean hasStock;

    private Boolean hasCoupon;

    private Boolean hasCanBuy;

    public Sku(String name,Boolean hasStock,Boolean hasCoupon,Boolean hasCanBuy){
        this.name=name;
        this.hasStock=hasStock;
        this.hasCoupon=hasCoupon;
        this.hasCanBuy=hasCanBuy;
    }
}
