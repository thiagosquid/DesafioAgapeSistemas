package com.thiago.desafio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan({"com.thiago.desafio.resources"})
public class DesafioApplication {

  
    public static void main(String[] args) {
            SpringApplication.run(DesafioApplication.class, args);
    }

}
