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
public class BaseEntity implements Serializable {

 private static final long serialVersionUID = -2765874141255430175L;
 /**
     * 创建时间
     *
     * */
     private Date created=new Date();

     /**
      * 修改时间
      *
      * */
     private Date modified=new Date();

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
     private Integer yn=1;
}
