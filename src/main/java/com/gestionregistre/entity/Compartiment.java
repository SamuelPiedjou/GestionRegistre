package com.gestionregistre.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "tb_compartiment")
public class Compartiment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCompartiment;

    private String nomCompartiment;

    private String categorie;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "compartiment")
    private List<Extincteur> extincteurs = new ArrayList<>(0);
}
