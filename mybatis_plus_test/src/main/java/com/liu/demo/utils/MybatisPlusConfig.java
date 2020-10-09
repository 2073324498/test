package com.liu.demo.utils;

import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor;
import com.baomidou.mybatisplus.extension.plugins.pagination.optimize.JsqlParserCountOptimize;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @Package: com.liu.demo.utils
 * @ClassName: MybatisPlusConfig
 * @CreateTime: 2020/10/7 0:16
 * @Company: 湖南醴智信息科技有限公司
 * @Author: 刘金妮
 * @Description: mybatisPlus的配置中心
 */

@Configuration
@EnableTransactionManagement
@MapperScan("com.liu.demo.mapper")
public class MybatisPlusConfig {


    // 乐观锁插件
    // 注：使用乐观锁插件时必须在字段上加上注解：Version
    @Bean
    public OptimisticLockerInterceptor optimisticLockerInterceptor() {
        return new OptimisticLockerInterceptor();
    }

    // 分页插件配置
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        // 设置请求的页面大于最大页后操作， true调回到首页，false 继续请求  默认false
        // paginationInterceptor.setOverflow(false);
        // 设置最大单页限制数量，默认 500 条，-1 不受限制
        // paginationInterceptor.setLimit(500);
        // 开启 count 的 join 优化,只针对部分 left join
//        paginationInterceptor.setProperties(new JsqlParserCountOptimize(true));
        return paginationInterceptor;
    }

    // 效率插件
    @Bean
    @Profile({"dev","test"})
    public PerformanceInterceptor performanceInterceptor(){
        PerformanceInterceptor pi = new PerformanceInterceptor();
        // 格式化
        pi.setFormat(true);
        // sql执行最大时间毫秒数
        pi.setMaxTime(100);
        return pi;
    }
}