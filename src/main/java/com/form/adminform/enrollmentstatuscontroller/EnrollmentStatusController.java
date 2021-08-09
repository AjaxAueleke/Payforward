package com.form.adminform.enrollmentstatuscontroller;


import com.form.adminform.enrollmentstatus.EnrollmentStatus;
import com.form.adminform.enrollmentstatusrepository.EnrollmentStatusRepository;
import com.form.adminform.exceptions.DuplicateRecord;
import com.form.adminform.exceptions.IdNotFound;
import com.form.adminform.parentsmodel.ParentData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class EnrollmentStatusController {
    @Autowired
    EnrollmentStatusRepository enrollmentStatusRepository;

    @GetMapping("/enrollmentstatus")
    public List<EnrollmentStatus> getAll() {
        return enrollmentStatusRepository.findAll();
    }
    @PostMapping("/enrollmentstatus")
    public EnrollmentStatus saveARecord(EnrollmentStatus e) {
        return enrollmentStatusRepository.save(e);
    }
    @PutMapping("/enrollmentstatus/{studentId}")
    public EnrollmentStatus editRecord(@PathVariable(value = "studentId") Long studentId,EnrollmentStatus e) {
        EnrollmentStatus newEnrollment = enrollmentStatusRepository.findByStudentId(studentId);
        newEnrollment.setAcademicYear(e.getAcademicYear());
        newEnrollment.setSundaySchool(e.getSundaySchool());
        newEnrollment.setTuitionAndFeePaid(e.isTuitionAndFeePaid());
        return enrollmentStatusRepository.save(newEnrollment);
    }
    @DeleteMapping("enrollmentstatus/{id}")
    public ResponseEntity<?> deleteRecord(@PathVariable(value = "id") Long id) {
        EnrollmentStatus toBeDeleted = enrollmentStatusRepository.findById(id).orElseThrow(IdNotFound::new);
        enrollmentStatusRepository.delete(toBeDeleted);
        return ResponseEntity.ok().build();
    }
}
