package com.loving.myblog.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: LiMG
 * @create: 2019-08-27 15:22:55
 **/
@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/aaa")
    public void aaa() {
        System.out.println("****************");
    }

}
