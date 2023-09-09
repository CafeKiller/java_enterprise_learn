package com.coffee.mall_tiny01.mbg;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.internal.DefaultCommentGenerator;
import org.mybatis.generator.internal.util.StringUtility;

import java.util.Properties;

public class CommentGenerator extends DefaultCommentGenerator {

    private boolean addRemarkComments = false;

    /*
    * 设置用户参数
    * */
    @Override
    public void addConfigurationProperties(Properties properties) {
        super.addConfigurationProperties(properties);
        this.addRemarkComments = StringUtility.isTrue(properties.getProperty("addRemarkComments"));
    }

    /*
    * 为字段添加注释
    * */
    @Override
    public void addFieldComment(Field field, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {
        String remarks = introspectedColumn.getRemarks();

        // 根据参数和备注信息判断是否需要添加注释信息
        if (addRemarkComments && StringUtility.stringHasValue(remarks)){
            addFieldJavaDoc(field, remarks);
        }
    }

    /*
    * 给model的字段添加注释
    * */
    void addFieldJavaDoc(Field field, String remarks){
        field.addJavaDocLine("/**"); // 文档注释开始

        // 获取数据库字段的注释信息
        String[] remarkLines = remarks.split(System.getProperty("line.separator"));
        for (String remarkLine : remarkLines) {
            field.addJavaDocLine(" * " + remarkLine);
        }
        field.addJavaDocLine("*/"); // 文档注释结束
    }

}
