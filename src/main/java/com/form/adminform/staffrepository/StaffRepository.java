package com.form.adminform.staffrepository;


import com.form.adminform.staffmodel.StaffData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StaffRepository extends JpaRepository<StaffData, Long> {
    @Query
    List<StaffData> findByEmail(String email);
    @Query
    List<StaffData> findByFirstname(String name);
    @Query
    List<StaffData> findByLastname(String name);
    @Query
    List<StaffData> findByMiddlename(String name);
}
