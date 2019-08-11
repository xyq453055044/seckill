package com.miaosha2.miaosha2.redis;

/**
 * @author xyq
 * @date 2019/08/02
 */
public interface KeyPrefix{

    int expireSeconds();

    String getPrefix();
}
