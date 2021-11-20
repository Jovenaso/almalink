package com.grancomodin.almalink.dao;

import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.grancomodin.almalink.dto.GralEmpleadoDto;
import com.grancomodin.almalink.generic.BusquedaListaPaginar;
import com.grancomodin.almalink.model.GralEmpleado;

public interface GralEmpleadoDao extends JpaRepository<GralEmpleado, Long>{
	
	@Query("select new com.grancomodin.almalink.dto.GralEmpleadoDto(ge.id, ge.nombre, ge.apellido, "
			+ "ge.puesto.id) from GralEmpleado ge where ge.id =?1")
	GralEmpleadoDto findByIdDto(Long id);
	

	BusquedaListaPaginar busqueda(Map<String, Object> conditions);
}
