package ru.hse.hwproj.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.hse.hwproj.models.HwSubmission;
import ru.hse.hwproj.repository.HwSubmissionRepository;
import ru.hse.hwproj.repository.RabbitRepository;

import java.util.List;

@Service
public class HwSubmissionService {


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
        return isTeacher ? hwSubmissionRepository.findAllByOrderByCreatedAt()
                : hwSubmissionRepository.findAllByStudentIdOrderByCreatedAt(userId);
    }

    public void evaluateSubmission(Long submissionId, Integer mark, String comment) {
        hwSubmissionRepository.updateMarkAndCommentById(submissionId, mark, comment);
    }

    public void submitHomeworkSolution(HwSubmission hwSubmission) {
        hwSubmissionRepository.save(hwSubmission);
        rabbitRepository.submitHomeworkSolution(hwSubmission);
    }
}
