package com.form.adminform.controller;


import com.form.adminform.exception.DuplicateRecord;
import com.form.adminform.exception.IdNotFound;
import com.form.adminform.model.ParentData;
import com.form.adminform.repository.ParentDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class ParentDataController {
    @Autowired
    ParentDataRepository parentDataRepository;
    @CrossOrigin
    @GetMapping("/parent")
    public List<ParentData> getAllData() {
        return parentDataRepository.findAll();
    }
    @CrossOrigin
    @PostMapping("/parent")
    public ParentData saveData(ParentData p) {
        List<ParentData> emailCheck = parentDataRepository.findByEmail(p.getEmail());
        if (!(emailCheck.size() == 0)) {
            throw new DuplicateRecord();
        }
        System.out.println(emailCheck);
        return parentDataRepository.save(p);
    }
    @CrossOrigin
    @GetMapping("/parent/{name}")
    public List<ParentData> getDataByName(@PathVariable(value = "name") String parentName) {
        final List<ParentData> byFName = parentDataRepository.findByFname(parentName);
        final List<ParentData> byMName = parentDataRepository.findByMname(parentName);
        final List<ParentData> byLName = parentDataRepository.findByLname(parentName);
        for (int i = 0; i < byMName.size(); i++) {
            byFName.add(byMName.get(i));
        }
        for (int i = 0; i < byLName.size(); i++) {
            byFName.add(byLName.get(i));
        }
        return byFName;
    }

    @CrossOrigin
    @DeleteMapping("/parent/{id}")
    public ResponseEntity<?> deleteRecord(@PathVariable(value = "id") Long id) {
        ParentData toBeDeleted = parentDataRepository.findById(id).orElseThrow(() ->  new IdNotFound());
        parentDataRepository.delete(toBeDeleted);
        return ResponseEntity.ok().build();
    }


}
