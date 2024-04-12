package com.cafe.killer.cafe_mall.service;

import com.cafe.killer.cafe_mall.nosql.mongodb.document.MemberReadHistory;

import java.util.List;

/**
 * 会员浏览历史记录管理 service
 * @author Coffee_Killer
 * */
public interface MemberReadHistoryService {
    /**
     * 生成浏览记录
     * */
    int create(MemberReadHistory memberReadHistory);

    /**
     * 批量删除浏览记录
     * */
    int delete(List<String> ids);

    /**
     * 获取用户浏览历史记录
     * */
    List<MemberReadHistory> list(Long memberId);
}
