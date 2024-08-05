package com.test.myapp4.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.myapp4.entity.Employee;

@RestController
public class EmployeeController {
    private ArrayList<Employee> al;
    public EmployeeController(){
        al = new ArrayList<>();
        Employee emp1 = new Employee();
        emp1.setName("gildong");
        al.add(emp1);
        Employee emp2 = new Employee();
        emp2.setName("ddonnng");
        al.add(emp2);
    }

    @GetMapping("/employees")
    public List<Employee> getEmployeeAll() {
        return al;
    }
}
