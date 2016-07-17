package com.example;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ShortCutController {

    @GetMapping("/shortcut")
    String index() {
        return "shortcut";
    }

    @PostMapping("/shortcut")
    String shortcut(@RequestParam String url) {
        System.out.println(url);
        return "result";
    }


}
