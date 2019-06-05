package com.disi.trainer.DataAccess;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

import java.util.List;

@Entity
public class Entry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer weight;
    private Integer waist;
    private Integer thigh;
    private Integer biceps;
    private Double bfp;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "customerId", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Customer customer;

    public Entry() {
    }

    public Entry(Customer customer, Integer weight, Integer waist, Integer thigh, Integer biceps) {
        this.customer = customer;
        this.weight = weight;
        this.waist = waist;
        this.thigh = thigh;
        this.biceps = biceps;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getWaist() {
        return waist;
    }

    public void setWaist(Integer waist) {
        this.waist = waist;
    }

    public Integer getThigh() {
        return thigh;
    }

    public void setThigh(Integer thigh) {
        this.thigh = thigh;
    }

    public Integer getBiceps() {
        return biceps;
    }

    public void setBiceps(Integer biceps) {
        this.biceps = biceps;
    }

    public Double getBfp() {
        return bfp;
    }

    public void setBfp(Double bfp) {
        this.bfp = bfp;
    }


}
