package com.blyx.fs.patterns.specification.impl.biz;

import com.blyx.fs.patterns.specification.CompositeSpecification;
import com.blyx.fs.patterns.test.Sku;

/**
 * @author quyang5
 * @description
 * @date 15:53 2021/1/13
 */
public class HasCouponpecification<T> extends CompositeSpecification<T> {
    @Override
    public boolean isSatisfiedBy(T candidate) {
        Sku sku=(Sku)candidate;
        //todo 调用优惠券中心
        return sku.getHasCoupon();
    }
}
