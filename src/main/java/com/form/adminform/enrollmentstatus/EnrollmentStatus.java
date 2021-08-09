package com.form.adminform.enrollmentstatus;

import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "enrollment")
public class EnrollmentStatus {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Enrollment_id;
    private Long studentid;
    private String sundaySchool;
    private double tuitionFee;
    private String academicYear;
    private boolean tuitionAndFeePaid;

    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedOn;

    public EnrollmentStatus() {
        //Default Constructor : To avoid errors
    }

    public EnrollmentStatus(Long studentid, String sundaySchool, double tuitionFee, String academicYear, boolean tuitionAndFeePaid) {
        this.studentid = studentid;
        this.sundaySchool = sundaySchool;
        this.tuitionFee = tuitionFee;
        this.academicYear = academicYear;
        this.tuitionAndFeePaid = tuitionAndFeePaid;
    }


    public Long getEnrollment_id() {
        return Enrollment_id;
    }

    public void setEnrollment_id(Long enrollment_id) {
        Enrollment_id = enrollment_id;
    }

    public Long getStudentid() {
        return studentid;
    }

    public void setStudentid(Long studentid) {
        this.studentid = studentid;
    }

    public String getSundaySchool() {
        return sundaySchool;
    }

    public void setSundaySchool(String sundaySchool) {
        this.sundaySchool = sundaySchool;
    }

    public double getTuitionFee() {
        return tuitionFee;
    }

    public void setTuitionFee(double tuitionFee) {
        this.tuitionFee = tuitionFee;
    }

    public String getAcademicYear() {
        return academicYear;
    }

    public void setAcademicYear(String academicYear) {
        this.academicYear = academicYear;
    }

    public boolean isTuitionAndFeePaid() {
        return tuitionAndFeePaid;
    }

    public void setTuitionAndFeePaid(boolean tuitionAndFeePaid) {
        this.tuitionAndFeePaid = tuitionAndFeePaid;
    }

    public Date getLastModifiedOn() {
        return lastModifiedOn;
    }

    public void setLastModifiedOn(Date lastModifiedOn) {
        this.lastModifiedOn = lastModifiedOn;
    }
}
