package ru.hse.hwproj.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.hse.hwproj.models.HwSubmission;
import ru.hse.hwproj.models.User;
import ru.hse.hwproj.repository.HwSubmissionRepository;
import ru.hse.hwproj.repository.RabbitRepository;

import java.util.List;

@Service
public class HwSubmissionService {
    @Autowired
    private HwSubmissionRepository hwSubmissionRepository;

    private RabbitRepository rabbitRepository;


    public List<HwSubmission> getSortedSubmissions(User user) {
        return user.isTeacher() ? hwSubmissionRepository.findAllByOrderByCreatedAt()
                : hwSubmissionRepository.findAllByStudentIdOrderByCreatedAt(user.getId());
    }

    public void evaluateSolution(Long submissionId, Integer mark, String comment) {
        hwSubmissionRepository.updateMarkAndCommentById(submissionId, mark, comment);
    }

    public void submitHomeworkSolution(HwSubmission hwSubmission) {
        rabbitRepository.submitHwSolution(hwSubmission);
    }
}
