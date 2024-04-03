package com.cafe.killer.cafe_mall.mbg;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.internal.DefaultCommentGenerator;
import org.mybatis.generator.internal.util.StringUtility;

import java.util.Properties;

/**
 * 自定义注释生成器, 配合 MBG 生成器使用
 * @author Coffee_Killer by 2024_4_3日
 * */
public class CommentGenerator extends DefaultCommentGenerator {
    private boolean addRemarkComment = false;

    /**
     * 设置用户配置参数
     * */
    @Override
    public void addConfigurationProperties(Properties properties) {
        super.addConfigurationProperties(properties);
        this.addRemarkComment = StringUtility.isTrue(properties.getProperty("addRemarkComment"));
    }

    /**
     * 为字段名添加注释
     * */
    @Override
    public void addFieldComment(Field field, IntrospectedTable introspectedTable,
                                IntrospectedColumn introspectedColumn) {
        super.addFieldComment(field, introspectedTable, introspectedColumn);
        String remarks = introspectedColumn.getRemarks();
        // 根据 参数和备注信息 判断 是否添加备注信息
        if (addRemarkComment && StringUtility.stringHasValue(remarks)) {
            addFieldJavaDoc(field, remarks);
        }
    }

    /**
     * 给 model 的字段添加 JavaDoc 注释
     * */
    private void addFieldJavaDoc(Field field, String remarks) {
        // JavaDoc 开始
        field.addJavaDocLine("/**");

        // 获取数据库字段的备注信息
        String[] remarkLines = remarks.split(System.getProperty("line.separator"));
        for (String remarkLine : remarkLines) field.addJavaDocLine(" * " + remarkLine);
        this.addJavadocTag(field, false);

        // JavaDoc 结束
        field.addJavaDocLine(" */");
    }
}
