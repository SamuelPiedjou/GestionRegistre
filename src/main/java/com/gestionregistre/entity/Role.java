package com.gestionregistre.entity;

import com.gestionregistre.domain.ERole;

import javax.persistence.*;

@Entity
public class Role {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SeqRole")
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private ERole name;



}
