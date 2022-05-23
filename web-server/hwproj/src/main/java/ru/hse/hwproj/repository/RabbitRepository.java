package ru.hse.hwproj.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.hse.hwproj.model.HwSubmission;
import ru.hse.hwproj.util.LoggingHelper;

@Component
public class RabbitRepository {

    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitRepository.class);
    private final RabbitTemplate template;

    public RabbitRepository(
            @Autowired RabbitTemplate rabbitTemplate
    ) {
        this.template = rabbitTemplate;
        this.template.setMessageConverter(new Jackson2JsonMessageConverter());
    }

    public void submitHomeworkSolution(HwSubmission hwSubmission) {
        LoggingHelper.logWrap(
                LOGGER,
                "submitHomeworkSolution",
                () -> template.convertAndSend("my_topic_exchange", "routing_key", hwSubmission)
        );
    }
}
