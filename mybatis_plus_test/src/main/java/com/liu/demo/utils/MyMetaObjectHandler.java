package com.liu.demo.utils;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Set;

/**
 * All rights Reserved, Designed By 醴智信息
 * Copyright: Copyright(C) 2017-2019
 * Company 湖南醴智信息科技有限公司
 *
 * @author 刘金妮
 * @version 1.0
 * @date 2020/9/14 14:06
 * @Description 自动填充处理器,必须在字段上加入注解
 */
@Component
@Slf4j
public class MyMetaObjectHandler implements MetaObjectHandler {

    // 创建时执行
    @Override
    public void insertFill(MetaObject metaObject) {
        this.setFieldValByName("createdTime",new Date(),metaObject);
        this.setFieldValByName("lastTime",new Date(),metaObject);
}

    // 更新时操作
    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("lastTime",new Date(),metaObject);
    }
}
