package com.example;

import io.example.url.Url;
import io.example.url.UrlServiceGrpc;
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

    UrlServiceGrpc.UrlServiceBlockingStub stub;

    @GetMapping("/shortcut")
    String index() {
        return "shortcut";
    }

    @PostMapping("/shortcut")
    String shortcut(@RequestParam String url, Model model) {
        model.addAttribute("url", stub.shortcut(Url.ShortcutRequest.newBuilder().setBaseUrl(url).build()).getShortUrl());
        return "result";
    }

    @GetMapping("/s/{url}")
    String redirect(@PathVariable String url) {
        return "redirect:" + stub.parse(Url.ParseRequest.newBuilder().setShortUrl(url).build()).getBaseUrl();
    }
}

