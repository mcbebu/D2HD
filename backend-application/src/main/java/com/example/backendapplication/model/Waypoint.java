package com.example.backendapplication.model;

import com.example.backendapplication.enumeration.DeliveryStatus;
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

    @Column(name = "w_has_visited")
    private boolean hasVisited;

    @Column(name = "w_delivery_status")
    private DeliveryStatus deliveryStatus;

    public Waypoint() {
    }

    public Waypoint(String address, boolean hasVisited, DeliveryStatus deliveryStatus) {
        this.address = address;
        this.hasVisited = hasVisited;
        this.deliveryStatus = deliveryStatus;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isHasVisited() {
        return hasVisited;
    }

    public void setHasVisited(boolean hasVisited) {
        this.hasVisited = hasVisited;
    }

    public DeliveryStatus getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(DeliveryStatus deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }
}
