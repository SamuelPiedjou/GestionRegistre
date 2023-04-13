package com.gestionregistre.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "tb_registre_securite")
public class RegistreSecurite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRegistre;

    @Temporal(TemporalType.DATE)
    private Date anneeCreation;

    @Column(length = 600,name = "noteRegistre")
    private String noteRegistre;
}
