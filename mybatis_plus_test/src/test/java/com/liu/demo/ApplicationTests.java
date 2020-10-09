package com.liu.demo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.liu.demo.entity.Score;
import com.liu.demo.entity.User;
import com.liu.demo.mapper.ScoreMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ApplicationTests {

    @Autowired
    private ScoreMapper scoreMapper;

    @Test
    void contextLoads() {
        List<Score> scores = this.scoreMapper.selectList(null);
        scores.forEach(System.out::println);
    }

    @Test
    void selects() {
        QueryWrapper<Score> wrapper = new QueryWrapper<>();
        wrapper.like("subject","独孤九剑");
        List<Score> scores = this.scoreMapper.selectList(wrapper);
        scores.forEach(System.out::println);
    }

    @Test
    void page() {
        // 参数一：页数
        // 参数二：条数
        Page<Score> page = new Page<>(2,2);
        IPage<Score> scoreIPage = this.scoreMapper.selectPage(page, null);
        scoreIPage.getRecords().forEach(System.out::println);
    }

}
