package com.grancomodin.almalink.service;

import java.util.Map;

import com.grancomodin.almalink.dto.GralEmpleadoDto;
import com.grancomodin.almalink.generic.BusquedaListaPaginar;
import com.grancomodin.almalink.generic.StatusProcessService;

public interface GralEmpleadoService {

	public StatusProcessService getById(Long id);
	public StatusProcessService post(GralEmpleadoDto post);
	public StatusProcessService put(GralEmpleadoDto put);
	public StatusProcessService baja(Long id);
	StatusProcessService busqueda(Map<String, Object> conditions);
}
