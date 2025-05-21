package com.example.demo.services;

import com.example.demo.models.Department;
import com.example.demo.models.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class EmployeeService {

    List<Employee> records= new ArrayList<>(List.of(
            new Employee("Janaki",1,new Department("CS")),
            new Employee("Lily",2,new Department("IT")),
            new Employee("Tim",3,new Department("Sales"))
    ));
    public List<Employee> getallrecords(){
        return records;
    }
    public Employee getoneemployee(int id){
        return records.stream().filter(e->e.getId()==id).findFirst().orElse(null);
    }
    public Employee getemployeebyname(String name){
        return records.stream().filter(n->n.getName().equalsIgnoreCase(name)).findAny().orElse(null);
    }
    public void deleteemployee(int id){
        records.removeIf(e->e.getId()==id);
    }
    public void addEmployee(Employee e){
        records.add(e);
    }
    public void updateEmployee(Employee e,int id){
        for(int i=0;i<records.size();i++){
            if(records.get(i).getId()==id){
                records.set(i,e);
            }
        }
    }
}
