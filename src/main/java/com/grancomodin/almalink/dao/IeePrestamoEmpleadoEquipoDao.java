package com.grancomodin.almalink.dao;

import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.grancomodin.almalink.dto.IeePrestamoEmpleadoEquipoDto;
import com.grancomodin.almalink.generic.BusquedaListaPaginar;
import com.grancomodin.almalink.model.IeePrestamoEmpleadoEquipo;

public interface IeePrestamoEmpleadoEquipoDao extends JpaRepository<IeePrestamoEmpleadoEquipo, Long>{

	@Query("select new com.grancomodin.almalink.dto.IeePrestamoEmpleadoEquipoDto(ipee.id, ipee.equipo.id, "
			+ "ipee.empleado.id, ipee.prestado," + 
			"ipee.fecha_prestamo, ipee.fecha_devolucion_estimada, "
			+ "ipee.encargado.id) from IeePrestamoEmpleadoEquipo ipee where ipee.id = ?1")
	IeePrestamoEmpleadoEquipoDto findByIdDto(Long id);
	BusquedaListaPaginar busqueda(Map<String, Object> conditions);
}
