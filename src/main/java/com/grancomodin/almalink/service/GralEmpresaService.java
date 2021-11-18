package com.grancomodin.almalink.service;

import com.grancomodin.almalink.dto.GralEmpresaDto;
import com.grancomodin.almalink.generic.StatusProcessService;

public interface GralEmpresaService {

	public StatusProcessService getById(Long id);
	public StatusProcessService post(GralEmpresaDto post);
	public StatusProcessService put(GralEmpresaDto put);
	public StatusProcessService baja(Long id);
}
