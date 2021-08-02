package com.form.adminform.studentsrepository;

import com.form.adminform.studentmodel.StudentData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentsRepository extends JpaRepository<StudentData, Long> {
    @Query
    List<StudentData> findByEmail(String email);
    @Query
    List<StudentData> findByFname(String fname);
    @Query
    List<StudentData> findByMname(String mname);
    @Query
    List<StudentData> findByLname(String lname);

}
