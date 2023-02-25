package com.example.backendapplication.service;

import com.example.backendapplication.biz.impl.ConsigneeServiceImpl;
import com.example.backendapplication.model.Consignee;
import com.example.backendapplication.repo.ConsigneeRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ConsigneeServiceTest {
    @Autowired
    private ConsigneeRepository repo;

    @Autowired
    private ConsigneeServiceImpl consigneeService;

    @Test
    public void testCreateConsignee() {
        repo.deleteAll();
        consigneeService.createConsignee("user001",
                "password123",
                "John",
                "new york 123",
                "000000");

        Consignee returnedConsignee = repo.findById("user001").get();

        Assertions.assertEquals("user001", returnedConsignee.getUserName());
        Assertions.assertEquals("password123", returnedConsignee.getPassword());
        Assertions.assertEquals("John", returnedConsignee.getName());
        Assertions.assertEquals("new york 123", returnedConsignee.getAddress());
        Assertions.assertEquals("000000", returnedConsignee.getPostalCode());
    }
}
