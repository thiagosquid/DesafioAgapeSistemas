package com.thiago.desafio.repositories;

import com.thiago.desafio.database.Clients;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientsRepository extends JpaRepository <Clients, Integer>, JpaSpecificationExecutor<Clients>{
    
    @Query("SELECT c from Clients c where CAST(c.id as string) like %?1%")
    List<Clients> findByIdFilter(Integer idPart);
    
    @Query("SELECT c from Clients c where CAST(c.id as string) like %?1% AND LOWER(c.name) like %?2%")
    List<Clients> findByIdAndNameFilter(Integer idPart, String name);
    
    @Query("SELECT c from Clients c where CAST(c.id as string) like %?1% AND LOWER(c.name) like %?2% AND c.CPF like %?3%")
    List<Clients> findByIdAndNameAndCpfFilter(Integer idPart, String name, String cpf);
    
}
