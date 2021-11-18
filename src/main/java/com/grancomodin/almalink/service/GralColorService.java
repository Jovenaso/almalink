package com.grancomodin.almalink.service;

import com.grancomodin.almalink.dto.GralColorDto;
import com.grancomodin.almalink.generic.StatusProcessService;

public interface GralColorService {
	
	public StatusProcessService getById(Long id);
	public StatusProcessService post(GralColorDto post);
	public StatusProcessService put(GralColorDto put);
	public StatusProcessService baja(Long id);

}
