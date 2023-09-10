package com.coffee.mall_tiny01.mbg;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.CompilationUnit;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.internal.DefaultCommentGenerator;
import org.mybatis.generator.internal.util.StringUtility;

import java.util.Properties;

/**
 * 自定义注释生成器
 * */
public class CommentGenerator extends DefaultCommentGenerator {

    private boolean addRemarkComments = false;
    private static final String EXAMPLE_SUFFIX = "Example";
    private static final String API_MODEL_PROPERTY_FULL_CLASS_NAME = "io.swagger.annotations.ApiModelProperty";

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
            // addFieldJavaDoc(field, remarks);
            if (remarks.contains("\"")){ // 对数据库中的特殊字符进行转义
                remarks = remarks.replace("\"","'");
            }
            // 给model的字段添加swagger注释
            field.addJavaDocLine("@ApiModelProperty(value =  \""+remarks+"\")");
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
        addJavadocTag(field,false);
        field.addJavaDocLine("*/"); // 文档注释结束
    }

    @Override
    public void addJavaFileComment(CompilationUnit compilationUnit) {
        super.addJavaFileComment(compilationUnit);
        // 只在model 中添加swagger注解类的导入
        if (!compilationUnit.isJavaInterface() && !compilationUnit.getType().getFullyQualifiedName().contains(EXAMPLE_SUFFIX)){
            compilationUnit.addImportedType(new FullyQualifiedJavaType(API_MODEL_PROPERTY_FULL_CLASS_NAME));
        }
    }
}
