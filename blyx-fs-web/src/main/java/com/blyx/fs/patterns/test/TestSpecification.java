package com.blyx.fs.patterns.test;

import com.blyx.fs.patterns.specification.ISpecification;
import com.blyx.fs.patterns.specification.impl.biz.HasCanBuySpecification;
import com.blyx.fs.patterns.specification.impl.biz.HasCouponpecification;
import com.blyx.fs.patterns.specification.impl.biz.HasStockSpecification;

import java.util.ArrayList;
import java.util.List;

/**
 * @author quyang5
 * @description
 * @date 15:53 2021/1/13
 */
public class TestSpecification {

    public static void main(String[] args) {
        Sku dingjinquan=new Sku("dingjinquan",true,true,true);
        Sku banke=new Sku("banke",true,false,false);

        List<Sku> skuList=new ArrayList<>();

        skuList.add(dingjinquan);
        skuList.add(banke);

        HasStockSpecification hasStock=new HasStockSpecification();
        HasCanBuySpecification hasCanBuy=new HasCanBuySpecification();
        HasCouponpecification hasCoupon=new HasCouponpecification();

        ISpecification specification=hasStock.and(hasCoupon).and(hasCanBuy);
        for(Sku sku:skuList){
            if(specification.isSatisfiedBy(sku)){
                System.out.println("this sku name ="+sku.getName());
            }
        }
    }
}
