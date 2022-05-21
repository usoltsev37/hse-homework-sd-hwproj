package ru.hse.hwproj.controller;
import org.apache.commons.logging.Log;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import ru.hse.hwproj.dto.HwSubmissionDto;
import ru.hse.hwproj.logic.rabbit.RabbitService;

@RabbitListener(queues = "homework")
public class RabbitController {

    @Autowired
    RabbitService rabbitService;

    @RabbitHandler
    public void pollHwSubmission(HwSubmissionDto hwSubmission) {
        rabbitService.checkSubmission(hwSubmission);
        System.out.println(" [x] Received '" + hwSubmission + "'");
    }
}
