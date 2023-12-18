package com.example.reklamaagentligi.Payloads;

import com.example.reklamaagentligi.Entity.ReklamaUser;
import com.example.reklamaagentligi.Repository.ReklamaUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class DataLoader implements CommandLineRunner {
    @Autowired
    ReklamaUserRepository reklamaUserRepository;
    @Override
    public void run(String... args) throws Exception {
        Optional<ReklamaUser> admin = reklamaUserRepository.findByEmail("Admin");
        if(!admin.isPresent()){
            ReklamaUser reklamaUser = new ReklamaUser();
            reklamaUser.setPassword("1234");
            reklamaUser.setEmail("Admin");
            reklamaUser.setToken("eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ0ZXN0IiwiaWF0IjoxNzAyODc3NTc2LCJleHAiOjE3MDI4ODQ3NzYsInJvbGVzIjoiVVNFUiJ9.QGxmRPDMExrpFJNmtIUBHZP8Wcb3015ZbKjnfqBoCvBzbFm844KOGZmAqb7hofrVty8EGYfi62y8vE8c7M0U0g");
            reklamaUserRepository.save(reklamaUser);
        }
    }
}
