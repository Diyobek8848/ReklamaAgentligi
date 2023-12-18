package com.example.reklamaagentligi.Repository;

import com.example.reklamaagentligi.Entity.ReklamaUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ReklamaUserRepository extends JpaRepository<ReklamaUser,Long> {
    Optional<ReklamaUser> findByEmail(String email);
}
