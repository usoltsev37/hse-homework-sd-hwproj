package ru.hse.hwproj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.hse.hwproj.model.HwSubmission;

import java.util.List;

@Repository
public interface HwSubmissionRepository extends JpaRepository<HwSubmission, Long> {
    List<HwSubmission> findAllByOrderByCreatedAt();

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query("update HwSubmission sub set sub.mark = :mark, sub.comment = :comment where sub.id = :id")
    void updateMarkAndCommentById(@Param("id") Long id, @Param("mark") Integer mark, @Param("comment") String comment);
}
