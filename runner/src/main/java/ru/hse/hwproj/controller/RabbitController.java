package ru.hse.hwproj.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.hse.hwproj.model.HwSubmission;
import ru.hse.hwproj.logic.rabbit.RabbitService;
import ru.hse.hwproj.util.LoggingHelper;

@Component
@RabbitListener(queues = "homework")
public class RabbitController {

    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitController.class);
    private final RabbitService rabbitService;

    public RabbitController(@Autowired RabbitService rabbitService) {
        this.rabbitService = rabbitService;
    }

    @RabbitHandler
    public void pollHomeworkSubmission(HwSubmission hwSubmission) {
        LoggingHelper.logWrap(
                LOGGER,
                "pollHomeworkSubmission",
                () -> rabbitService.checkSubmission(hwSubmission)
        );
    }
}
