package com.company.controller;

import com.company.entity.Employee;
import com.company.entity.Role;
import com.company.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RoleController {
    @Autowired
    RoleRepository roleRepository;

    @PostMapping("/addRole")
    public ResponseEntity<?> addEmployee(@RequestBody Role role) {
         roleRepository.save(role);
        return new ResponseEntity<String>("Created", HttpStatus.CREATED);
    }

}
