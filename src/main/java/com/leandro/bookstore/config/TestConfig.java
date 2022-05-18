package com.leandro.bookstore.config;

import com.leandro.bookstore.service.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TestConfig {
    @Autowired
    private DBService dbServiceTest;

    @Bean
    public void instanceDB() {
        this.dbServiceTest.instanceBD();
    }
}
