package com.blyx.fs.patterns.specification;

/**
 * @author quyang5
 * @description 规格接口
 * @date 15:53 2021/1/13
 */
public interface ISpecification<T> {
    /**
     * 是否满足条件
     *
     * @param candidate
     * @return
     */
    boolean isSatisfiedBy(T candidate);
    /**
     * and操作
     *
     * @param specification
     * @return
     */
    ISpecification<T> and(ISpecification<T> specification);

    /**
     * or操作
     *
     * @param specification
     * @return
     */
    ISpecification<T> or(ISpecification<T> specification);

    /**
     * not操作
     *
     * @return
     */
    ISpecification not();

}
