package com.bridgelaz.employeepayrollsystem.controller;

import com.bridgelaz.employeepayrollsystem.model.Employee;
import com.bridgelaz.employeepayrollsystem.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @GetMapping("/")
    public List<Employee> getAllEmployees() {
        return service.getAll();
    }

    @GetMapping("/get/{id}")
    public Employee getEmployeeById(@PathVariable int id) {
        return service.getById(id);
    }

    @PostMapping("/create")
    public Employee createEmployee(@Valid @RequestBody Employee employee) {
        return service.create(employee);
    }

    @PutMapping("/update/{id}")
    public Employee updateEmployee(@PathVariable int id, @Valid @RequestBody Employee employee) {
        return service.update(id, employee);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable int id) {
        service.delete(id);
        return ResponseEntity.ok("Deleted employee with ID: " + id);
    }
}

