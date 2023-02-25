package com.example.backendapplication.model;

public class Waypoint {
    private String address;
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
