package ru.hse.hwproj.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.hse.hwproj.models.Homework;
import ru.hse.hwproj.repository.HomeworkRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class HomeworkService {

    private final HomeworkRepository homeworkRepository;

    public HomeworkService(@Autowired HomeworkRepository homeworkRepository) {
        this.homeworkRepository = homeworkRepository;
    }

    public List<Homework> getSortedHomeworks(LocalDateTime time) {

        return homeworkRepository.findAllByOrderByDeadline().stream()
                .filter(hw -> time.compareTo(hw.getPublicationTime()) > 0)
                .collect(Collectors.toList());

    }

    public void addHomework(Homework hw) {
        homeworkRepository.save(hw);
    }
}
