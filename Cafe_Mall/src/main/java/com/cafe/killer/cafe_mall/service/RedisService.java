package com.cafe.killer.cafe_mall.service;

/**
 * redis 操作 service
 * 对象和数组都以 json 格式存储
 * @author Coffee_Killer
 * */
public interface RedisService {

    /**
     * 存储数据
     * */
    void set(String key, String value);

    /**
     * 获取数据
     * */
    String get(String key);

    /**
     * 设置超时时间
     * */
    boolean expire(String key, long expire);

    /**
     * 删除数据
     * */
    void remove(String key);

    /**
     * 自增操作
     * @param delta 自增步长
     * */
    Long increment(String key, long delta);
}
