package com.company.controller;

import com.company.entity.Employee;

import com.company.service.impl.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
public class EmployeeController {
    @Autowired
    EmployeeServiceImpl employeeService;

    @PostMapping("/addEmployee")
    public ResponseEntity<?> addEmployee(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
        return new ResponseEntity<String>("Created", HttpStatus.CREATED);
    }

//        @GetMapping("/employees")
//    public String getAllEmployee(Model model){
//        model.addAttribute("employees",employeeService.getAllEmployee());
//        return "employees";
//    }
    @GetMapping("/employees")
    public List<Employee> getAllEmployee() {
        return employeeService.getAllEmployee();
    }

    @GetMapping("/employees/{id}")
    public Employee findEmployeeById(@PathVariable Integer id) {
        return employeeService.getEmployeeById(id);
    }

    @DeleteMapping("/employees/{id}")
    public String deleteById(@PathVariable Integer id) {
        return employeeService.deleteEmployeeById(id);
    }
}
