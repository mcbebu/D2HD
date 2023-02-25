package com.example.backendapplication.biz.impl;

import com.example.backendapplication.biz.service.ConsigneeService;
import com.example.backendapplication.model.Consignee;
import com.example.backendapplication.repo.ConsigneeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsigneeServiceImpl implements ConsigneeService {
    @Autowired
    private ConsigneeRepository repo;

    @Override
    public String getUsername(Consignee consignee) {
        return consignee.getName();
    }

    @Override
    public String getAddress(Consignee consignee) {
        return consignee.getAddress();
    }

    @Override
    public Consignee createConsignee(String userName, String password, String name, String address, String postalCode) {
        Consignee newConsignee = new Consignee(userName, password, name, address, postalCode);
        repo.save(newConsignee);

        return newConsignee;
    }
}
