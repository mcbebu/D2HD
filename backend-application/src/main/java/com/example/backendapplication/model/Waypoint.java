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
    private String consigneeAddress;

    @Column(name = "w_con_full_name")
    private String consigneeName;

    @Column(name = "w_has_visited")
    private boolean hasVisited;

    @Column(name = "w_delivery_status")
    private DeliveryStatus deliveryStatus;

    public Waypoint() {
    }

    public Waypoint(String consigneeAddress, String consigneeName, boolean hasVisited, DeliveryStatus deliveryStatus) {
        this.consigneeAddress = consigneeAddress;
        this.consigneeName = consigneeName;
        this.hasVisited = hasVisited;
        this.deliveryStatus = deliveryStatus;
    }

    public String getConsigneeAddress() {
        return consigneeAddress;
    }

    public void setConsigneeAddress(String consigneeAddress) {
        this.consigneeAddress = consigneeAddress;
    }

    public String getConsigneeName() {
        return consigneeName;
    }

    public void setConsigneeName(String consigneeName) {
        this.consigneeName = consigneeName;
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
