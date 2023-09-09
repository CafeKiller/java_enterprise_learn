package com.coffee.mall_tiny01.mbg;


import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/*
*  用于生成MBG的代码
*
* */
public class Generator {

    public static void main(String[] args) throws Exception {
        // MBG 执行过程中的错误信息
        List<String> waringList = new ArrayList<>();
        // 当生成的代码重复时, 覆盖原代码
        boolean overwrite = true;

        // 读取MBG的配置文件
        InputStream is = Generator.class.getResourceAsStream("/generatorConfig.xml");
        ConfigurationParser cp = new ConfigurationParser(waringList);
        Configuration config = cp.parseConfiguration(is);
        is.close();

        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        // 创建MBG
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, waringList);
        // 执行生成代码
        myBatisGenerator.generate(null);

        for (String waring : waringList) {
            System.out.println("[Warring]" + waring);
        }

    }

}
