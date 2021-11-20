package com.grancomodin.almalink.service;

import java.util.Map;

import com.grancomodin.almalink.dto.GralMarcaDto;
import com.grancomodin.almalink.generic.StatusProcessService;

public interface GralMarcaService {

	public StatusProcessService getById(Long id);
	public StatusProcessService post(GralMarcaDto post);
	public StatusProcessService put(GralMarcaDto put);
	public StatusProcessService baja(Long id);
	StatusProcessService busqueda(Map<String, Object> conditions);
}
