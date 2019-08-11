package com.miaosha2.miaosha2.redis;

/**
 * @author xyq
 * @date 2019/08/02
 */
public class OrderKey extends BasePrefix {

    public OrderKey(String prefix) {
        super(prefix);
    }

    public static OrderKey getMiaoshaOrderByUidGid = new OrderKey("moug");
}
