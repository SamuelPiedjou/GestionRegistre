package com.gestionregistre.domain;

import com.gestionregistre.entity.Profile;
import com.gestionregistre.entity.Utilisateur;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

@Data
@RequiredArgsConstructor
public class UtilisateurDto {

    private Long idUser;
    private String nomUser;

    private String prenomUser;

    private String email;

    private String adresse;

    private Date dateCreation;

    private Profile profile;

    private String phoneNumber;


    public UtilisateurDto(Utilisateur user){
        this.idUser=user.getIdUser();
        this.nomUser =user.getNomUser();
        this.adresse=user.getAdresse();
        this.email=user.getEmail();
        this.dateCreation=user.getDateCreation();
        this.prenomUser=user.getPrenomUser();
        this.profile=user.getProfile();
        this.phoneNumber=user.getPhoneNumber();
    }
}
