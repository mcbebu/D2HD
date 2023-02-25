package com.example.backendapplication.biz.service;

import com.example.backendapplication.model.Consignee;

public interface ConsigneeService {
    public String getUsername(Consignee consignee);
    public String getAddress(Consignee consignee);
    public Consignee createConsignee(String userName, String password, String name, String address, String postalCode);
}
