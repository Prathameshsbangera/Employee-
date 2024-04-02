package com.Employee.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> retrieveAllEmployee(){ return employeeRepository.findAll();}

    public Employee addEmployee(Employee employee){
        return  employeeRepository.save(employee);
    }

    public Employee updateEmployee(Employee employee,String empId){
        Employee eEmployee=employeeRepository.findEmployeeByempId(empId).orElseThrow(()->new NoSuchElementException("not found"));
        eEmployee.setDesignation(employee.getDesignation());
        eEmployee.setName(employee.getName());
        return employeeRepository.save(eEmployee);
    }

    public void deleteEmployee(String empId){
        Employee employee=employeeRepository.findEmployeeByempId(empId).orElseThrow(()->new NoSuchElementException("not found"));
        employeeRepository.delete(employee);
    }
}
