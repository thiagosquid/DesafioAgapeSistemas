package com.thiago.desafio.service;

import com.thiago.desafio.database.Clients;
import com.thiago.desafio.database.Users;
import com.thiago.desafio.repositories.ClientsRepository;
import com.thiago.desafio.repositories.UsersRepository;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DBService {
    
    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private ClientsRepository clientsRepository;
    
    
    public void instanciaBaseDeDados(){
        Users user1 = new Users(null,"teste");
        Users user2 = new Users(null,"123123123");
        Users user3 = new Users(null,"123456");
        Clients client1 = new Clients(null, "Thiago", "11111111111", "12332321", "1992-05-09", "Rua A, 100", "teste", "Aruana", 0, "Aracaju", "SE", "7932223333", "79999998888", "teste");
        Clients client2 = new Clients(null, "Manoel", "11111111111", "12332321", "1992-05-09", "Rua A, 100", "teste", "Aruana", 0, "Aracaju", "SE", "7932223333", "79999998888", "teste");
        Clients client3 = new Clients(null, "Leandro", "11111111111", "12332321", "1992-05-09", "Rua A, 100", "teste", "Aruana", 49100000, "Aracaju", "SE", "7932223333", "79999998888", "teste");
        Clients client4 = new Clients(null, "Daniela", "23456787632", "12309884", "1987-01-31", "Rua B", "", "Centro", 49000000, "São Cristóvão", "SE", "", "79988886677", "");
        this.clientsRepository.saveAll(Arrays.asList(client1, client2, client3, client4));
        this.usersRepository.saveAll(Arrays.asList(user1, user2, user3));
        
    }
    
}
