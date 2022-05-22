package ru.hse.hwproj.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.hse.hwproj.models.HwSubmission;
import ru.hse.hwproj.util.LoggingHelper;

@Component
public class RabbitRepository {

    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitRepository.class);
    private final RabbitTemplate template;
    private final Queue queue;

    public RabbitRepository(
            @Autowired RabbitTemplate rabbitTemplate,
            @Autowired Queue queue
    ) {
        this.template = rabbitTemplate;
        this.queue = queue;
    }

    public void submitHomeworkSolution(HwSubmission hwSubmission) {
        LoggingHelper.logWrap(
                LOGGER,
                "submitHomeworkSolution",
                () -> template.convertAndSend(queue.getName(), hwSubmission)
        );
    }
}
