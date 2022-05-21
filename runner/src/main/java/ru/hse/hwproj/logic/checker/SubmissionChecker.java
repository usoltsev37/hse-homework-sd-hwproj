package ru.hse.hwproj.logic.checker;

import ru.hse.hwproj.model.HwSubmission;

public interface SubmissionChecker {

    HwSubmission checkSubmission(String title, HwSubmission hwSubmission);
}
