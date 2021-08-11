package com.form.adminform.staffcontroller;

import com.form.adminform.exceptions.DuplicateRecord;
import com.form.adminform.exceptions.IdNotFound;
import com.form.adminform.staffmodel.StaffData;
import com.form.adminform.staffrepository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class StaffController {
    @Autowired
    StaffRepository staffRepository;

    @GetMapping("/staff")
    public List<StaffData> getAll() {
        return staffRepository.findAll();
    }
    @GetMapping("/staff/{id}")
    public StaffData getStaff(@PathVariable(value="id") Long id) {
        return staffRepository.findById(id).orElseThrow(IdNotFound::new);
    }
    @GetMapping("/staff/{name}")
    public List<StaffData> getStaffByName(@PathVariable(value = "name") String name) {
        final List<StaffData> byFName = staffRepository.findByFirstname(name);
        final List<StaffData> byMName = staffRepository.findByMiddlename(name);
        final List<StaffData> byLName = staffRepository.findByLastname(name);
        for (int i = 0; i < byMName.size(); i++) {
            byFName.add(byMName.get(i));
        }
        for (int i = 0; i < byLName.size(); i++) {
            byFName.add(byLName.get(i));
        }
        return byFName;
    }
    @PostMapping("/staff")
    public StaffData saveStaff(StaffData e) {
        List<StaffData> emailCheck = staffRepository.findByEmail(e.getEmail());
        if (!(emailCheck.size() == 0)) {
            throw new DuplicateRecord();
        }
        System.out.println(emailCheck);
        return staffRepository.save(e);
    }
}
