package com.gestionregistre.entity;

import com.gestionregistre.domain.EStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "tb_checklist")
public class CheckList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCheckList;

    @Enumerated(EnumType.STRING)
    private EStatus validEtiquette;

    @Enumerated(EnumType.STRING)
    private EStatus validEmplacement;

    @Enumerated(EnumType.STRING)
    private EStatus validGoupille;

    @Enumerated(EnumType.STRING)
    private EStatus lisibleEtiquette;

    @Enumerated(EnumType.STRING)
    private EStatus validPoigne;

    @Enumerated(EnumType.STRING)
    private EStatus validTuyau;

    @Enumerated(EnumType.STRING)
    private EStatus validEtiqEntretien;


}
