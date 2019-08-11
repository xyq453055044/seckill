package com.miaosha2.miaosha2.controller;

import com.miaosha2.miaosha2.domain.MiaoshaUser;
import com.miaosha2.miaosha2.domain.OrderInfo;
import com.miaosha2.miaosha2.redis.RedisService;
import com.miaosha2.miaosha2.result.CodeMsg;
import com.miaosha2.miaosha2.result.Result;
import com.miaosha2.miaosha2.service.GoodsService;
import com.miaosha2.miaosha2.service.MiaoshaService;
import com.miaosha2.miaosha2.service.OrderService;
import com.miaosha2.miaosha2.vo.GoodsVo;
import com.miaosha2.miaosha2.vo.OrderDetailVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author xyq
 * @date 2019/08/11
 */
@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private MiaoshaService miaoshaService;

    @Autowired
    private RedisService redisService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private GoodsService goodsService;

    @RequestMapping("/detail")
    @ResponseBody
    public Result<OrderDetailVo> info(Model model, MiaoshaUser user, @RequestParam("orderId") long orderId){
        if (user == null){
            return Result.error(CodeMsg.SESSION_ERROR);
        }
        OrderInfo order = orderService.getOrderById(orderId);
        if (order == null){
            return Result.error(CodeMsg.ORDER_NOT_EXIST);
        }
        long goodsId = order.getGoodsId();
        GoodsVo goods = goodsService.getGoodsVoByGoodsId(goodsId);
        OrderDetailVo vo = new OrderDetailVo();
        vo.setGoods(goods);
        vo.setOrder(order);
        return Result.success(vo);
    }
}
