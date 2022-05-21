package ru.hse.hwproj.controller;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.hse.hwproj.model.HwSubmission;
import ru.hse.hwproj.logic.rabbit.RabbitService;

@Component
@RabbitListener(queues = "homework")
public class RabbitController {

    private final RabbitService rabbitService;

    public RabbitController(@Autowired RabbitService rabbitService) {
        this.rabbitService = rabbitService;
    }

    @RabbitHandler
    public void pollHomeworkSubmission(HwSubmission hwSubmission) {
        rabbitService.checkSubmission(hwSubmission);
        System.out.println(" [x] Received '" + hwSubmission + "'");
    }
}
