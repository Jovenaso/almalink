package com.grancomodin.almalink.service;

import java.util.Map;

import com.grancomodin.almalink.dto.GralColorDto;
import com.grancomodin.almalink.generic.BusquedaListaPaginar;
import com.grancomodin.almalink.generic.StatusProcessService;

public interface GralColorService {
	
	public StatusProcessService getById(Long id);
	public StatusProcessService post(GralColorDto post);
	public StatusProcessService put(GralColorDto put);
	public StatusProcessService baja(Long id);
	public StatusProcessService busqueda(Map<String, Object> conditions);

}
