package ru.hse.hwproj.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "hw_id")
    private Long hwId;

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
