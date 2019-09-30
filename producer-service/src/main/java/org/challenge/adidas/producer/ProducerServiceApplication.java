package org.challenge.adidas.producer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Service producer
 */
@EnableEurekaClient
@SpringBootApplication
public class ProducerServiceApplication {

	public static void main(String[] args) {

		SpringApplication.run(ProducerServiceApplication.class, args);
	}
}
