package com.example.employeemanager.service;

import com.example.employeemanager.entity.Employee;
import com.example.employeemanager.exception.UserNotFoundException;
import com.example.employeemanager.repo.EmployeeRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class EmployeeService {

    private final EmployeeRepo employeeRepo;

    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public Employee addEmployee(Employee employee) {
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepo.save(employee);
    }

    public List<Employee> findAllEmployees() {
        return employeeRepo.findAll();
    }

    public Employee update(Employee employee) {
        return employeeRepo.save(employee);
    }

    public void delete(Long id) {
        employeeRepo.deleteById(id);
    }

    public Employee findById(Long id) {
        return employeeRepo.findById(id).
                orElseThrow(() -> new UserNotFoundException("User has not been found!"));
    }
}
