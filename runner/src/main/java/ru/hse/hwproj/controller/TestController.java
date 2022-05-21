package ru.hse.hwproj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.hse.hwproj.logic.rabbit.RabbitService;
import ru.hse.hwproj.model.HwSubmission;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/hw")
public class TestController {

    @Autowired
    private RabbitController rabbitController;

    @GetMapping("/all")
    public void getHomeworks() {
        rabbitController.pollHwSubmission(new HwSubmission(1L, 1L, 1L, "https://github.com/usoltsev37/hse-homework-sd-hwproj", LocalDateTime.now(), 1, null, null));
    }
}
