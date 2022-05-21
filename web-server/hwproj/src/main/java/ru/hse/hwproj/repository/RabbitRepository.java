package ru.hse.hwproj.repository;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.hse.hwproj.models.HwSubmission;

@Component
public class RabbitRepository {

    @Autowired
    private RabbitTemplate template;

    @Autowired
    private Queue queue;

    public void submitHomeworkSolution(HwSubmission hwSubmission) {
        this.template.convertAndSend(queue.getName(), hwSubmission);
        System.out.println(" [x] Sent '" + hwSubmission + "'");
    }
}
