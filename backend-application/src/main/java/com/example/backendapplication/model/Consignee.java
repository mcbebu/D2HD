package com.example.backendapplication.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "consignee")
public class Consignee {
    @Id
    @Column(name = "c_user_name")
    private String userName;

    @Column(name = "c_password")
    private String password;

    @Column(name = "c_name")
    private String name;

    @Column(name = "c_address")
    private String address;

    @Column(name = "c_postal_code")
    private Integer postalCode = null;

    public Consignee() {
    }

    public Consignee(String userName, String password, String name, String address, Integer postalCode) {
        this.userName = userName;
        this.password = password;
        this.name = name;
        this.address = address;
        this.postalCode = postalCode;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(Integer postalCode) {
        this.postalCode = postalCode;
    }
}
