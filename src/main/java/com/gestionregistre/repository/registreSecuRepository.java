package com.gestionregistre.repository;

import com.gestionregistre.entity.RegistreSecurite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface registreSecuRepository extends JpaRepository<RegistreSecurite,Long> {
}
