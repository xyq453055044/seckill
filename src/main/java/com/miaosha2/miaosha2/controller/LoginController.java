package com.miaosha2.miaosha2.controller;

import com.miaosha2.miaosha2.redis.RedisService;
import com.miaosha2.miaosha2.result.CodeMsg;
import com.miaosha2.miaosha2.result.Result;
import com.miaosha2.miaosha2.service.MiaoshaUserService;
import com.miaosha2.miaosha2.service.UserService;
import com.miaosha2.miaosha2.util.ValidatorUtil;
import com.miaosha2.miaosha2.vo.LoginVo;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

/**
 * @author xyq
 * @date 2019/08/02
 */
@Controller
@RequestMapping("login")
public class LoginController {

    private static Logger log= LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private MiaoshaUserService userService;

    @Autowired
    private RedisService redisService;

    @RequestMapping("/to_login")
    public String toLogin(Model model){
        return "login";
    }




    @RequestMapping("/do_login")
    @ResponseBody
    public Result<String> doLogin(HttpServletResponse response, @Valid LoginVo loginVo){
        log.info(loginVo.toString());
        // 登录
        String token = userService.login(response, loginVo);
        return Result.success(token);
    }


}
