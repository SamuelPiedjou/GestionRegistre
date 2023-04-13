package com.gestionregistre.repository;

import com.gestionregistre.entity.Extincteur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExtincteurRepository extends JpaRepository<Extincteur,Long> {

}
