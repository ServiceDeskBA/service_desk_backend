package com.servicedesk.backend.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    public @Bean com.mongodb.client.MongoClient mongoClient() {
        return com.mongodb.client.MongoClients.create("mongodb+srv://namibo654_db_user:yMCoTECq0lGBAly8@servicedesk.4qiyw3c.mongodb.net/servicedesk");
    }
}
