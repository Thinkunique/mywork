package com.online.products;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.kafka.core.KafkaTemplate;

import com.online.model.AuctionEvent;
import com.online.repository.CarRepository;
import com.online.repository.PhotoRepository;
import com.online.service.AuctionEventService;
import com.online.service.PhotoService;

@Profile("test")
@Configuration
@ComponentScan(basePackages= {"com.online.service.impl","com.online.model","com.online.aspect","com.online.exception"})
public class TestConfig {

	@Bean
    @Primary
    public CarRepository repository() {
        return Mockito.mock(CarRepository.class);
    }
	
	@Bean
    @Primary
    public PhotoRepository photoRepository() {
        return Mockito.mock(PhotoRepository.class);
    }
	
	@Bean
    @Primary
    public KafkaTemplate<String,AuctionEvent> kafkaTemplate() {
        return Mockito.mock(KafkaTemplate.class);
    }
	
	@Bean
    @Primary
    public AuctionEventService auctionEvent() {
        return Mockito.mock(AuctionEventService.class);
    }
	
	@Bean
    @Primary
    public PhotoService photoService() {
        return Mockito.mock(PhotoService.class);
    }
	
}
