package com.example.backendapplication.service;

import com.example.backendapplication.biz.impl.WaypointServiceImpl;
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
public class WaypointServiceTest {
    @Autowired
    private WaypointServiceImpl waypointService;

    List<Waypoint> waypointList = Arrays.asList(
            new Waypoint("Address A", false),
            new Waypoint("Address B", false),
            new Waypoint("Address C", false),
            new Waypoint("Address D", false),
            new Waypoint("Address E", false));

    @Test
    public void testDeliveryQueue() {
        Queue<Waypoint> actual = waypointService.initialDeliveryQueue(waypointList);
        boolean isQueue = actual instanceof Queue<Waypoint>;

        Assertions.assertEquals(true, isQueue);

        ArrayList<String> expectedList = new ArrayList<>();
        ArrayList<String> actualList = new ArrayList<>();

        waypointList.forEach(waypoint -> expectedList.add(waypoint.getAddress()));
        actual.forEach(waypoint -> actualList.add(waypoint.getAddress()));

        Assertions.assertEquals(expectedList, actualList);
    }

    @Test
    public void testUpdatedDeliveryQueue() {
        Queue<Waypoint> initialQueue = waypointService.initialDeliveryQueue(waypointList);
        // driver presses accept or fail (to be implemented)
        // call updatedDeliveryQueue
        Queue<Waypoint> updatedQueue = waypointService.updatedDeliveryQueue(initialQueue);

        // test size of updatedDeliveryQueue < initialQueue by 1
        initialQueue.forEach(waypoint -> {
            System.out.println(waypoint.getAddress());
        });
        Assertions.assertEquals(updatedQueue.size(), initialQueue.size());

        // test it removes the first object
        Assertions.assertEquals(false, updatedQueue.contains(waypointList.get(0).getAddress()));

        // store the addys for initialQueue a list
        ArrayList<String> testList3 = new ArrayList<>();
        initialQueue.forEach(waypoint -> testList3.add(waypoint.getAddress()));

        // store the addys for updatedDeliveryQueue in another list
        ArrayList<String> testList4 = new ArrayList<>();
        updatedQueue.forEach(waypoint -> testList4.add(waypoint.getAddress()));

    }
}
