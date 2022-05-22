package ru.hse.hwproj.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.hse.hwproj.model.Homework;

@Repository
public interface HomeworkRepository extends CrudRepository<Homework, Long> {

}
