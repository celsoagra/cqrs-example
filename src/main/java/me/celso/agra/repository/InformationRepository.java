package me.celso.agra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import me.celso.agra.model.Information;

@Repository
public interface InformationRepository extends JpaRepository<Information, Long> {
	
}
