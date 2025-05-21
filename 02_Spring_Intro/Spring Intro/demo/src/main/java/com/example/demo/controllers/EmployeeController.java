package com.example.demo.controllers;

import com.example.demo.models.Employee;
import com.example.demo.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employeerecord")
public class EmployeeController {
    @Autowired
    public EmployeeService e1;
    @GetMapping("/")
    public List<Employee> rec(){
        return e1.getallrecords();
    }
    @GetMapping("/{id}")
    public Employee rec2(@PathVariable int id){
        return e1.getoneemployee(id);
    }
    @GetMapping("/byname/{name}")
    public Employee rec3(@PathVariable String name){
        return e1.getemployeebyname(name);
    }
    @DeleteMapping ("/{id}")
    public void rec4(@PathVariable int id){
        e1.deleteemployee(id);
    }
    @PostMapping ("/")
    public void rec5(@RequestBody Employee e){
        e1.addEmployee(e);
    }

    @PutMapping("/")
    public void rec6(@RequestBody Employee e){
        e1.updateEmployee(e,e.getId());
    }

}
