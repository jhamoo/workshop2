package com.test.myapp2;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
    
    @Autowired
    Address address;
    
    @Autowired
    Employee employee;

    @GetMapping("/msg")
    public String getMyService() {
        address.setLocation("Seoul");
        employee.setName("hamm");
        //return employee.getName();
        return employee.getAddress().getLocation();
        //return address.getLocation();
    }

}
