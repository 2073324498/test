package com.liu.demo.utils;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.Arrays;

/**
 * @Package: com.liu.demo.utils
 * @ClassName: MyAutoGener
 * @CreateTime: 2020/10/8 22:39
 * @Company: 湖南醴智信息科技有限公司
 * @Author: 刘金妮
 * @Description:
 */
public class MyAutoGener {

    public static void main(String[] args) {
        AutoGenerator auto = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        gc.setAuthor("刘金妮"); // 作者
        gc.setDateType(DateType.ONLY_DATE);
        gc.setOutputDir(System.getProperty("user.dir")+"/src/main/java/com/liu/demo"); // 生成所在路径
        gc.setOpen(false); // 是否打开资源
        gc.setFileOverride(false); // 是否覆盖
        gc.setServiceImplName("s%Service"); // 去除Service前面的I
        gc.setIdType(IdType.ID_WORKER); // 设置id自动生成
        gc.setSwagger2(true); // 开启swagger注解
        auto.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL);
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUrl("jdbc:mysql:///test?useUnicode=true&characterEncoding=UTF-8&serverTimezone=GMT%2B8&useSSL=false&allowPublicKeyRetrieval=true");
        dsc.setUsername("root");
        dsc.setPassword("root");
        auto.setDataSource(dsc);

        // 包的配置
        PackageConfig pc = new PackageConfig();
        pc.setEntity("entity");
        pc.setController("controller");
        pc.setMapper("mapper");
        pc.setModuleName("test");
        pc.setParent(null); // 父包
        pc.setService("service");
        auto.setPackageInfo(pc);

        // 策略配置
        StrategyConfig sc = new StrategyConfig();
        sc.setNaming(NamingStrategy.underline_to_camel);
        sc.setColumnNaming(NamingStrategy.underline_to_camel);
        sc.setLogicDeleteFieldName("is_del");
        sc.setEntityLombokModel(true);
        sc.setRestControllerStyle(true);
        sc.setInclude("user","score");
        TableFill createdTime = new TableFill("created_time", FieldFill.INSERT);
        TableFill lastTime = new TableFill("last_time", FieldFill.INSERT_UPDATE);
        sc.setTableFillList(Arrays.asList(createdTime,lastTime));
        sc.setVersionFieldName("version");
        auto.setStrategy(sc);

        auto.execute();
    }
}