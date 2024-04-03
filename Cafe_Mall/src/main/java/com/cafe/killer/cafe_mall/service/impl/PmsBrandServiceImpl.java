package com.cafe.killer.cafe_mall.service.impl;

import com.cafe.killer.cafe_mall.mbg.mapper.PmsBrandMapper;
import com.cafe.killer.cafe_mall.mbg.model.PmsBrand;
import com.cafe.killer.cafe_mall.mbg.model.PmsBrandExample;
import com.cafe.killer.cafe_mall.service.PmsBrandService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * PmsBrandServiceImpl 品牌管理服务实现类
 * @author Coffee_Killer
 * */
@Service
public class PmsBrandServiceImpl implements PmsBrandService {

    @Autowired
    private PmsBrandMapper brandMapper;

    /**
     * 查询所有品牌
     * */
    @Override
    public List<PmsBrand> listAllBrand() {
        return brandMapper.selectByExample(new PmsBrandExample());
    }

    /**
     * 创建一个新的品牌
     * */
    @Override
    public int createBrand(PmsBrand brand) {
        return brandMapper.insertSelective(brand);
    }

    /**
     * 更新一个品牌
     * */
    @Override
    public int updateBrand(Long id, PmsBrand brand) {
        brand.setId(id);
        return brandMapper.updateByPrimaryKeySelective(brand);
    }

    /**
     * 删除指定一个品牌
     * */
    @Override
    public int deleteBrand(Long id) {
        return brandMapper.deleteByPrimaryKey(id);
    }

    /**
     * 分页查询品牌
     * */
    @Override
    public List<PmsBrand> listBrand(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return brandMapper.selectByExample(new PmsBrandExample());
    }

    /**
     * 通过id获取一个品牌
     * */
    @Override
    public PmsBrand getBrand(Long id) {
        return brandMapper.selectByPrimaryKey(id);
    }
}
