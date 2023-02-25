package com.example.backendapplication.biz.impl;

import com.example.backendapplication.biz.service.ConsigneeAppService;
import com.example.backendapplication.model.Waypoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

@Service
public class ConsigneeAppServiceImpl implements ConsigneeAppService {
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
}
