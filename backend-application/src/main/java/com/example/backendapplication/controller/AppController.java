package com.example.backendapplication.controller;

import com.example.backendapplication.biz.impl.ConsigneeAppServiceImpl;
import com.example.backendapplication.biz.impl.DriverAppServiceImpl;
import com.example.backendapplication.enumeration.DeliveryStatus;
import com.example.backendapplication.model.Waypoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Queue;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/driverApp")
public class AppController {
    @Autowired
    private DriverAppServiceImpl driverAppService;

    @Autowired
    private ConsigneeAppServiceImpl consigneeAppService;

    // List generated by waypoint sequencing
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
    @GetMapping("/driverStartUp")
    public Queue<Waypoint> driverStartUp() {
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
    public Queue<Waypoint> updateQueue(@RequestBody List<Waypoint> currentList) {
        Queue<Waypoint> currentQueue = driverAppService.initialDeliveryQueue(currentList);
        driverAppService.updatedDeliveryQueue(currentQueue); //B C D E F

        List<Waypoint> nextWaypoints = consigneeAppService.getNextWaypoints(currentQueue);
        return currentQueue;
    }

    @GetMapping("/convertToQueue")
    public Queue<Waypoint> convertToQueue(@RequestBody  List<Waypoint> initialList) {
        return driverAppService.initialDeliveryQueue(initialList);
    }

    // Consignee
    @GetMapping("/consigneeAppStartup")
    public List<Waypoint> consigneeAppStartup(List<Waypoint> nextWaypoints) {
        return null;
    }

}
