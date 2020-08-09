package com.online.users;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

import com.online.repository.UserRepository;


@Profile("test")
@Configuration
@ComponentScan(basePackages= {"com.online.service.impl","com.online.model","com.online.aspect","com.online.exception"})
public class TestConfig {

	@Bean
    @Primary
    public UserRepository repository() {
        return Mockito.mock(UserRepository.class);
    }
}
