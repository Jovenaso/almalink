package com.grancomodin.almalink.service;

import com.grancomodin.almalink.dto.GralEmpleadoDto;
import com.grancomodin.almalink.generic.StatusProcessService;

public interface GralEmpleadoService {

	public StatusProcessService getById(Long id);
	public StatusProcessService post(GralEmpleadoDto post);
	public StatusProcessService put(GralEmpleadoDto put);
	public StatusProcessService baja(Long id);
}
