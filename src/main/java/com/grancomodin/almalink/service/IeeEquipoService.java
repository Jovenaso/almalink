package com.grancomodin.almalink.service;

import java.util.Map;

import com.grancomodin.almalink.dto.IeeEquipoDto;
import com.grancomodin.almalink.generic.StatusProcessService;

public interface IeeEquipoService {


	public StatusProcessService getById(Long id);
	public StatusProcessService post(IeeEquipoDto post);
	public StatusProcessService put(IeeEquipoDto put);
	public StatusProcessService baja(Long id);
	StatusProcessService busqueda(Map<String, Object> conditions);
}
