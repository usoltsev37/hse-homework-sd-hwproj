package ru.hse.hwproj.logic.rabbit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.hse.hwproj.dao.RabbitDao;
import ru.hse.hwproj.dto.HwSubmissionDto;
import ru.hse.hwproj.logic.checker.SubmissionChecker;

@Service
public class RabbitService {

    @Autowired
    SubmissionChecker submissionChecker;

    @Autowired
    RabbitDao rabbitDao;

    public void checkSubmission(HwSubmissionDto hwSubmission) {
        hwSubmission = submissionChecker.checkSubmission(hwSubmission);
        rabbitDao.save(hwSubmission);
    }
}
