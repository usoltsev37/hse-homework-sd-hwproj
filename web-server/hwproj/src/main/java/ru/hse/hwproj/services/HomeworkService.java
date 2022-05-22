package ru.hse.hwproj.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.hse.hwproj.model.Homework;
import ru.hse.hwproj.repository.HomeworkRepository;
import ru.hse.hwproj.util.LoggingHelper;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class HomeworkService {

    private static final Logger LOGGER = LoggerFactory.getLogger(HomeworkService.class);
    private final HomeworkRepository homeworkRepository;

    public HomeworkService(@Autowired HomeworkRepository homeworkRepository) {
        this.homeworkRepository = homeworkRepository;
    }

    public List<Homework> getSortedHomeworks(LocalDateTime time) {
        return LoggingHelper.logWrap(
                LOGGER,
                "getSortedHomeworks",
                () -> loggingGetSortedHomeworks(time)
        );
    }

    public void addHomework(Homework hw) {
        LoggingHelper.logWrap(
                LOGGER,
                "addHomework",
                () -> homeworkRepository.save(hw)
        );
    }

    private List<Homework> loggingGetSortedHomeworks(LocalDateTime time) {
        return homeworkRepository.findAllByOrderByDeadline().stream()
                .filter(hw -> time.compareTo(hw.getPublicationTime()) > 0)
                .collect(Collectors.toList());
    }
}
