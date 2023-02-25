package com.example.backendapplication.biz.impl;

import com.example.backendapplication.biz.service.DriverAppService;
import com.example.backendapplication.model.Waypoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

@Service
public class DriverAppServiceImpl implements DriverAppService {
    @Autowired
    private WaypointServiceImpl waypointService;

    // convert from list to queue to use pop method
    @Override
    public Queue<Waypoint> listToQueue(List<Waypoint> sortedWaypoints) {
        Queue<Waypoint> queue = new LinkedList<>();
        queue.addAll(sortedWaypoints);

        return queue;
    }

    // performs the popping
    @Override
    public Queue<Waypoint> updatedDeliveryQueue(Queue<Waypoint> initialQueue) {
        initialQueue.remove();
        return initialQueue;
    }

    @Override
    public List<Waypoint> saveWaypoints(List<Waypoint> routeForTheDay) {
        waypointService.saveWaypointList(routeForTheDay);
        return waypointService.displayWaypointList();
    }


}
