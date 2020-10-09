package com.liu.demo.entity;

import lombok.*;

/**
 * All rights Reserved, Designed By 醴智信息
 * Copyright: Copyright(C) 2017-2019
 * Company 湖南醴智信息科技有限公司
 *
 * @author 刘金妮
 * @version 1.0
 * @date 2020/9/14 14:17
 * @Description test-project
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Score extends BaseEntity {
    private String subject;
    private Double score;
    private String user;
}
