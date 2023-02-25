package com.example.backendapplication.controller;

import com.example.backendapplication.biz.impl.DriverAppServiceImpl;
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
public class DriverAppController {
    @Autowired
    private DriverAppServiceImpl driverAppService;

    @GetMapping("/getInitialDeliveryList")
    public Queue<Waypoint> getInitialDeliveryList() {
        List<Waypoint> waypointList = Arrays.asList(
                new Waypoint("Address A", false),
                new Waypoint("Address B", false),
                new Waypoint("Address C", false),
                new Waypoint("Address D", false),
                new Waypoint("Address E", false));
        return driverAppService.initialDeliveryQueue(waypointList);
    }

    @GetMapping("/getUpdatedDeliveryList")
    public Queue<Waypoint> getUpdatedDeliveryList() {
        return driverAppService.updatedDeliveryQueue(getInitialDeliveryList());
    }

}
