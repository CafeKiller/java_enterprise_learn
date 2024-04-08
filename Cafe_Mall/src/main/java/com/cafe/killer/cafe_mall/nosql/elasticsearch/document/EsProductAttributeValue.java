package com.cafe.killer.cafe_mall.nosql.elasticsearch.document;

import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;

public class EsProductAttributeValue implements Serializable {

    private static final long serialVersionUID = -1L;

    private Long id;

    private Long productAttributeID;

    // 属性值
    @Field(type = FieldType.Keyword)
    private String value;

    // 属性参数: 0 -> 规格; 1 -> 参数
    private Integer type;

    // 属性名称
    @Field(type = FieldType.Keyword)
    private String name;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductAttributeID() {
        return productAttributeID;
    }

    public void setProductAttributeID(Long productAttributeID) {
        this.productAttributeID = productAttributeID;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
