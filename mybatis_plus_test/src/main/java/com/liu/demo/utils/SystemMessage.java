package com.lizhi.demo.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * All rights Reserved, Designed By 醴智信息
 * Copyright: Copyright(C) 2017-2019
 * Company 湖南醴智信息科技有限公司
 *
 * @author 刘金妮
 * @version 1.0
 * @date 2020/9/15 14:17
 * @Description test-project
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SystemMessage<T> implements Serializable {
    private static final long serialVersionUID = -2062821971035387344L;
    private String msg;
    private Integer code;
    private int count;
    private boolean success;
    private T data;
}
