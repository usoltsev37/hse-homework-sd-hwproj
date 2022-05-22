package ru.hse.hwproj.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.hse.hwproj.models.HwSubmission;
import ru.hse.hwproj.repository.HwSubmissionRepository;
import ru.hse.hwproj.repository.RabbitRepository;
import ru.hse.hwproj.util.LoggingHelper;

import java.util.List;

@Service
public class HwSubmissionService {

    private static final Logger LOGGER = LoggerFactory.getLogger(HwSubmissionService.class);
    private final RabbitRepository rabbitRepository;
    private final HwSubmissionRepository hwSubmissionRepository;

    public HwSubmissionService(
            @Autowired HwSubmissionRepository hwSubmissionRepository,
            @Autowired RabbitRepository rabbitRepository
    ) {
        this.hwSubmissionRepository = hwSubmissionRepository;
        this.rabbitRepository = rabbitRepository;
    }

    public List<HwSubmission> getSortedSubmissions(Long userId, Boolean isTeacher) {
        return LoggingHelper.logWrap(
                LOGGER,
                "getSortedSubmissions",
                () -> loggingGetSortedSubmissions(userId, isTeacher)
        );
    }

    public void evaluateSubmission(Long submissionId, Integer mark, String comment) {
        LoggingHelper.logWrap(
                LOGGER,
                "evaluateSubmission",
                () -> hwSubmissionRepository.updateMarkAndCommentById(submissionId, mark, comment)
        );
    }

    public void submitHomeworkSolution(HwSubmission hwSubmission) {
        LoggingHelper.logWrap(
                LOGGER,
                "submitHomeworkSolution",
                () -> loggingSubmitHomeworkSolution(hwSubmission)
        );
    }

    private List<HwSubmission> loggingGetSortedSubmissions(Long userId, Boolean isTeacher) {
        return isTeacher ? hwSubmissionRepository.findAllByOrderByCreatedAt()
                : hwSubmissionRepository.findAllByStudentIdOrderByCreatedAt(userId);
    }

    private void loggingSubmitHomeworkSolution(HwSubmission hwSubmission) {
        hwSubmissionRepository.save(hwSubmission);
        rabbitRepository.submitHomeworkSolution(hwSubmission);
    }
}
