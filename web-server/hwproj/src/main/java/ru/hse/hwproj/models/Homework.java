package ru.hse.hwproj.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Accessors(chain = true)
@Table(name = "homeworks")
public class Homework implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @JsonProperty("id")
    private Long id;

    @Column(name = "title")
    @JsonProperty("title")
    private String title;

    @Column(name = "task_description")
    @JsonProperty("taskDescription")
    private String taskDescription;

    @Column(name = "publication_time")
    @JsonProperty("publicationTime")
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime publicationTime;

    @Column(name = "deadline")
    @JsonProperty("deadline")
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime deadline;

}
