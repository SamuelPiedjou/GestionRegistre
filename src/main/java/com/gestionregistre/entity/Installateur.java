package com.gestionregistre.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "installateur")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Installateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idInstallateur;

    private String nomInstallateur;

    private String numeroInst;

    private String adresse;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL,mappedBy = "installateur")
    private List<Extincteur> extincteurs = new ArrayList<>(0);
}