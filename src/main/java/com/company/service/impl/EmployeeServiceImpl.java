package com.company.service.impl;

import com.company.entity.Employee;
import com.company.repository.EmployeeRepository;
import com.company.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    RoleRepository roleRepository;



    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    public Employee saveEmployee(Employee employee) {
            return employeeRepository.save(employee);
    }


    public Employee getEmployeeById(Integer id) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if (!optionalEmployee.isPresent()) {
            return new Employee();
        }
        Employee employee = optionalEmployee.get();
        return employee;
    }

//    @Override
//    public Employee updateEmployee(Employee employee) {
//        return null;
//    }


    public String deleteEmployeeById(Integer id) {
        employeeRepository.deleteById(id);
        return "deleted";
    }
}
