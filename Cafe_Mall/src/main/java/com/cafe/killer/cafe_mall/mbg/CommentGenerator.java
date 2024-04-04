package com.cafe.killer.cafe_mall.mbg;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.CompilationUnit;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.internal.DefaultCommentGenerator;
import org.mybatis.generator.internal.util.StringUtility;

import java.util.Properties;
import java.util.Set;

/**
 * 自定义注释生成器, 配合 MBG 生成器使用
 * @author Coffee_Killer by 2024_4_3日
 * */
public class CommentGenerator extends DefaultCommentGenerator {
    private boolean addRemarkComments  = false;
    private static final String EXAMPLE_SUFFIX = "Example";
    private static final String API_MODEL_PROPERTY_FULL_CLASS_NAME = "io.swagger.annotations.ApiModelProperty";

    /**
     * 设置用户配置参数
     * */
    @Override
    public void addConfigurationProperties(Properties properties) {
        super.addConfigurationProperties(properties);
        this.addRemarkComments  = StringUtility.isTrue(properties.getProperty("addRemarkComments"));
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
        if (addRemarkComments  && StringUtility.stringHasValue(remarks)) {
            // addFieldJavaDoc(field, remarks);
            // 需要将数据库的特殊符号进行转义
            if (remarks.contains("\"")) remarks = remarks.replace("\"","'");
            // 给 model 的字段添加 swagger 注解
            field.addJavaDocLine("@ApiModelProperty(value = \"" + remarks + "\")");
        }
    }

    @Override
    public void addJavaFileComment(CompilationUnit compilationUnit) {
        super.addJavaFileComment(compilationUnit);
        // 只为 model 添加 swagger 注解类的注入
        if (!compilationUnit.isJavaInterface()
                && !compilationUnit.getType().getFullyQualifiedName().contains(EXAMPLE_SUFFIX)) {
            compilationUnit.addImportedType(new FullyQualifiedJavaType(API_MODEL_PROPERTY_FULL_CLASS_NAME));
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
