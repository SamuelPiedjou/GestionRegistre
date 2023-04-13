package com.gestionregistre.repository;

import com.gestionregistre.entity.Compartiment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompartRepository extends JpaRepository<Compartiment,Long> {
}
