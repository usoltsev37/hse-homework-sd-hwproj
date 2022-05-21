package ru.hse.hwproj.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import ru.hse.hwproj.controller.RabbitController;

@Configuration
public class RabbitConfig {

    @Bean
    public Queue hello() {
        return new Queue("homework");
    }

    @Profile("receiver")
    @Bean
    public RabbitController receiver() {
        return new RabbitController();
    }
}
