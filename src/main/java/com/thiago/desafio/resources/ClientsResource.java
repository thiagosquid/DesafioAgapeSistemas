package com.thiago.desafio.resources;


import com.thiago.desafio.database.Clients;
import com.thiago.desafio.service.ClientsService;
import com.thiago.desafio.service.ReportService;
import java.io.FileNotFoundException;
import java.net.URI;
import java.util.List;
import javax.validation.Valid;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
@RequestMapping("/clients")
// @CrossOrigin(*)
public class ClientsResource {
    
    @Autowired
    private ClientsService service;
    
    @Autowired
    private ReportService serviceReport;
    
        
    @GetMapping
    public ResponseEntity<?> findAll(Pageable pageable){
        Page<Clients> obj = service.findAll(pageable);
        return ResponseEntity.ok().body(obj);
    }
    
    @GetMapping(value = "/all")
    public ResponseEntity<List> findAll(){
        List<Clients> obj = service.findAll2();
        return ResponseEntity.ok().body(obj);
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
    public ResponseEntity<Clients> create(@Valid @RequestBody Clients obj){
        obj = service.create(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }
    
    @PutMapping(value = "/{id}")   
    public ResponseEntity<Clients> update(@PathVariable Integer id, @Valid @RequestBody Clients obj){
        Clients newClient = service.update(id, obj);
        return ResponseEntity.accepted().body(newClient);
    }
    
    @GetMapping("/report")
    public String generateReport() throws FileNotFoundException, JRException{
                
        return serviceReport.exportReport();
    }
    
    @GetMapping("/report/{id}")
    public String generateReportToClient(@PathVariable("id") Integer id) throws FileNotFoundException, JRException{
                
        return serviceReport.exportReportClient(id);
    }    
    
   
  
    
}
