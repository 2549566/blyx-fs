package com.blyx.fs.patterns.specification.impl;

import com.blyx.fs.patterns.specification.CompositeSpecification;
import com.blyx.fs.patterns.specification.ISpecification;

/**
 * @author quyang5
 * @description
 * @date 15:53 2021/1/13
 */
public class NotSpecification<T> extends CompositeSpecification<T> {


    /**
     * 传入的规格
     */
    private ISpecification<T> specification;

    public NotSpecification(ISpecification<T> specification) {
        this.specification = specification;
    }


    @Override
    public boolean isSatisfiedBy(T candidate) {
        return this.specification.isSatisfiedBy(candidate);
    }
}
