package com.grancomodin.almalink.dao;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.grancomodin.almalink.dto.GralEmpleadoDto;
import com.grancomodin.almalink.model.GralEmpleado;
import com.grancomodin.almalink.model.GralPuesto;

public interface GralEmpleadoDao extends JpaRepository<GralEmpleado, Long>{
	
	@Query("select new com.grancomodin.almalink.dto.GralEmpleadoDto(ge.id, ge.nombre, ge.apellido, "
			+ "ge.puesto.id) from GralEmpleado ge where ge.id =?1")
	GralEmpleadoDto findByIdDto(Long id);
}
