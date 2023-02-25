package com.example.backendapplication.controller;

import com.example.backendapplication.biz.impl.DriverAppServiceImpl;
import com.example.backendapplication.enumeration.DeliveryStatus;
import com.example.backendapplication.model.Waypoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Queue;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/driverApp")
public class AppController {
    @Autowired
    private DriverAppServiceImpl driverAppService;
    List<Waypoint> waypointList = Arrays.asList(
            new Waypoint("Address A", "Harry Potter", false, DeliveryStatus.PENDING),
            new Waypoint("Address B", "Hermione Granger", false, DeliveryStatus.PENDING),
            new Waypoint("Address C", "Ron Weasley", false, DeliveryStatus.PENDING),
            new Waypoint("Address D", "Cedric Diggory", false, DeliveryStatus.PENDING),
            new Waypoint("Address E", "Severus Snape", false, DeliveryStatus.PENDING),
            new Waypoint("Address F", "Albus Dumbledore", false, DeliveryStatus.PENDING),
            new Waypoint("Address G", "Draco Malfoy", false, DeliveryStatus.PENDING),
            new Waypoint("Address H", "Neville Longbottom", false, DeliveryStatus.PENDING),
            new Waypoint("Address I", "Peter Pettigrew", false, DeliveryStatus.PENDING),
            new Waypoint("Address J", "Lucius Malfoy", false, DeliveryStatus.PENDING));


    // Driver
    @GetMapping("/convertToQueue")
    public Queue<Waypoint> convertToQueue() {
        System.out.println(waypointList);
        return driverAppService.initialDeliveryQueue(waypointList);
    }

    /**
     * Api that will be called to pop the first item off the queue
     * Used when "completed" or "fail" is pressed in the driver app
     *
     * @param currentList
     * @return The updated delivery queue with the first element removed
     */
    @GetMapping("/updateQueue")
    public Queue<Waypoint> updateQueue(Queue<Waypoint> currentList) {
        return driverAppService.updatedDeliveryQueue(currentList);
    }

    // Consignee


}
