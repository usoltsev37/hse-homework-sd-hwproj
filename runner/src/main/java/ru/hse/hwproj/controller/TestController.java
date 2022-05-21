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
        rabbitController.pollHwSubmission(new HwSubmission()
                .setId(1L)
                .setHwId(1L)
                .setStudentId(1L)
                .setCheckerVerdict("")
                .setComment("")
                .setCreatedAt(LocalDateTime.now())
                .setMark(1)
                .setSolution(""));
    }
}
