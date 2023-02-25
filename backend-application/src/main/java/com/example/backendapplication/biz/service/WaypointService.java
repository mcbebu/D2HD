package com.example.backendapplication.biz.service;

import com.example.backendapplication.model.Waypoint;

import java.util.List;
import java.util.Queue;

public interface WaypointService {
    public Waypoint createWaypoint(Waypoint newWaypoint);
    public List<Waypoint> saveWaypointList(List<Waypoint> waypointList);
}
