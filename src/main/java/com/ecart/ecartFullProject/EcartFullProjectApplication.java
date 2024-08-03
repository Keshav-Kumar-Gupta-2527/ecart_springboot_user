package com.ecart.ecartFullProject;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication

//@EnableEurekaClient
//@EnableDiscoveryClient
public class EcartFullProjectApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(EcartFullProjectApplication.class, args);
	}
    @Override
	public void run(String ...args) throws Exception {
	System.out.println("Ecart");
	}
	@Bean
	public WebClient.Builder webClientBuilder() {
		return WebClient.builder();
	}
}
