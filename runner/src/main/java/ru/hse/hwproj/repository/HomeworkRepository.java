package ru.hse.hwproj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.hse.hwproj.model.Homework;

@Repository
public interface HomeworkRepository extends JpaRepository<Homework, Long> {
}
