package com.grancomodin.almalink.dao;

import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.grancomodin.almalink.dto.GralEmpresaDto;
import com.grancomodin.almalink.generic.BusquedaListaPaginar;
import com.grancomodin.almalink.model.GralEmpresa;

public interface GralEmpresaDao extends JpaRepository<GralEmpresa, Long>{
	@Query("select new com.grancomodin.almalink.dto.GralEmpresaDto(ge.id, ge.nombre, "
			+ "ge.nombre_comercial, ge.rfc, ge.direccion, ge.logo) from GralEmpresa ge where ge.id = ?1")
	GralEmpresaDto findByIdDto(Long id);
	BusquedaListaPaginar busqueda(Map<String, Object> conditions);
}
