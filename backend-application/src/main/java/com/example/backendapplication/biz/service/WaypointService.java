package com.example.backendapplication.biz.service;

import com.example.backendapplication.model.Waypoint;

import java.util.List;
import java.util.Queue;

public interface WaypointService {
    public Waypoint createWaypoint(Waypoint newWaypoint);
    public Queue<Waypoint> initialDeliveryQueue(List<Waypoint> sortedWaypoints);
    public Queue<Waypoint> updatedDeliveryQueue(Queue<Waypoint> initialQueue);
}
