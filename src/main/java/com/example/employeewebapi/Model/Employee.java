package com.example.employeewebapi.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "employees")
public class Employee {

    public Employee(){

    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long EMPLOYEEID;
    @Column(name = "firstname")
    private String FIRSTNAME;
    @Column(name = "lastname")
    private String LASTNAME;
    @Column(name = "emailaddress")
    private String EMAILADDRESS;
    @Column(name = "jobtitle")
    private String JOBTITLE;
    @Column(name = "department")
    private String DEPARTMENT;
    @Column(name = "location")
    private String LOCATION;
    @Column(name = "managerreporting")
    private String MANAGERREPORTING;
    //
    @Column(name = "phone")
    private String PHONE;
    //Store as a UNIX timestamp
    @Column(name = "birthdate")
    private String BIRTHDATE;
    @Column(name = "startdate")
    private String STARTDATE;


    public Long getEMPLOYEEID() {
        return EMPLOYEEID;
    }

    public void setEMPLOYEEID(Long EMPLOYEEID) {
        this.EMPLOYEEID = EMPLOYEEID;
    }

    public String getFIRSTNAME() {
        return FIRSTNAME;
    }

    public void setFIRSTNAME(String FIRSTNAME) {
        this.FIRSTNAME = FIRSTNAME;
    }

    public String getLASTNAME() {
        return LASTNAME;
    }

    public void setLASTNAME(String LASTNAME) {
        this.LASTNAME = LASTNAME;
    }

    public String getEMAILADDRESS() {
        return EMAILADDRESS;
    }

    public void setEMAILADDRESS(String EMAILADDRESS) {
        this.EMAILADDRESS = EMAILADDRESS;
    }

    public String getJOBTITLE() {
        return JOBTITLE;
    }

    public void setJOBTITLE(String JOBTITLE) {
        this.JOBTITLE = JOBTITLE;
    }

    public String getDEPARTMENT() {
        return DEPARTMENT;
    }

    public void setDEPARTMENT(String DEPARTMENT) {
        this.DEPARTMENT = DEPARTMENT;
    }

    public String getLOCATION() {
        return LOCATION;
    }

    public void setLOCATION(String LOCATION) {
        this.LOCATION = LOCATION;
    }

    public String getMANAGERREPORTING() {
        return MANAGERREPORTING;
    }

    public void setMANAGERREPORTING(String MANAGERREPORTING) {
        this.MANAGERREPORTING = MANAGERREPORTING;
    }

    public String getPHONE() {
        return PHONE;
    }

    public void setPHONE(String PHONE) {
        this.PHONE = PHONE;
    }

    public String getBIRTHDATE() {
        return BIRTHDATE;
    }

    public void setBIRTHDATE(String BIRTHDATE) {
        this.BIRTHDATE = BIRTHDATE;
    }

    public String getSTARTDATE() {
        return STARTDATE;
    }

    public void setSTARTDATE(String STARTDATE) {
        this.STARTDATE = STARTDATE;
    }



}
