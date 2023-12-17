package com.example.reklamaagentligi.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.net.http.HttpResponse;

@Controller
@RequestMapping("/reklama")
public class ReklamaController {
    @GetMapping("/all")
    public String all(){
        return "";
    }
    @PostMapping("/habar")
    public ResponseEntity<?> habar(@RequestParam("name") String name){
        return ResponseEntity.status(200).body("Backend Malumotni oldi: "+name);
    }
}
