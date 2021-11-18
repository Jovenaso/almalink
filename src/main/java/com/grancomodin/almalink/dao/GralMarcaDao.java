package com.grancomodin.almalink.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.grancomodin.almalink.dto.GralMarcaDto;
import com.grancomodin.almalink.model.GralMarca;

public interface GralMarcaDao  extends JpaRepository<GralMarca, Long>{
	@Query("select new com.grancomodin.almalink.dto.GralMarcaDto(gm.id,gm.titulo) from GralMarca gm where gm.id = ?1")
	GralMarcaDto findByIdDto(Long id);

}
