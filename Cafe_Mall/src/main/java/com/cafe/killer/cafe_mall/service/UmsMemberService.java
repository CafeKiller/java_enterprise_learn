package com.cafe.killer.cafe_mall.service;

import com.cafe.killer.cafe_mall.common.api.CommonResult;
import org.springframework.stereotype.Service;

/**
 * 会员管理 Service
 * @author Coffee_Killer
 * */
@Service
public interface UmsMemberService {

    /**
     * 生成验证码(通过手机号)
     * */
    CommonResult generateAuthCode(String telephone);

    /**
     * 判断验证手机号与验证码是否匹配
     * */
    CommonResult verifyAuthCode(String telephone, String authCode);

}
