package com.thiago.desafio.service;

import com.thiago.desafio.database.Clients;
import com.thiago.desafio.repositories.ClientsRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ClientsService {
    
    @Autowired
    private ClientsRepository repository;
    
    public Clients findById(Integer id){
        Optional<Clients> obj = repository.findById(id);
        return obj.orElse(null);
    }

    public Page<Clients> findAll(Pageable pageable) {
        Page<Clients> obj = repository.findAll(pageable);
        return obj;
    }
    
    public List<Clients> findAll2() {
        List<Clients> obj = repository.findAll();
        return obj;
    }
                   
    public void delete(Integer id){
        findById(id);
        repository.deleteById(id);
    }
    
    public Clients create(Clients obj){
        Clients newClient = new Clients();
        newClient.setId(null);
        newClient.setAddress(obj.getAddress());
        newClient.setBirthdate(obj.getBirthdate());
        newClient.setCEP(obj.getCEP());
        newClient.setCPF(obj.getCPF());
        newClient.setCellphone(obj.getCellphone());
        newClient.setCity(obj.getCity());
        newClient.setComplement(obj.getComplement());
        newClient.setDistrict(obj.getDistrict());
        newClient.setName(obj.getName());
        newClient.setObservation(obj.getObservation());
        newClient.setPhone(obj.getPhone());
        newClient.setRG(obj.getRG());
        newClient.setUF(obj.getUF());
        
        return repository.save(newClient);
    }
    
    public Clients update(Integer id, Clients obj){
        Clients newClient = findById(id);
        newClient.setAddress(obj.getAddress());
        newClient.setBirthdate(obj.getBirthdate());
        newClient.setCEP(obj.getCEP());
        newClient.setCPF(obj.getCPF());
        newClient.setCellphone(obj.getCellphone());
        newClient.setCity(obj.getCity());
        newClient.setComplement(obj.getComplement());
        newClient.setDistrict(obj.getDistrict());
        newClient.setName(obj.getName());
        newClient.setObservation(obj.getObservation());
        newClient.setPhone(obj.getPhone());
        newClient.setRG(obj.getRG());
        newClient.setUF(obj.getUF());
        
        return repository.save(newClient);
    }
        
}
