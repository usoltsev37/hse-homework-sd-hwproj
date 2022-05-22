package ru.hse.hwproj.logic.rabbit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.hse.hwproj.model.Homework;
import ru.hse.hwproj.repository.HomeworkRepository;
import ru.hse.hwproj.repository.HwSubmissionRepository;
import ru.hse.hwproj.model.HwSubmission;
import ru.hse.hwproj.logic.checker.SubmissionChecker;
import ru.hse.hwproj.util.LoggingHelper;

import java.util.concurrent.*;

@Service
public class RabbitService {

    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitService.class);
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
        LoggingHelper.logWrap(
                LOGGER,
                "checkSubmission",
                () -> loggingCheckSubmission(hwSubmission)
        );
    }

    public void loggingCheckSubmission(HwSubmission hwSubmission) {
        Homework homework = homeworkRepository.getReferenceById(hwSubmission.getHwId());
        Future<HwSubmission> future = threadPool.submit(() -> submissionChecker.checkSubmission(homework.getTitle(), hwSubmission));
        try {
            hwSubmissionRepository.save(future.get());
        } catch (InterruptedException | ExecutionException e) {
            LOGGER.error("checkSubmission: " + e.getMessage());
        }
    }
}
