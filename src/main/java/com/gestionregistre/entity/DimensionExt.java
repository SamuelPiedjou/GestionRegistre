package com.gestionregistre.entity;

import lombok.AllArgsConstructor;
import lombok.Generated;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlIDREF;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_dimention_extinction")
public class DimensionExt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idExt;

    private Long hauteurMax;

    private Long diametre;

    private Long aipaisseurNominal;

    private Long volum;

    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL, mappedBy = "dimension")
    private List<Extincteur> extincteurs = new ArrayList<>(0);
}
