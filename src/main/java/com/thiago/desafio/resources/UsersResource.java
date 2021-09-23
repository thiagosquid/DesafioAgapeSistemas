package com.thiago.desafio.resources;


import com.thiago.desafio.database.Users;
import com.thiago.desafio.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/users")
public class UsersResource {
    
    @Autowired
    private UsersService service;
    
    @PostMapping
    public ResponseEntity<String> verify(@RequestBody Users obj){
        String res = service.verify(obj);
        return ResponseEntity.ok().body(res);
    }
    
}
