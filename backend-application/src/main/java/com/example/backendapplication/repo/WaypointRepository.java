package com.example.backendapplication.repo;

import com.example.backendapplication.model.Waypoint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WaypointRepository extends JpaRepository<Waypoint, String> {}
