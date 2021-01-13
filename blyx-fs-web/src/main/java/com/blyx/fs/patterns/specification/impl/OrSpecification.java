package com.blyx.fs.patterns.specification.impl;


import com.blyx.fs.patterns.specification.CompositeSpecification;
import com.blyx.fs.patterns.specification.ISpecification;

/**
 * @author quyang5
 * @description or 的规格
 * @date 15:53 2021/1/13
 */
public class OrSpecification<T> extends CompositeSpecification<T> {

    /**
     * 传入两个规格
     */
    private ISpecification<T> left;
    private ISpecification<T> right;

    public OrSpecification(ISpecification<T> left, ISpecification<T> right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public boolean isSatisfiedBy(T candidate) {
        return this.left.isSatisfiedBy(candidate) || this.right.isSatisfiedBy(candidate);
    }
}
