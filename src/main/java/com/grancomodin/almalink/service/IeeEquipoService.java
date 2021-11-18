package com.grancomodin.almalink.service;

import com.grancomodin.almalink.dto.IeeEquipoDto;
import com.grancomodin.almalink.generic.StatusProcessService;

public interface IeeEquipoService {


	public StatusProcessService getById(Long id);
	public StatusProcessService post(IeeEquipoDto post);
	public StatusProcessService put(IeeEquipoDto put);
	public StatusProcessService baja(Long id);
}
