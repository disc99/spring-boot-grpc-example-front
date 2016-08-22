package com.example;

import io.example.url.Url;
import io.example.url.UrlServiceGrpc;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
class ShortCutServiceClient {
    UrlServiceGrpc.UrlServiceBlockingStub stub;

    String shortcut(String url) {
        return stub.shortcut(Url.ShortcutRequest.newBuilder().setBaseUrl(url).build()).getShortUrl();
    }

    String parse(String url) {
        return stub.parse(Url.ParseRequest.newBuilder().setShortUrl(url).build()).getBaseUrl();
    }
}
