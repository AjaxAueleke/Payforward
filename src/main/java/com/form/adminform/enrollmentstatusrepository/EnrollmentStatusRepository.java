package com.form.adminform.enrollmentstatusrepository;

import com.form.adminform.enrollmentstatus.EnrollmentStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaAuditing
public interface EnrollmentStatusRepository extends JpaRepository<EnrollmentStatus, Long> {
    @Query
    EnrollmentStatus findByStudentId(Long studentId);
}
