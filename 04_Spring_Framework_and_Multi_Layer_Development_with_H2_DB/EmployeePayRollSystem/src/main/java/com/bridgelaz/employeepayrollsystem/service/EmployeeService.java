package com.bridgelaz.employeepayrollsystem.service;

import com.bridgelaz.employeepayrollsystem.model.Employee;
import com.bridgelaz.employeepayrollsystem.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    public List<Employee> getAll() {
        return repository.findAll();
    }

    public Employee getById(int id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));
    }

    public Employee create(Employee employee) {
        return repository.save(employee);
    }

    public Employee update(int id, Employee updatedEmployee) {
        Employee existing = getById(id);
        existing.setName(updatedEmployee.getName());
        existing.setSalary(updatedEmployee.getSalary());
        return repository.save(existing);
    }

    public void delete(int id) {
        repository.deleteById(id);
    }
}

