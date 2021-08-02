package com.form.adminform.parentsrepository;

import com.form.adminform.parentsmodel.ParentData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParentDataRepository extends JpaRepository<ParentData, Long> {

//    @Query("select u from parental WHERE parental.email =?1")
    @Query
    List<ParentData> findByEmail(String email);
    @Query
    List<ParentData> findByFname(String name);
    @Query
    List<ParentData> findByMname(String name);
    @Query
    List<ParentData> findByLname(String name);

//    @Query("FROM parental WHERE UPPER(fname) LIKE %?#{[0].toUpperCase()}% OR UPPER(mname) LIKE %?#{[0].toUpperCase()}% OR UPPER(lname) LIKE %?#{[0].toUpperCase()}%")
//    List<ParentData> findByName(String name);


}
