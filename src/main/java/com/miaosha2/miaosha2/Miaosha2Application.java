package com.miaosha2.miaosha2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class Miaosha2Application {

    @RequestMapping("/")
    public String first(){
        return "my first spring boot!!!";
    }
    public static void main(String[] args) {
        SpringApplication.run(Miaosha2Application.class, args);
    }

}
