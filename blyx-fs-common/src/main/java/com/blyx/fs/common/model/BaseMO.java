package com.blyx.fs.common.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author quyang5
 * @description
 * @date 15:53 2021/1/12
 */
@Data
public class BaseMO implements Serializable {
    private static final long serialVersionUID = 475358006751425474L;

    /**
     * 创建时间
     *
     * */
     private Date created;

     /**
      * 修改时间
      *
      * */
     private Date modified;

     /**
      * 创建人
      *
      * */
     private String creator;

     /**
      * 修改人
      *
      * */
     private String modifier;

     /**
      * 是否有效
      * 1：有效
      * 0：逻辑删除
      *
      * */
     private String yn;
}
