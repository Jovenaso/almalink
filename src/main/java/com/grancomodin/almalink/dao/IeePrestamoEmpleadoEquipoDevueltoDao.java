package com.grancomodin.almalink.dao;

import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.grancomodin.almalink.dto.IeePrestamoEmpleadoEquipoDevueltoDto;
import com.grancomodin.almalink.generic.BusquedaListaPaginar;
import com.grancomodin.almalink.model.IeePrestamoEmpleadoEquipoDevuelto;

public interface IeePrestamoEmpleadoEquipoDevueltoDao extends JpaRepository<IeePrestamoEmpleadoEquipoDevuelto, Long>{

	
	@Query("select new com.grancomodin.almalink.dto.IeePrestamoEmpleadoEquipoDevueltoDto(ipeed.id, "
			+ "ipeed.prestamo.id, ipeed.devuelto, ipeed.comentarios," + 
			"ipeed.foto_evidencia) from IeePrestamoEmpleadoEquipoDevuelto ipeed where ipeed.id = ?1")
	IeePrestamoEmpleadoEquipoDevueltoDto findByIdDto(Long id);
	BusquedaListaPaginar busqueda(Map<String, Object> conditions);
}
