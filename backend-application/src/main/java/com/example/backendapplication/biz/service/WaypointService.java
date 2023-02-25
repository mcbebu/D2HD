package com.example.backendapplication.biz.service;

import com.example.backendapplication.model.Waypoint;

import java.util.List;

public interface WaypointService {
    public Waypoint saveWaypoint(Waypoint newWaypoint);
    public Waypoint updateWaypoint(Waypoint waypoint);
    public Waypoint getWaypoint(Waypoint waypoint);
    public List<Waypoint> saveWaypointList(List<Waypoint> waypointList);
    public List<Waypoint> displayWaypointList();
    public void clearWaypointList();
}
