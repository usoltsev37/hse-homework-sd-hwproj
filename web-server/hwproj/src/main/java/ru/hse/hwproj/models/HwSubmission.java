package ru.hse.hwproj.models;

import com.fasterxml.jackson.annotation.JsonProperty;
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
    @JsonProperty("id")
    private Long id;

    @Column(name = "hw_id")
    @JsonProperty("hwId")
    private Long hwId;

    @Column(name = "student_id")
    @JsonProperty("studentId")
    private Long studentId;

    @Column(name = "solution")
    @JsonProperty("solution")
    private String solution;

    @Column(name = "created_at")
    @JsonProperty("createdAt")
    private LocalDateTime createdAt;

    @Column(name = "mark")
    @JsonProperty("mark")
    private Integer mark;

    @Column(name = "comment")
    @JsonProperty("comment")
    private String comment;

    @Column(name = "checker_verdict")
    @JsonProperty("checkerVerdict")
    private String checkerVerdict;

}