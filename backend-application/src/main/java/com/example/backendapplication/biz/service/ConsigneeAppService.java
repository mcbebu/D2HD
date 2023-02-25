package com.example.backendapplication.biz.service;


import com.example.backendapplication.model.Waypoint;

import java.util.List;
import java.util.Queue;

public interface ConsigneeAppService {
    public List<Waypoint> getNextWaypoints(Queue<Waypoint> poppedQueue);
    public List<Waypoint> queueToList(Queue<Waypoint> poppedQueue);
    public List<Waypoint> getRelativeWaypoints(Waypoint newestWaypoint);
}
