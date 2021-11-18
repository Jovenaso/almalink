package com.grancomodin.almalink.service;

import com.grancomodin.almalink.dto.GralPuestoDto;
import com.grancomodin.almalink.dto.GralUsrDto;
import com.grancomodin.almalink.generic.StatusProcessService;

public interface GralUsrService {
	public StatusProcessService getById(Long id);
	public StatusProcessService post(GralUsrDto post);
	public StatusProcessService put(GralUsrDto put);
	public StatusProcessService baja(Long id);
}
