package com.example.backendapplication.biz.impl;

import com.example.backendapplication.biz.service.ConsigneeAppService;
import com.example.backendapplication.model.Waypoint;
import com.example.backendapplication.repo.WaypointRepository;
import org.apache.catalina.webresources.war.WarURLConnection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

@Service
public class ConsigneeAppServiceImpl implements ConsigneeAppService {
    @Autowired
    private WaypointServiceImpl waypointService;
    @Autowired
    private WaypointRepository waypointRepo;
    @Override
    public List<Waypoint> getNextWaypoints(Queue<Waypoint> poppedQueue) {
        List<Waypoint> poppedList = queueToList(poppedQueue);

        int size = poppedList.size();
        List<Waypoint> nextWaypoints = new ArrayList<>();

        if(size >= 5) {
            for(int i = 0; i < 5; i++) {
                nextWaypoints.add(poppedList.get(i));
            }

            return nextWaypoints;
        }

        for(int i = 0; i < size; i++) {
            nextWaypoints.add(poppedList.get(i));
        }

        return nextWaypoints;
    }

    @Override
    public List<Waypoint> queueToList(Queue<Waypoint> poppedQueue) {
        return new ArrayList<>(poppedQueue);
    }

    @Override
    public List<Waypoint> getRelativeWaypoints(Waypoint newestWaypoint) {
        List<Waypoint> waypointList = waypointService.displayWaypointList();

        int currentIdx = 0;
        for(int i = 0; i < waypointList.size(); i++) {
            Waypoint currentWaypoint = waypointList.get(i);
            if(currentWaypoint.getConsigneeAddress().equals(newestWaypoint.getConsigneeAddress())){
                currentIdx = i;
            }
        }

        int waypointListSize = waypointList.size();

        List<Waypoint> waypointsToDisplay = new ArrayList<>();

        if(currentIdx - 4 >= 0 && currentIdx <= waypointListSize - 1) {
            int start = currentIdx - 4;
            for(int i = start; i < currentIdx; i++) {
                waypointsToDisplay.add(waypointList.get(i));
            }
            return waypointsToDisplay;
        }

        for (int i = 0; i <= currentIdx; i++) {
            waypointsToDisplay.add(waypointList.get(i));
        }

        return waypointsToDisplay;
    }
}
