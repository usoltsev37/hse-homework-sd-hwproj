package ru.hse.hwproj.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hse.hwproj.models.Homework;
import ru.hse.hwproj.models.HwSubmission;
import ru.hse.hwproj.services.HomeworkService;
import ru.hse.hwproj.services.HwSubmissionService;
import ru.hse.hwproj.util.LoggingHelper;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/hw")
public class HwController {

    private static final Logger LOGGER = LoggerFactory.getLogger(HwController.class);
    private final HwSubmissionService hwSubmissionService;
    private final HomeworkService homeworkService;

    public HwController(
            @Autowired HwSubmissionService hwSubmissionService,
            @Autowired HomeworkService homeworkService
    ) {
        this.hwSubmissionService = hwSubmissionService;
        this.homeworkService = homeworkService;
    }

    @GetMapping("/all")
    public List<Homework> getHomeworks(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
                                       LocalDateTime date) {
        return LoggingHelper.logWrap(
                LOGGER,
                "getHomeworks",
                () -> homeworkService.getSortedHomeworks(date)
        );
    }

    @PostMapping("/submit")
    public void submitHomeworkSolution(@RequestBody HwSubmission hwSubmission) {
        LoggingHelper.logWrap(
                LOGGER,
                "submitHomeworkSolution",
                () -> hwSubmissionService.submitHomeworkSolution(hwSubmission)
        );
    }

    @GetMapping("/submissions")
    public List<HwSubmission> getSubmissions(@RequestParam Long userId, @RequestParam Boolean isTeacher) {
        return LoggingHelper.logWrap(
                LOGGER,
                "getSubmissions",
                () -> hwSubmissionService.getSortedSubmissions(userId, isTeacher)
        );
    }

    @PostMapping("/add")
    public void addHomework(@RequestBody Homework homework) {
        LoggingHelper.logWrap(
                LOGGER,
                "addHomework",
                () -> homeworkService.addHomework(homework)
        );
    }

    @PatchMapping("/sub_id={submission_id}")
    public ResponseEntity<?> evaluateSubmission(@RequestParam Integer mark,
                                                @RequestParam String comment,
                                                @PathVariable("submission_id") Long submissionId) {
        LoggingHelper.logWrap(
                LOGGER,
                "evaluateSubmission",
                () -> hwSubmissionService.evaluateSubmission(submissionId, mark, comment)
        );
        return ResponseEntity.ok("OK!");
    }
}

