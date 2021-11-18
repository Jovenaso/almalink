package com.grancomodin.almalink.service;

import com.grancomodin.almalink.dto.GralMarcaDto;
import com.grancomodin.almalink.generic.StatusProcessService;

public interface GralMarcaService {

	public StatusProcessService getById(Long id);
	public StatusProcessService post(GralMarcaDto post);
	public StatusProcessService put(GralMarcaDto put);
	public StatusProcessService baja(Long id);
}
