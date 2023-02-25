package com.example.backendapplication.controller;

import com.example.backendapplication.biz.impl.WaypointServiceImpl;
import com.example.backendapplication.model.Waypoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/waypoint")
public class WaypointController {
    @Autowired
    private WaypointServiceImpl waypointService;
    Waypoint test = new Waypoint("3 Kay Siang Road", true);

    @GetMapping("/getWaypoint")
    public Waypoint getWaypoint() {
        return test;
    }

    @PostMapping("/createWaypoint")
    public Waypoint createWaypoint() {
        waypointService.createWaypoint(test);
        return test;
    }
}

