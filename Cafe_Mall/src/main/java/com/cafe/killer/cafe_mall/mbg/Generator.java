package com.cafe.killer.cafe_mall.mbg;

import com.cafe.killer.cafe_mall.utils.PrintTools;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * 用于生产 MBG (MybatisGenerator)的代码
 * @author Coffee_Killer
 * */
public class Generator {

    public static void main(String[] args) throws Exception {

        // 收集 MBG 执行过程中的错误警告
        List<String> warnings = new ArrayList<String>();

        // 重复生成时, 直接覆盖
        boolean overwrite = true;

        // 读取 MBG 配置文件
        InputStream is = Generator.class.getResourceAsStream("/generatorConfig.xml");
        ConfigurationParser cp =  new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(is);
        if (is != null) is.close();

        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        // 创建 MBG
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        // 执行生成代码
        myBatisGenerator.generate(null);

        // 输出错误信息
        for (String warning : warnings) System.err.println("[MyBatis-Generator] => " + warning);
        PrintTools.PrintGreenerText("[MyBatis-Generator] => Generation End");
    }

}
