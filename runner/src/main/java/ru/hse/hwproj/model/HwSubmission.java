package ru.hse.hwproj.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Accessors(chain = true)
@Table(name = "hw_submission")
public class HwSubmission {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "hw_id")
    private Long hwId;

    @Column(name = "student_id")
    private Long studentId;

    @Column(name = "solution")
    private String solution;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "mark")
    private Integer mark;

    @Column(name = "comment")
    private String comment;

    @Column(name = "checker_verdict")
    private String checkerVerdict;

}