package com.miaosha2.miaosha2.vo;

import com.miaosha2.miaosha2.domain.OrderInfo;

/**
 * @author xyq
 * @date 2019/08/11
 */
public class OrderDetailVo {

    private GoodsVo goods;

    private OrderInfo order;

    public GoodsVo getGoods() {
        return goods;
    }

    public void setGoods(GoodsVo goods) {
        this.goods = goods;
    }

    public OrderInfo getOrder() {
        return order;
    }

    public void setOrder(OrderInfo order) {
        this.order = order;
    }
}
