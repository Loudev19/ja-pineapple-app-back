package com.example.japineappleapp.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.japineappleapp.models.ERole;
import com.example.japineappleapp.models.Role;
import com.example.japineappleapp.repositories.RoleRepository;

@Service
public class RoleService {
	@Autowired
    private RoleRepository dao;

    public Optional<Role> findByName(ERole name){
        System.out.println(dao.findAll());
        return dao.findByName(name);
    }
}
