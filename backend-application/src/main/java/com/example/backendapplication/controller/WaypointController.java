package com.example.backendapplication.controller;

import com.example.backendapplication.model.Waypoint;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/waypoint")
public class WaypointController {
    @GetMapping("/getWaypoint")
    public Waypoint getWaypoint() {
        Waypoint test = new Waypoint("3 Kay Siang Road", true);
        return test;
    }
}

