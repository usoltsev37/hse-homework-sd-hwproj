package ru.hse.hwproj.repository;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.hse.hwproj.models.HwSubmission;

@Component
public class RabbitRepository {

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
        this.template.convertAndSend(queue.getName(), hwSubmission);
        System.out.println(" [x] Sent '" + hwSubmission + "'");
    }
}
