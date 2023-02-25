package com.example.backendapplication.biz.impl;

import com.example.backendapplication.biz.service.WaypointService;
import com.example.backendapplication.model.Waypoint;

import com.example.backendapplication.repo.WaypointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

@Service
public class WaypointServiceImpl implements WaypointService{
    @Autowired
    private WaypointRepository repo;

    @Override
    public Waypoint createWaypoint(Waypoint newWaypoint) {
        repo.save(newWaypoint);

        return newWaypoint;
    }

    @Override
    public Queue<Waypoint> initialDeliveryQueue(List<Waypoint> sortedWaypoints) {
        return new LinkedList<>(sortedWaypoints);
    }

    @Override
    public Queue<Waypoint> updatedDeliveryQueue(Queue<Waypoint> initialQueue) {
        initialQueue.remove();
        return initialQueue;
    }
}
