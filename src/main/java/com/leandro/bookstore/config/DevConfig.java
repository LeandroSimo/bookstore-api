package com.leandro.bookstore.config;

import com.leandro.bookstore.service.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")
public class DevConfig {

    @Autowired
    private DBService dbServiceDev;
    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String strategy;

    @Bean
    public boolean instanceDB() {
        if (strategy.equals("create")) {
            this.dbServiceDev.instanceDB();
        }
        return false;
    }
}
