package com.grancomodin.almalink.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.grancomodin.almalink.dto.GralPuestoDto;
import com.grancomodin.almalink.model.GralPuesto;

public interface GralPuestoDao extends JpaRepository<GralPuesto, Long>{

	@Query("select new com.grancomodin.almalink.dto.GralPuestoDto(gp.id,gp.titulo,gp.descripcion) from GralPuesto gp where gp.id = ?1")
	GralPuestoDto findByIdDto(Long id);
}
