package ru.hse.hwproj.logic.rabbit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.hse.hwproj.model.Homework;
import ru.hse.hwproj.repository.HomeworkRepository;
import ru.hse.hwproj.repository.HwSubmissionRepository;
import ru.hse.hwproj.model.HwSubmission;
import ru.hse.hwproj.logic.checker.SubmissionChecker;

import java.util.concurrent.*;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class RabbitService {

    private final SubmissionChecker submissionChecker;
    private final HwSubmissionRepository hwSubmissionRepository;
    private final HomeworkRepository homeworkRepository;
    private final ExecutorService threadPool = Executors.newFixedThreadPool(4);

    public RabbitService(
            @Autowired SubmissionChecker submissionChecker,
            @Autowired HwSubmissionRepository hwSubmissionRepository,
            @Autowired HomeworkRepository homeworkRepository
    ) {
        this.submissionChecker = submissionChecker;
        this.hwSubmissionRepository = hwSubmissionRepository;
        this.homeworkRepository = homeworkRepository;
    }

    public void checkSubmission(HwSubmission hwSubmission) {
        Homework homework = homeworkRepository.getReferenceById(hwSubmission.getHwId());
        Future<HwSubmission> future = threadPool.submit(() -> submissionChecker.checkSubmission(homework.getTitle(), hwSubmission));
        try {
            hwSubmissionRepository.save(future.get());
        } catch (InterruptedException | ExecutionException e) {
            Logger.getGlobal().log(Level.WARNING, "Error during task checking");
        }
    }
}
