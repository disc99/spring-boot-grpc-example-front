package com.example;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@AllArgsConstructor
public class ShortCutController {

    ShortCutServiceClient client;

    @GetMapping("/shortcut")
    String index() {
        return "shortcut";
    }

    @PostMapping("/shortcut")
    String shortcut(@RequestParam String url) {
        System.out.println(url);
        return "result";
    }

    @GetMapping("/s/{url}")
    String redirect(@PathVariable String url) {
        System.out.println(url);
        return "redirect:https://google.com";
    }
}

