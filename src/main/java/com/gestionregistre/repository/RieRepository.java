package com.gestionregistre.repository;

import com.gestionregistre.entity.Rie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RieRepository extends JpaRepository<Rie, Long> {
}
