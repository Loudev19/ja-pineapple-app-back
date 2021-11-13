package com.example.japineappleapp.services;

import com.example.japineappleapp.models.User;
import com.example.japineappleapp.repositories.UserRepository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	@Autowired
    private UserRepository dao;

    public Boolean existsByUsername(String username){
        return dao.existsByUsername(username);
    }

    public User save(User user){
        return dao.saveAndFlush(user);
    }

    public void saveUsers(Set<User> users){
        dao.saveAll(users);
    }
    
    public void delete(Integer id){
        dao.deleteById(id);
    }

    public Optional<User> findById(Integer id){
        return dao.findById(id);
    }

    public List<User> findAll(){ return dao.findAll();}

}
