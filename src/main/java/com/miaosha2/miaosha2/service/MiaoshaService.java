package com.miaosha2.miaosha2.service;

import com.miaosha2.miaosha2.domain.MiaoshaUser;
import com.miaosha2.miaosha2.domain.OrderInfo;
import com.miaosha2.miaosha2.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author xyq
 * @date 2019/08/04
 */
@Service
public class MiaoshaService {

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private OrderService orderService;

    @Transactional
    public OrderInfo miaosha(MiaoshaUser user, GoodsVo goods) {
        // 减少库存 下订单 写入秒杀订单
        goodsService.reduceStock(goods);
        // order_info miaosha_order
        return orderService.createOrder(user, goods);


    }
}
