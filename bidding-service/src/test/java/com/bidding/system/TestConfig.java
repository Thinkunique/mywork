package com.bidding.system;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.kafka.core.KafkaTemplate;

import com.bidding.consumer.event.service.AuctionEventConsumer;
import com.bidding.producer.event.service.AuctionEventProducer;
import com.bidding.repository.AuctionRepository;
import com.bidding.repository.BiddingRepository;
import com.bidding.repository.RedisRepository;
import com.bidding.service.AuctionService;
import com.online.model.AuctionEvent;

@Profile("test")
@Configuration
@ComponentScan(basePackages= {"com.bidding.service.impl","com.bidding.model","com.bidding.aspect","com.bidding.exception","com.bidding.repository","com.bidding.repository.impl","com.bidding.validate.service","com.bidding.validate.service.impl","com.bidding.consumer.event.service.impl","com.bidding.producer.event.service.impl"})
public class TestConfig {

	@Bean
    @Primary
    public AuctionRepository repository() {
        return Mockito.mock(AuctionRepository.class);
    }
	
	@Bean
    @Primary
    public BiddingRepository biddingRepository() {
        return Mockito.mock(BiddingRepository.class);
    }
	
	@Bean
    @Primary
    public RedisRepository redisRepository() {
        return Mockito.mock(RedisRepository.class);
    }
	
	@Bean
    @Primary
    public KafkaTemplate<String,AuctionEvent> kafkaTemplate() {
        return Mockito.mock(KafkaTemplate.class);
    }
	
	@Bean
    @Primary
    public RedisTemplate<String, String> redisTemplate() {
        return Mockito.mock(RedisTemplate.class);
    }
	
	@Bean
    @Primary
    public AuctionEventProducer auctionEvent() {
        return Mockito.mock(AuctionEventProducer.class);
    }
	
	@Bean
    @Primary
    public AuctionEventConsumer auctionEventConsumer() {
        return Mockito.mock(AuctionEventConsumer.class);
    }
	
	@Bean
    @Primary
    public AuctionService auctionService() {
        return Mockito.mock(AuctionService.class);
    }
}
