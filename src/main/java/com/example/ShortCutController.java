package com.example;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ShortCutController {
    @GetMapping("/")
    String index() {
        return "index";
    }

}
