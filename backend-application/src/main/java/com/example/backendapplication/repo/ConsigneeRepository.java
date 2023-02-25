package com.example.backendapplication.repo;

import com.example.backendapplication.model.Consignee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsigneeRepository extends JpaRepository<Consignee, String> {
}
