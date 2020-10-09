package com.liu.demo.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

/**
 * All rights Reserved, Designed By 醴智信息
 * Copyright: Copyright(C) 2017-2019
 * Company 湖南醴智信息科技有限公司
 *
 * @author 刘金妮
 * @version 1.0
 * @date 2020/9/14 14:26
 * @Description test-project
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BaseEntity {

    // 自动生成id
    @TableId(type = IdType.AUTO)
    private String id;

    @TableField(fill = FieldFill.INSERT)
    private Date createdTime;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date lastTime;
    private String createdName;
    private String lastName;

    // 逻辑删除
    @TableLogic
    private Integer deleted;
}
