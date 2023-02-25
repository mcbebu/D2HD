package com.example.backendapplication.service;

import com.example.backendapplication.biz.impl.ConsigneeAppServiceImpl;
import com.example.backendapplication.biz.impl.WaypointServiceImpl;
import com.example.backendapplication.enumeration.DeliveryStatus;
import com.example.backendapplication.model.Waypoint;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class ConsigneeAppServiceTest {

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
    @Autowired
    private ConsigneeAppServiceImpl consigneeAppService;

    @Autowired
    private WaypointServiceImpl waypointService;

    @Test
    public void testGetRelativeWaypoints() {
        // test for middle of the list
        waypointService.clearWaypointList();
        waypointService.saveWaypointList(waypointList);

        int dracoIdx = 6;
        Waypoint draco = waypointList.get(6);
        List<String> actual1 = new ArrayList<>();
        consigneeAppService.getRelativeWaypoints(draco).forEach(waypoint -> actual1.add(waypoint.getConsigneeAddress()));
        List<String> expected1 = new ArrayList<>();
        for (int i = dracoIdx - 4; i < dracoIdx; i++) {
            expected1.add(waypointList.get(i).getConsigneeAddress());
        }

        Assertions.assertEquals(expected1, actual1);

        int harryIdx = 0;
        Waypoint harry = waypointList.get(harryIdx);
        List<String> actual2 = new ArrayList<>();
        consigneeAppService.getRelativeWaypoints(harry).forEach(waypoint -> actual2.add(waypoint.getConsigneeAddress()));
        List<String> expected2 = Arrays.asList(harry.getConsigneeAddress());

        Assertions.assertEquals(expected2, actual2);

        int hermioneIdx = 1;
        Waypoint hermione = waypointList.get(hermioneIdx);
        List<String> actual3 = new ArrayList<>();
        consigneeAppService.getRelativeWaypoints(hermione).forEach(waypoint -> actual3.add(waypoint.getConsigneeAddress()));
        List<String> expected3 = Arrays.asList(harry.getConsigneeAddress(), hermione.getConsigneeAddress());

        Assertions.assertEquals(expected3, actual3);
    }
}
