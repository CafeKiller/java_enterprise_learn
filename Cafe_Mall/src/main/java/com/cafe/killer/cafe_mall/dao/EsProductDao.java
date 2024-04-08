package com.cafe.killer.cafe_mall.dao;

import com.cafe.killer.cafe_mall.nosql.elasticsearch.document.EsProduct;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 搜索系统中的商品管理自定义 Dao
 * @author Coffee_Killer
 * */
public interface EsProductDao {

    List<EsProduct> getAllEsProductList(@Param("id") Long id);
}
