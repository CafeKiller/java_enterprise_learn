package com.coffee.mall_tiny01.service.impl;

import com.coffee.mall_tiny01.mbg.mapper.PmsBrandMapper;
import com.coffee.mall_tiny01.mbg.model.PmsBrand;
import com.coffee.mall_tiny01.mbg.model.PmsBrandExample;
import com.coffee.mall_tiny01.service.PmsBrandService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/*
* PmsBrandService 实现类
* created by coffee on 2023/9/9
* */
@Service
public class PmsBrandServiceImpl implements PmsBrandService {

    @Autowired
    private PmsBrandMapper brandMapper;

    /*
    * 查询全部
    * */
    @Override
    public List<PmsBrand> listAllBrand() {
        return brandMapper.selectByExample(new PmsBrandExample());
    }

    /*
    * 创建一个brand
    * */
    @Override
    public int createBrand(PmsBrand brand) {
        return brandMapper.insertSelective(brand);
    }

    /*
    * 更新一个brand
    * */
    @Override
    public int updateBrand(Long id, PmsBrand brand) {
        brand.setId(id);
        return brandMapper.updateByPrimaryKeySelective(brand);
    }

    /*
    * 删除
    * */
    @Override
    public int deleteBrand(Long id) {
        return brandMapper.deleteByPrimaryKey(id);
    }

    /*
    * 分页查询
    * */
    @Override
    public List<PmsBrand> listBrand(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return brandMapper.selectByExample(new PmsBrandExample());
    }

    /*
    * 获取一个指定id的brand
    * */
    @Override
    public PmsBrand getBrand(Long id) {
        return brandMapper.selectByPrimaryKey(id);
    }
}
