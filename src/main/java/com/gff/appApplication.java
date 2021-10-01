package com.gff;

import com.gff.models.services.sap.IGoodsReceiptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class appApplication implements CommandLineRunner {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    
    @Autowired
    private IGoodsReceiptService service;

    public static void main(String[] args) {
        SpringApplication.run(appApplication.class, args);
    }
    
    @Override
    public void run(String... args) throws Exception {
//        for (int i = 0; i < 10; i++) {
//            System.out.println(passwordEncoder.encode("12345"));
//        }
    }

}
