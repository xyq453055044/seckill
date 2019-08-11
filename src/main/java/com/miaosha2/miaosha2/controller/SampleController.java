package com.miaosha2.miaosha2.controller;

import com.miaosha2.miaosha2.domain.User;
import com.miaosha2.miaosha2.redis.RedisService;
import com.miaosha2.miaosha2.redis.UserKey;
import com.miaosha2.miaosha2.result.CodeMsg;
import com.miaosha2.miaosha2.result.Result;
import com.miaosha2.miaosha2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author xyq
 * @date 2019/08/02
 */
@Controller
@RequestMapping("/demo")
public class SampleController {

    @Autowired
    private UserService userService;

    @Autowired
    private RedisService redisService;

    @RequestMapping("/thymeleaf")
    public String thymeleaf(Model model){
        model.addAttribute("name", "xyq");
        return "hello";
    }

    // 1.rest api json 输出  2.页面


//    @RequestMapping("/hello")
//    public String hello(){
//        Result.success(data);
//        return new Result(0, "success", "hello,imooc");
//    }
//
    @RequestMapping("/hello")
    @ResponseBody
    public Result<String> hello(){
        return Result.success("hello,imooc");

    }


//    @RequestMapping("/helloError")
//    public String hello(){
//        Result.
//        return new Result(500100, "session失效");
//        return new Result(500101, "XXX");
//        return new Result(500102, "XXX");
//    }

    @RequestMapping("/helloError")
    @ResponseBody
    public Result<String> helloError(){
        return Result.error(CodeMsg.SERVER_ERROR);
    }

    @RequestMapping("/db/get")
    @ResponseBody
    public Result<User> dbGet(){
        User user = userService.getById(1);
        return Result.success(user);
    }

    @RequestMapping("/db/tx")
    @ResponseBody
    public Result<Boolean> dbTX(){
        userService.tx();
        return Result.success(true);
    }

//    @RequestMapping("/redis/get")
//    @ResponseBody
//    public Result<Long> redisGet(){
//        Long v1 = redisService.get("key1", Long.class);
//        return Result.success(v1);
//    }
//
//    @RequestMapping("/redis/set")
//    @ResponseBody
//    public Result<String> redisSet(){
//        boolean ret = redisService.set("key2", "hello,xyq");
//        String str = redisService.get("key2", String.class);
//
//        return Result.success(str);
//    }


    @RequestMapping("/redis/get")
    @ResponseBody
    public Result<User> redisGet(){
        User user = redisService.get(UserKey.getById,""+1, User.class);
        return Result.success(user);
    }

    @RequestMapping("/redis/set")
    @ResponseBody
    public Result<Boolean> redisSet(){
        User user = new User();
        user.setId(1);
        user.setName("1111");
        // UserKey:id1
        redisService.set(UserKey.getById,""+1, user);
        return Result.success(true);
    }
}
