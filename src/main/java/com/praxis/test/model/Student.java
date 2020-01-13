package com.praxis.test.model;

import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.*;

@Entity
@Table(name = "students")
public class Student extends Person {

    private Long studentNumber;

    private Double averageMark;

    private int seminarsToken;

    private Boolean isElegibleToEnroll;

    public Student() { }

    public Student(Long id, String name, String phoneNumber, String emailAddress, Address address, Long studentNumber, Double averageMark, Integer seminarsToken) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.address = address;
        this.studentNumber = studentNumber;
        this.averageMark = averageMark;
        this.seminarsToken = seminarsToken;
    }

    @Override
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    @Column(name = "phone", nullable = true)
    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    @Column(name = "email", nullable = true)
    public String getEmailAddress() {
        return emailAddress;
    }

    @Override
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

   @ManyToOne(cascade=CascadeType.ALL)
   @Override
   public Address getAddress() {
        return address;
    }

    @Override
    public void setAddress(Address address) {
        this.address = address;
    }

    public Long getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(Long studentNumber) {
        this.studentNumber = studentNumber;
    }

    public Double getAverageMark() {
        return averageMark;
    }

    public void setAverageMark(Double averageMark) {
        this.averageMark = averageMark;
    }

    public int getSeminarsToken() {
        return seminarsToken;
    }

    public void setSeminarsToken(int seminarsToken) {
        this.seminarsToken = seminarsToken;
    }

    public Boolean isElegibleToEnroll() {
        return isElegibleToEnroll;
    }

    public void setElegibleToEnroll(Boolean elegibleToEnroll) {
        isElegibleToEnroll = elegibleToEnroll;
    }
}
