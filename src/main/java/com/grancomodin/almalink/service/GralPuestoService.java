package com.grancomodin.almalink.service;

import java.util.Map;

import com.grancomodin.almalink.dto.GralPuestoDto;
import com.grancomodin.almalink.generic.StatusProcessService;

public interface GralPuestoService {

	public StatusProcessService getById(Long id);
	public StatusProcessService post(GralPuestoDto post);
	public StatusProcessService put(GralPuestoDto put);
	public StatusProcessService baja(Long id);
	StatusProcessService busqueda(Map<String, Object> conditions);
}
