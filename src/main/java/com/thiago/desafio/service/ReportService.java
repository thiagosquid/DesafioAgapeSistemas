package com.thiago.desafio.service;

import com.thiago.desafio.database.Clients;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRSaver;
import net.sf.jasperreports.view.JasperViewer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;


@Service
public class ReportService {
    
    @Autowired
    private ClientsService service;
    
    public String exportReport() throws FileNotFoundException, JRException{
        
        String pathDestiny = "D:\\Área de Trabalho";
        
        List<Clients> clients = service.findAll2();
                
        File file = ResourceUtils.getFile("classpath:clientsreport.jrxml");
        
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(clients);
        Map parameters = new HashMap();
        parameters.put("createdBy","Thiago");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
        
        JasperExportManager.exportReportToPdfFile(jasperPrint, pathDestiny + "\\clientes.pdf");
        
        
        return "Relatório gerado no caminho: " + pathDestiny;
    }
    
    public String exportReportClient(Integer id) throws FileNotFoundException, JRException{
        
        String pathDestiny = "D:\\Área de Trabalho";
        
        Clients client = service.findById(id);
        List<Clients> clients = new ArrayList<>();
        clients.add(client);
                
        File file = ResourceUtils.getFile("classpath:clientsreport.jrxml");
        
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(clients);
        Map parameters = new HashMap();
        parameters.put("createdBy","Thiago");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
        
        JasperExportManager.exportReportToPdfFile(jasperPrint, pathDestiny + "\\clientes.pdf");
        
        
        return "Relatório gerado no caminho: " + pathDestiny;
    }
    
}
