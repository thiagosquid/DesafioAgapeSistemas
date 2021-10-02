package com.thiago.desafio.service;

import com.thiago.desafio.database.Clients;
import com.thiago.desafio.repositories.ClientsRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
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
    
    public ArrayList<Clients> findByIdFilter(Integer idPart){
        ArrayList<Clients> obj = (ArrayList<Clients>) repository.findByIdFilter(idPart);
        return obj;
    }
    
    public List<Clients> findLike(String form){
        return repository.findAll((Root<Clients> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if(form!=null){
                predicates.add((Predicate) criteriaBuilder.like(root.get("name"), "%" + form + "%"));
            }
            return criteriaBuilder.and((javax.persistence.criteria.Predicate[]) predicates.toArray(new Predicate[predicates.size()]));
        });
    }
    
    public ArrayList<Clients> findByIdAndNameFilter(Integer idPart, String namePart){
        ArrayList<Clients> obj = (ArrayList<Clients>) repository.findByIdAndNameFilter(idPart, namePart);
        return obj;
    }
    
    public ArrayList<Clients> findByIdAndNameAndCpfFilter(Integer idPart, String namePart, String cpf){
        ArrayList<Clients> obj = (ArrayList<Clients>) repository.findByIdAndNameAndCpfFilter(idPart, namePart, cpf);
        return obj;
    }
        
}
