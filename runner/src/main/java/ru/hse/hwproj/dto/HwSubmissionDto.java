package ru.hse.hwproj.dto;

import java.sql.Timestamp;

public class HwSubmissionDto {
    private Long id;
    private Long hwId;
    private Long studentId;
    private Timestamp createdAt;
    private String solution;
    private Integer mark;
    private String comment;
    private String checkerVerdict;
}
