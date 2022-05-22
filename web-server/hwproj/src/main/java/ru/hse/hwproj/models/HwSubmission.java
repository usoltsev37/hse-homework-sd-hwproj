package ru.hse.hwproj.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Accessors(chain = true)
@Table(name = "hw_submission")
public class HwSubmission implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @JsonProperty("id")
    private Long id;

    @Column(name = "hw_id")
    @JsonProperty("hwId")
    private Long hwId;

    @Column(name = "solution")
    @JsonProperty("solution")
    private String solution;

    @Column(name = "created_at")
    @JsonProperty("createdAt")
    @JsonSerialize(using = LocalDateTimeSerializer.class)
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