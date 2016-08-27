package com.example;

import io.example.url.UrlServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootGrpcExampleFrontApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootGrpcExampleFrontApplication.class, args);
	}

	@Bean
	UrlServiceGrpc.UrlServiceBlockingStub urlServiceBlockingStub() {
		ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 6565)
				.usePlaintext(true)
				.build();
		return UrlServiceGrpc.newBlockingStub(channel);
	}
}
