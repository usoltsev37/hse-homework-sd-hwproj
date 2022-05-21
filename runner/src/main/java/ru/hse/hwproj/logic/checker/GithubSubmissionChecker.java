package ru.hse.hwproj.logic.checker;

import ru.hse.hwproj.model.HwSubmission;

public class GithubSubmissionChecker implements SubmissionChecker {
    @Override
    public HwSubmission checkSubmission(HwSubmission hwSubmission) {
        return hwSubmission;
    }
}
