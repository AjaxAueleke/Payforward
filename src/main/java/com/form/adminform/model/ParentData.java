package com.form.adminform.model;


import javax.persistence.*;

@Entity
@Table(name = "parental")
public class ParentData {

    //primary key
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fname;// First + Middle + Last
    private String mname;
    private String lname;
    private String address;
    private String phone1;
    private String phone2;
    private String email;
    private boolean sms;

    public ParentData(String fname, String mname, String lname, String address, String phone1, String phone2, String email, boolean sms) {
        this.fname = fname;
        this.mname = mname;
        this.lname = lname;
        this.address = address;
        this.phone1 = phone1;
        this.phone2 = phone2;
        this.email = email;
        this.sms = sms;
    }
    public ParentData() {
        //Default constuctor for errors
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone1() {
        return phone1;
    }

    public void setPhone1(String phone1) {
        this.phone1 = phone1;
    }

    public String getPhone2() {
        return phone2;
    }

    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isSms() {
        return sms;
    }

    public void setSms(boolean sms) {
        this.sms = sms;
    }
}
