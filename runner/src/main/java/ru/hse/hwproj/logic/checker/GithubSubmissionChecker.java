package ru.hse.hwproj.logic.checker;

import ru.hse.hwproj.dto.HwSubmissionDto;

public class GithubSubmissionChecker implements SubmissionChecker {
    @Override
    public HwSubmissionDto checkSubmission(HwSubmissionDto hwSubmission) {
        return new HwSubmissionDto();
    }
}
