package com.thiago.desafio.service;

import com.thiago.desafio.database.Users;
import com.thiago.desafio.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersService {
    
    @Autowired
    private UsersRepository repository;
    
    public boolean verify(Users obj){
        boolean res = true;
        Users user = repository.getById(obj.getId());
        if(user == null || !user.getPassword().equals(obj.getPassword())){
            res = false;
        } 
               
        return res;
    }       
    
}
