package com.example.backendapplication.service;

import com.example.backendapplication.biz.impl.DriverAppServiceImpl;
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
import java.util.Queue;

@SpringBootTest
public class DriverAppServiceTest {
    @Autowired
    private DriverAppServiceImpl driverAppService;
    @Autowired
    private WaypointServiceImpl waypointService;

    List<Waypoint> waypointList = Arrays.asList(
            new Waypoint("Address A", "Harry Potter", false, DeliveryStatus.PENDING),
            new Waypoint("Address B", "Hermione Granger", false, DeliveryStatus.PENDING),
            new Waypoint("Address C", "Ron Weasley", false, DeliveryStatus.PENDING),
            new Waypoint("Address D", "Cedric Diggory", false, DeliveryStatus.PENDING),
            new Waypoint("Address E", "Severus Snape", false, DeliveryStatus.PENDING));

    @Test
    public void testDeliveryQueue() {
        Queue<Waypoint> actual = driverAppService.listToQueue(waypointList);
        boolean isQueue = actual instanceof Queue<Waypoint>;

        Assertions.assertEquals(true, isQueue);

        ArrayList<String> expectedList = new ArrayList<>();
        ArrayList<String> actualList = new ArrayList<>();

        waypointList.forEach(waypoint -> expectedList.add(waypoint.getConsigneeAddress()));
        actual.forEach(waypoint -> actualList.add(waypoint.getConsigneeAddress()));

        Assertions.assertEquals(expectedList, actualList);
    }

    @Test
    public void testUpdatedDeliveryQueue() {
        Queue<Waypoint> initialQueue = driverAppService.listToQueue(waypointList);
        // driver presses accept or fail (to be implemented)
        // call updatedDeliveryQueue
        Queue<Waypoint> updatedQueue = driverAppService.updatedDeliveryQueue(initialQueue);

        // test size of updatedDeliveryQueue < initialQueue by 1
        initialQueue.forEach(waypoint -> {
            System.out.println(waypoint.getConsigneeAddress());
        });
        Assertions.assertEquals(updatedQueue.size(), initialQueue.size());

        // test it removes the first object
        Assertions.assertEquals(false, updatedQueue.contains(waypointList.get(0).getConsigneeAddress()));

        // store the addys for initialQueue a list
        ArrayList<String> testList3 = new ArrayList<>();
        initialQueue.forEach(waypoint -> testList3.add(waypoint.getConsigneeAddress()));

        // store the addys for updatedDeliveryQueue in another list
        ArrayList<String> testList4 = new ArrayList<>();
        updatedQueue.forEach(waypoint -> testList4.add(waypoint.getConsigneeAddress()));

    }

    @Test
    public void testSaveWaypoints() {
        waypointService.clearWaypointList();

        List<Waypoint> savedWaypoints = driverAppService.saveWaypoints(waypointList);
        List<String> expectedAdresses = new ArrayList<>();
        waypointList.forEach(waypoint -> expectedAdresses.add(waypoint.getConsigneeAddress()));

        List<String> actualAddresses = new ArrayList<>();
        savedWaypoints.forEach(waypoint -> actualAddresses.add(waypoint.getConsigneeAddress()));

        Assertions.assertEquals(expectedAdresses, actualAddresses);

        waypointService.clearWaypointList();

    }
}
