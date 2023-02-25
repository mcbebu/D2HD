package com.example.backendapplication.service;

import com.example.backendapplication.biz.impl.WaypointServiceImpl;
import com.example.backendapplication.enumeration.DeliveryStatus;
import com.example.backendapplication.model.Waypoint;
import com.example.backendapplication.repo.WaypointRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class WaypointServiceTest {
    @Autowired
    private WaypointServiceImpl waypointService;
    @Autowired
    private WaypointRepository repo;

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
    @Test
    public void testSaveWaypointList() {
        repo.deleteAll();
        List<Waypoint> actual = waypointService.saveWaypointList(waypointList);
        Assertions.assertEquals(waypointList, actual);
    }

    @Test
    public void testCreateWaypoint() {
        Waypoint newWaypoint = new Waypoint("Address A", "Harry Potter", false, DeliveryStatus.PENDING);
        waypointService.saveWaypoint(newWaypoint);
    }
}
