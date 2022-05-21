package ru.hse.hwproj.logic.rabbit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.hse.hwproj.repository.RabbitRepository;
import ru.hse.hwproj.model.HwSubmission;
import ru.hse.hwproj.logic.checker.SubmissionChecker;

@Service
public class RabbitService {

    @Autowired
    SubmissionChecker submissionChecker;

    @Autowired
    RabbitRepository rabbitRepository;

    public void checkSubmission(HwSubmission hwSubmission) {
        hwSubmission = submissionChecker.checkSubmission(hwSubmission);
        rabbitRepository.save(hwSubmission);
    }
}
