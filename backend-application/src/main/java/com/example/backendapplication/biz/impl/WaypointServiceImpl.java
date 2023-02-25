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
    public Waypoint saveWaypoint(Waypoint newWaypoint) {
        repo.save(newWaypoint);

        return newWaypoint;
    }

    @Override
    public List<Waypoint> saveWaypointList(List<Waypoint> waypointList) {
        repo.saveAll(waypointList);

        return repo.findAll();
    }

    @Override
    public List<Waypoint> displayWaypointList() {
        return repo.findAll();
    }

    @Override
    public void clearWaypointList() {
        repo.deleteAll();
    }

    @Override
    public Waypoint getWaypoint(Waypoint waypoint) {
        return repo.findById(waypoint.getConsigneeAddress()).get();
    }

    @Override
    public Waypoint updateWaypoint(Waypoint waypoint) {
        return repo.save(waypoint);
    }
}
