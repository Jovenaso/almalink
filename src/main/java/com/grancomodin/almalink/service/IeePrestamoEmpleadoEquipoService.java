package com.grancomodin.almalink.service;

import com.grancomodin.almalink.dto.IeePrestamoEmpleadoEquipoDto;
import com.grancomodin.almalink.generic.StatusProcessService;

public interface IeePrestamoEmpleadoEquipoService {

	public StatusProcessService getById(Long id);
	public StatusProcessService post(IeePrestamoEmpleadoEquipoDto post);
	public StatusProcessService put(IeePrestamoEmpleadoEquipoDto put);
	public StatusProcessService baja(Long id);
}
