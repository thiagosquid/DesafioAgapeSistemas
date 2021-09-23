package com.thiago.desafio.resources;


import com.thiago.desafio.database.Clients;
import com.thiago.desafio.service.ClientsService;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(value = "/clients")
public class ClientsResource {
    
    @Autowired
    private ClientsService service;
    
    @GetMapping
    public ResponseEntity<List<ArrayList<Clients>>> findAll(){
        ArrayList<Clients> obj = service.findAll();
        return ResponseEntity.ok().body(Arrays.asList(obj));
    }
    
    @GetMapping(value = "/{id}")
    public ResponseEntity<Clients> findById(@PathVariable Integer id){
        Clients obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
        
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
    
    @PostMapping
    public ResponseEntity<Clients> create(@RequestBody Clients obj){
        obj = service.create(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }
    
    @PutMapping(value = "/{id}")   
    public ResponseEntity<Clients> update(@PathVariable Integer id, @RequestBody Clients obj){
        Clients newClient = service.update(id, obj);
        return ResponseEntity.accepted().body(newClient);
    }
}
