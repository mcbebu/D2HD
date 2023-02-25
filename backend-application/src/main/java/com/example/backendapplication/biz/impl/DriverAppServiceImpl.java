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

    // convert from list to queue to use pop method
    @Override
    public Queue<Waypoint> initialDeliveryQueue(List<Waypoint> sortedWaypoints) {
        return new LinkedList<>(sortedWaypoints);
    }

    // performs the popping
    @Override
    public Queue<Waypoint> updatedDeliveryQueue(Queue<Waypoint> initialQueue) {
        initialQueue.remove();
        return initialQueue;
    }
}
