package com.personal.HitCounter.WebController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HitCounter_WebController {
    @GetMapping("/")
    public String getMethodName() {
        return "index.html";
    }
}
