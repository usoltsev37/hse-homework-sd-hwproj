package ru.hse.hwproj.controller;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import ru.hse.hwproj.model.HwSubmission;
import ru.hse.hwproj.logic.rabbit.RabbitService;

@RabbitListener(queues = "homework")
public class RabbitController {

    @Autowired
    RabbitService rabbitService;

    @RabbitHandler
    public void pollHwSubmission(HwSubmission hwSubmission) {
        rabbitService.checkSubmission(hwSubmission);
        System.out.println(" [x] Received '" + hwSubmission + "'");
    }
}
