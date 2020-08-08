package com.bidding.system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories("com.bidding.repository")
@ComponentScan(basePackages= {"com.bidding.configuration","com.bidding.controller","com.bidding.service.impl","com.bidding.model","com.bidding.aspect","com.bidding.exception","com.bidding.repository","com.bidding.repository.impl","com.bidding.validate.service","com.bidding.validate.service.impl"})
public class BiddingApplication {

	public static void main(String[] args) {
		SpringApplication.run(BiddingApplication.class, args);
	}

}
