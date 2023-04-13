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
@Table(name="tb_rie")
public class Rie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRie;

    @Temporal(TemporalType.DATE)
    private Date dateSortie;

    private String natureInpection;

    private String lieu;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_checklist")
    private CheckList checkList;
}
