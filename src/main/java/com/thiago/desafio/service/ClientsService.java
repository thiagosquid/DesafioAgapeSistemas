package com.thiago.desafio.service;

import com.thiago.desafio.database.Clients;
import com.thiago.desafio.repositories.ClientsRepository;
import java.util.ArrayList;
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
           
    public void delete(Integer id){
        findById(id);
        repository.deleteById(id);
    }
    
    public Clients create(Clients obj){
        obj.setId(null);
        
        return repository.save(obj);
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
    
    public ArrayList<Clients> findByIdFilter(Integer idPart){
        ArrayList<Clients> obj = (ArrayList<Clients>) repository.findByIdFilter(idPart);
        return obj;
    }
    
    public ArrayList<Clients> findByIdAndNameFilter(Integer idPart, String namePart){
        ArrayList<Clients> obj = (ArrayList<Clients>) repository.findByIdAndNameFilter(idPart, namePart);
        return obj;
    }
    
    public ArrayList<Clients> findByIdAndNameAndCpfFilter(Integer idPart, String namePart, String cpf){
        ArrayList<Clients> obj = (ArrayList<Clients>) repository.findByIdAndNameAndCpfFilter(idPart, namePart, cpf);
        return obj;
    }
    
//    public ArrayList<Clients> findByAnyFilter(String idPart, String namePart, String cpfPart){
//        String id = "";
//        String name = "";
//        String cpf = "";
//        if(!idPart.equals("empty")){
//            id = "CAST(c.id as string) like %" + idPart + "%";
//        }
//        
//        if(!namePart.equals("empty")){
//            name = "and LOWER(c.name) like %"+ namePart + "%";
//        }
//        
//        if(!cpfPart.equals("empty")){
//            cpf = "and c.CPF like %" + cpfPart + "%";
//        }
//        
//        ArrayList<Clients> obj = (ArrayList<Clients>) repository.findByAnyFilter(id, name, cpf);
//        return obj;
//    }
       
    
}
