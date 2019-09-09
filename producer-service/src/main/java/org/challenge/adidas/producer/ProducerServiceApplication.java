package org.challenge.adidas.producer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Service producer
 */
@Slf4j
@EnableEurekaClient
@SpringBootApplication
public class ProducerServiceApplication {

	public static void main(String[] args) {

		SpringApplication.run(ProducerServiceApplication.class, args);
		log.info("Simple log statement with inputs {}, {} and {}", 1, 2, 3);
	}
}
