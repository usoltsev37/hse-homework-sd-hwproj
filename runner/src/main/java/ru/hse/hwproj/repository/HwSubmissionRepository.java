package ru.hse.hwproj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.hse.hwproj.model.HwSubmission;

@Repository
public interface HwSubmissionRepository extends JpaRepository<HwSubmission, Long> {

}
