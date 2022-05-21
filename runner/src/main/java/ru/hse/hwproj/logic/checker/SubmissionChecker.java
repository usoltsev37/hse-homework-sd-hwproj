package ru.hse.hwproj.logic.checker;

import ru.hse.hwproj.dto.HwSubmissionDto;

public interface SubmissionChecker {

    HwSubmissionDto checkSubmission(HwSubmissionDto hwSubmission);
}
