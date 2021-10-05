package com.thiago.desafio.repositories;

import com.thiago.desafio.database.Clients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientsRepository extends JpaRepository <Clients, Integer>, JpaSpecificationExecutor<Clients>{
    
    
}
