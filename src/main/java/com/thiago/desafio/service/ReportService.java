package com.thiago.desafio.service;

import com.thiago.desafio.database.Clients;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;


@Service
public class ReportService {
    
    
    private ClientsService repository;
    
    public String exportReport(String reportFormat) throws FileNotFoundException, JRException{
        
        String pathDestiny = "C:\\Users\\Thiago\\Desktop\\Relatórios";
        
        List<Clients> clients = repository.findAll2();
        
        File file = ResourceUtils.getFile("classpath:clientsreport.jrxml");
        
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(clients);
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("createdBy", "Thiago");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
        if(reportFormat.equalsIgnoreCase("html")){
            JasperExportManager.exportReportToHtmlFile(jasperPrint,pathDestiny + "\\clientes.html");
        }
        if(reportFormat.equalsIgnoreCase("pdf")){
            JasperExportManager.exportReportToPdfFile(jasperPrint, pathDestiny + "\\clientes.pdf");
        }
        
        return "Relatório gerado no caminho: " + pathDestiny;
    }
    
}
