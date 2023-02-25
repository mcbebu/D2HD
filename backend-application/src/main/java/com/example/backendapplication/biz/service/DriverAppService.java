package com.example.backendapplication.biz.service;

import com.example.backendapplication.model.Waypoint;

import java.util.List;
import java.util.Queue;

public interface DriverAppService {
    public Queue<Waypoint> listToQueue(List<Waypoint> sortedWaypoints);
    public Queue<Waypoint> updatedDeliveryQueue(Queue<Waypoint> initialQueue);
    public List<Waypoint> saveWaypoints(List<Waypoint> routeForTheDay);
}
