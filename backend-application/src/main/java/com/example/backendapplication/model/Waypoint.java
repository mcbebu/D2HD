package com.example.backendapplication.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "waypoint")
public class Waypoint {
    @Id
    @Column(name = "w_address")
    private String address;
    @Column(name = "w_is_completed")
    private boolean is_completed;

    public Waypoint() {
    }

    public Waypoint(String address, boolean is_completed) {
        this.address = address;
        this.is_completed = is_completed;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isIs_completed() {
        return is_completed;
    }

    public void setIs_completed(boolean is_completed) {
        this.is_completed = is_completed;
    }
}
