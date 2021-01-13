package com.blyx.fs.patterns.specification;

import com.blyx.fs.patterns.specification.impl.AndSpecification;
import com.blyx.fs.patterns.specification.impl.NotSpecification;
import com.blyx.fs.patterns.specification.impl.OrSpecification;

/**
 * @author quyang5
 * @description
 * @date 15:53 2021/1/13
 */
public abstract class CompositeSpecification<T> implements ISpecification<T> {

    @Override
    public ISpecification<T> and(ISpecification<T> specification) {
        return new AndSpecification<>(this,specification);
    }

    @Override
    public ISpecification<T> or(ISpecification<T> specification) {
        return new OrSpecification<>(this,specification);
    }

    @Override
    public ISpecification not() {
        return new NotSpecification(this);
    }
}
