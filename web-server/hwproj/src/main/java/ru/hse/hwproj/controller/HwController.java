package ru.hse.hwproj.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hse.hwproj.models.Homework;
import ru.hse.hwproj.models.HwSubmission;
import ru.hse.hwproj.models.User;
import ru.hse.hwproj.services.HomeworkService;
import ru.hse.hwproj.services.HwSubmissionService;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/hw")
public class HwController {
    @Autowired
    private HwSubmissionService hwSubmissionService;

    @Autowired
    private HomeworkService homeworkService;

    @GetMapping("/all")
    public List<Homework> getHomeworks(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
                                           LocalDateTime date) {
        return homeworkService.getSortedHomeworks(date);
    }

    @PostMapping("/submit")
    public void submitHomeworkSolution(@RequestBody HwSubmission hwSubmission) {
        hwSubmissionService.submitHomeworkSolution(hwSubmission);
    }

    @GetMapping("/submissions")
    public List<HwSubmission> getSubmissions(@RequestParam Long userId, @RequestParam Boolean isTeacher) {
        return hwSubmissionService.getSortedSubmissions(userId, isTeacher);
    }

    @PostMapping("/add")
    public void addHomework(@RequestBody Homework homework) {
        homeworkService.addHomework(homework);
    }

    @PatchMapping("/sub_id={submission_id}")
    public ResponseEntity<?> evaluateSubmission(@RequestParam Integer mark,
                                                @RequestParam String comment,
                                                @PathVariable("submission_id") Long submissionId) {
        hwSubmissionService.evaluateSolution(submissionId, mark, comment);
        return ResponseEntity.ok("OK!");
    }
}

