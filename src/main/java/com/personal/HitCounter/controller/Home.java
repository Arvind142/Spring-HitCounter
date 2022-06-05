package com.personal.HitCounter.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


@RestController
public class Home {

    @Value("${spring.application.version}")
    private String appVersion;

    @RequestMapping("/")
    @GetMapping("/")
    public Map getHomeCall(){
        Map map = new HashMap();
        map.put("App version",appVersion);
        return map;
    }
}
