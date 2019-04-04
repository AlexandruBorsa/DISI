package com.disi.trainer.DataAccess;

import javax.persistence.*;

import java.util.List;

@Entity
public class Entry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer customerId;
    private Integer weight;
    private Integer waist;
    private Integer thigh;
    private Integer biceps;

    public Entry() {
    }

    public Entry(Integer customerId, Integer weight, Integer waist, Integer thigh, Integer biceps) {
        this.customerId = customerId;
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

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
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


}
