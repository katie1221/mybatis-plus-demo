package com.example.autofilldemo.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.util.Date;

/**
 * 公共字段
 * @author qzz
 */
@Data
public class BaseEntity {

    /**
     * 创建者
     */
    @TableField(value = "create_user", fill = FieldFill.INSERT)
    private String create_user;

    /**
     * 创建时间
     */
    @TableField(value = "create_time", fill = FieldFill.INSERT)

    private Date create_time;

    /**
     * 修改时间
     */
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private Date update_time;

    /**
     * 修改者id
     */
    @TableField(value = "update_user", fill = FieldFill.INSERT_UPDATE)
    private String update_user;
}
