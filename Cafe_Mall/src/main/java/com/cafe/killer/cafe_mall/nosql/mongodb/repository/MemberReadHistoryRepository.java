package com.cafe.killer.cafe_mall.nosql.mongodb.repository;

import com.cafe.killer.cafe_mall.nosql.mongodb.document.MemberReadHistory;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * 会员商品浏览历史记录 Repository
 * @author Coffee_Killer
 * */
public interface MemberReadHistoryRepository extends MongoRepository<MemberReadHistory, String> {

    /**
     * 根据会员id按照时间倒序获取浏览记录
     * @param memberId 会员ID
     * */
    List<MemberReadHistory> findByMemberIdOrderByCreateTimeDesc(Long memberId);

}
