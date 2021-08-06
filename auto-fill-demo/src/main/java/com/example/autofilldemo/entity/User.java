package com.example.autofilldemo.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.io.Serializable;

/**
 * @author qzz
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_user")
public class User extends BaseEntity implements Serializable{

    private  static final long serialVersionUID = 1L;

    /**
     * 用户id
     */
    @TableId(value="id", type = IdType.AUTO)
    private Integer id;
    /**
     * 名称
     */
    @TableField("name")
    private String name;

    /**
     * 年龄
     */
    @TableField("age")
    private Integer age;

    /**
     * 备注
     */
    @TableField("remarks")
    private String remarks;

}
