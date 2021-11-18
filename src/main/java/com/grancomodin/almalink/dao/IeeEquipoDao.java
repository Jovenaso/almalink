package com.grancomodin.almalink.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.grancomodin.almalink.dto.IeeEquipoDto;
import com.grancomodin.almalink.model.IeeEquipo;

public interface IeeEquipoDao extends JpaRepository<IeeEquipo, Long>{
	@Query("select new com.grancomodin.almalink.dto.IeeEquipoDto(ie.id, ie.nombre, "
			+ "ie.codigo_barra, ie.referencia, ie.unidad_medida," + 
			"ie.foto, ie.color.id, ie.marca.id, "
			+ "ie.precio, ie.ubicacion," + 
			"ie.cantidad) from IeeEquipo ie where ie.id = ?1")
	IeeEquipoDto findByIdDto(Long id);
}
