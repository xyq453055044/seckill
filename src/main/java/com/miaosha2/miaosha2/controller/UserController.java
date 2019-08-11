package com.miaosha2.miaosha2.controller;

import com.miaosha2.miaosha2.domain.MiaoshaUser;
import com.miaosha2.miaosha2.redis.RedisService;
import com.miaosha2.miaosha2.result.Result;
import com.miaosha2.miaosha2.service.MiaoshaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author xyq
 * @date 2019/08/09
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private MiaoshaService miaoshaService;

    @Autowired
    private RedisService redisService;

    @RequestMapping("/info")
    @ResponseBody
    public Result<MiaoshaUser> info(Model model, MiaoshaUser user){
        return Result.success(user);
    }
}
