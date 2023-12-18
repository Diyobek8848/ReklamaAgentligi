package com.example.reklamaagentligi.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class ReklamaUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = true)
    private String fish;
    @Column(nullable = true,unique = true)
    private String email;
    @Column(nullable = true)
    private String tel;
    @Column(nullable = true)
    private String subject;
    @Column(nullable = true)
    private String izoh;
    private String password;

    private String belgi="No";
    private String token="";

}
