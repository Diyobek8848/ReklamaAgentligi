package com.example.reklamaagentligi.Controller;

import com.example.reklamaagentligi.Dto.LoginDto;
import com.example.reklamaagentligi.Dto.UsersDto;
import com.example.reklamaagentligi.Entity.ReklamaUser;
import com.example.reklamaagentligi.Repository.ReklamaUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.List;

@Controller
@RequestMapping("/reklama")
public class ReklamaController {
    @Autowired
    ReklamaUserRepository reklamaUserRepository;

    @GetMapping("/all")
    public String all(@CookieValue("Auth") String token, Model model){
        ReklamaUser reklamaUser = reklamaUserRepository.findByEmail("Admin").get();
        if(reklamaUser.getToken().equals(token)){
            List<ReklamaUser> all = reklamaUserRepository.findAll();
            model.addAttribute("foydalanuvchilar",all);
            return "adminPage";
        }
        return "redirect:/reklama/admin";
    }
    @PostMapping("/habar")
    public ResponseEntity<?> habar(@RequestBody UsersDto usersDto){
        ReklamaUser reklamaUser = new ReklamaUser();
        reklamaUser.setFish(usersDto.getName());
        reklamaUser.setEmail(usersDto.getEmail());
        reklamaUser.setSubject(usersDto.getSubject());
        reklamaUser.setTel(usersDto.getPhone());
        reklamaUser.setIzoh(usersDto.getMessage());
        reklamaUser.setBelgi("No");
        reklamaUserRepository.save(reklamaUser);
        return ResponseEntity.status(200).body("Ma'lumotlaringiz muvaffaqqiyatli kiritildi. Tez orada operatorlarimiz sizga aloqaga chiqishadi");
    }
    @GetMapping("/admin")
    public String admin(){
        return "admin-login";
    }
    @PostMapping("/check")
    public ResponseEntity<?> users(@RequestBody LoginDto loginDto){
        ReklamaUser reklamaUser = reklamaUserRepository.findByEmail(loginDto.getEmail()).get();
        if(!reklamaUser.getPassword().equals("")){
            if(loginDto.getPassword().equals(reklamaUser.getPassword())){
                System.out.println(loginDto);
                return ResponseEntity.status(200).body(reklamaUser.getToken());
            }
            return ResponseEntity.status(208).body("Error");
        }
        return ResponseEntity.status(400).body("Warning");
    }
    @GetMapping("/enable/{id}")
    public String enable(@PathVariable Long id){
        ReklamaUser reklamaUser = reklamaUserRepository.findById(id).get();
        reklamaUser.setBelgi("Yes");
        reklamaUserRepository.save(reklamaUser);
        return "redirect:/reklama/all";
    }
    @GetMapping("/disable/{id}")
    public String disable(@PathVariable Long id){
        ReklamaUser reklamaUser = reklamaUserRepository.findById(id).get();
        reklamaUser.setBelgi("No");
        reklamaUserRepository.save(reklamaUser);
        return "redirect:/reklama/all";
    }
}
