package com.disi.trainer.DataAccess;


import javax.persistence.*;
import java.util.Set;


@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private int age;
    private String phoneNo;
    private String mail;
    private Integer trainerId;
    @OneToMany(mappedBy = "customerId")
    private Set<Entry> entries;

    public Customer() {
    }

    public Customer(String name, int age, String phoneNo, String mail, Integer trainerId) {
        this.name = name;
        this.age = age;
        this.phoneNo = phoneNo;
        this.mail = mail;
        this.trainerId = trainerId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Integer getTrainerId() {
        return trainerId;
    }

    public void setTrainerId(Integer trainerId) {
        this.trainerId = trainerId;
    }
}
