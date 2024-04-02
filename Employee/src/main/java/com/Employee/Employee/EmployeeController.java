package com.Employee.Employee;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://127.0.0.1:5500")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/all")
    public List<Employee> getAllEmployee(){
        return  employeeService.retrieveAllEmployee();
    }

    @PostMapping("/add")
    public Employee addNewEmployee(@RequestBody Employee employee){
        return employeeService.addEmployee(employee);
    }

    @PutMapping("/update/{empId}")
    public Employee updateExistingEmployee(@PathVariable String empId,@RequestBody Employee employee){
        return employeeService.updateEmployee(employee,empId);
    }

    @DeleteMapping("/delete/{empId}")
    public void deleteExistingEmployee(@PathVariable String empId){
        employeeService.deleteEmployee(empId);
    }


}
