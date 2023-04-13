package com.gestionregistre.entity;

import com.gestionregistre.domain.UtilisateurDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_utilisateur")
@SequenceGenerator(name = "SeqUsersys", sequenceName = "SeqUsersys", initialValue = 1, allocationSize = 1)
public class Utilisateur {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SeqUsersys")
    private Long idUser;

    @Column(name = "nom_user")
    private String nomUser;

    @Column(name = "lastname")
    private String prenomUser;

    @Column(name = "email")
    private String email;

    @Column(name = "adress")
    private String adresse;

    @Column(name = "phone")
    private String phoneNumber;

    @CreatedDate
    @Temporal(TemporalType.TIME)
    @Column(name = "created", nullable = false, updatable = false)
    private Date dateCreation;

//    @ManyToMany(fetch = FetchType.LAZY)
//    @JoinTable(name = "tb_user_role", joinColumns = @JoinColumn(name = "USER_ID"), inverseJoinColumns = @JoinColumn(name = "ROLE_ID"))
//    private Set<Role> roles =new HashSet<>();
    @OneToOne
    @JoinColumn(name = "id_profile")
    private Profile profile;


    public Utilisateur(UtilisateurDto userDto){

        this.nomUser =userDto.getNomUser();
        this.adresse=userDto.getAdresse();
        this.email=userDto.getEmail();
        this.dateCreation=userDto.getDateCreation();
        this.prenomUser=userDto.getPrenomUser();
        this.profile=userDto.getProfile();
        this.phoneNumber=userDto.getPhoneNumber();
    }
}
