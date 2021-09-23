package com.thiago.desafio.repositories;

import com.thiago.desafio.database.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer>{
    
}
