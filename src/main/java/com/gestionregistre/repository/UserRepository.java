package com.gestionregistre.repository;

import com.gestionregistre.domain.UtilisateurDto;
import com.gestionregistre.entity.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Utilisateur,Long> {
    Utilisateur findUtilisateurByEmail (String email);

    Utilisateur findUtilisateurByPhoneNumber(String phone);
}
