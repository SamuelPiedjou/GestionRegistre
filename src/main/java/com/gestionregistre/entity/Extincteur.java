package com.gestionregistre.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.awt.*;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "tb_extincteur")
@SequenceGenerator(name = "SeqExtincteur" ,sequenceName = "SeqExtincteur", initialValue = 1, allocationSize = 1)
public class Extincteur {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SeqExtincteur")
    private Long idExt;

    private String natureExt;

    private String classification;

    @Temporal(TemporalType.TIME)
    @Column(name = "created_date", nullable = false,updatable = false)
    private Date createdDate;

    @Temporal(TemporalType.TIME)
    @Column(name = "expiration_date", nullable = false,updatable = false)
    private Date expiredDate;

    @ManyToOne
    @JoinColumn(name = "dimension_id_ext")
    private DimensionExt dimension;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "compartiment_id")
    private Compartiment compartiment;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "installateur_id")
    private Installateur installateur;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_checklist")
    private CheckList checkList;

}
