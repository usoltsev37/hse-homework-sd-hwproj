package ru.hse.hwproj.repository;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import ru.hse.hwproj.models.HwSubmission;

public class RabbitRepository {

    @Autowired
    private RabbitTemplate template;

    @Autowired
    private Queue queue;

    public void submitHwSolution(HwSubmission hwSubmission) {
        this.template.convertAndSend(queue.getName(), hwSubmission);
        System.out.println(" [x] Sent '" + hwSubmission + "'");
    }
}
