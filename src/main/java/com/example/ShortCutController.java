package com.example;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@AllArgsConstructor
public class ShortCutController {

    private ShortCutServiceClient client;

    @GetMapping("/shortcut")
    String index() {
        return "shortcut";
    }

    @PostMapping("/shortcut")
    String shortcut(@RequestParam String url, Model model) {
        model.addAttribute("url", client.shortcut(url));
        return "result";
    }

    @GetMapping("/s/{url}")
    String redirect(@PathVariable String url) {
        return "redirect:" + client.parse(url);
    }
}

