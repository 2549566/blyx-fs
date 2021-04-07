package com.blyx.fs.common.base;

import lombok.Data;

import java.io.Serializable;

/**
 * @author quyang5
 * @description
 * @date 15:53 2021/2/5
 */
@Data
public class PageVO<T> implements Serializable{

    private static final long serialVersionUID = -8197034093845429233L;

    public static final int PAGE_NUM = 1;
    public static final int PAGE_SIZE = 20;
    public static final int PAGE_SIZE_MAX = 1000;

    /**
     * 当前页码
     * 默认是1
     * */
    private int pageNum=1;
    /**
     * 页大小
     * 默认20
     * */
    private int pageSize=20;
    /**
     * 入参
     *
     * */
    private T data;

    public PageVO() {
        this(1, 20);
    }

    public PageVO(int pageNum, int pageSize) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
    }

    public int getStartIndex() {
        return (this.getCurrentPage() - 1) * this.pageSize;
    }

    public int getCurrentPage() {
        if (this.pageNum <= 0) {
            this.pageNum = 1;
        }

        return this.pageNum;
    }

    public void setCurrentPage(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        if (this.pageSize <= 0) {
            this.pageSize = 20;
        } else if (this.pageSize > 1000) {
            this.pageSize = 1000;
        }

        return this.pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
