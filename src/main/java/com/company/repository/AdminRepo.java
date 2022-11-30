package com.company.repository;

import com.company.Admins;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepo extends JpaRepository<Admins,Integer> {
    public Admins findByUsername(String username);
}
