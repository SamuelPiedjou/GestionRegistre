package com.gestionregistre.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;

@Entity
@RequiredArgsConstructor
@Data
@Table(name = "tb_profil")
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long idProfile;

    private String codeProfile;

    private String libelleProfile;
}
