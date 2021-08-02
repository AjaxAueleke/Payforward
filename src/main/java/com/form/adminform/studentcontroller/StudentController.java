package com.form.adminform.studentcontroller;


import com.form.adminform.exceptions.DuplicateRecord;
import com.form.adminform.exceptions.IdNotFound;
import com.form.adminform.studentmodel.StudentData;
import com.form.adminform.studentsrepository.StudentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class StudentController {
    @Autowired
    StudentsRepository studentsRepository;

    @GetMapping("/api/students")
    public List<StudentData> getAllStudents() {
        return studentsRepository.findAll();
    }
    @PostMapping("/api/students")
    public StudentData saveStudent(StudentData s) {
        if (studentsRepository.findByEmail(s.getEmail()).size() == 0) {
           return studentsRepository.save(s);
        }
        throw new DuplicateRecord();
    }
    @GetMapping("/api/students/{name}")
    public List<StudentData> getStudentByName(@PathVariable(value = "name") String name) {
        final List<StudentData> byFName = studentsRepository.findByFname(name);
        final List<StudentData> byMName = studentsRepository.findByMname(name);
        final List<StudentData> byLName = studentsRepository.findByLname(name);
        for (int i = 0; i < byMName.size(); i++) {
            byFName.add(byMName.get(i));
        }
        for (int i = 0; i < byLName.size(); i++) {
            byFName.add(byLName.get(i));
        }
        return byFName;
    }

    @DeleteMapping("/api/students/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable(value = "id") Long id) {
        StudentData toBeDeleted = studentsRepository.findById(id).orElseThrow(() ->  new IdNotFound());
        studentsRepository.delete(toBeDeleted);
        return ResponseEntity.ok().build();
    }
}
