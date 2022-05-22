package ru.hse.hwproj.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import ru.hse.hwproj.repository.RabbitRepository;

@Configuration
public class RabbitConfig {

    @Bean
    public Queue queue() {
        return new Queue("homework");
    }
}
