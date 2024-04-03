package com.cafe.killer.cafe_mall.service;

import com.cafe.killer.cafe_mall.mbg.model.PmsBrand;

import java.util.List;

/**
 * PmsBrandService 品牌管理服务接口
 * @author Coffee_Killer
 * */
public interface PmsBrandService {

    List<PmsBrand> listAllBrand();

    int createBrand(PmsBrand brand);

    int updateBrand(Long id, PmsBrand brand);

    int deleteBrand(Long id);

    List<PmsBrand> listBrand(int pageNum, int pageSize);

    PmsBrand getBrand(Long id);

}
