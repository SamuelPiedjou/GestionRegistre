package com.gestionregistre.repository;

import com.gestionregistre.entity.Installateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstallateurRepository extends JpaRepository<Installateur, Long> {
}
