package com.grancomodin.almalink.service;

import java.util.Map;

import com.grancomodin.almalink.dto.IeePrestamoEmpleadoEquipoDevueltoDto;
import com.grancomodin.almalink.generic.StatusProcessService;

public interface IeePrestamoEmpleadoEquipoDevueltoService {

	public StatusProcessService getById(Long id);
	public StatusProcessService post(IeePrestamoEmpleadoEquipoDevueltoDto post);
	public StatusProcessService put(IeePrestamoEmpleadoEquipoDevueltoDto put);
	public StatusProcessService baja(Long id);
	StatusProcessService busqueda(Map<String, Object> conditions);
}
