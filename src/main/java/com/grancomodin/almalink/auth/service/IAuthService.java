package com.grancomodin.almalink.auth.service;

import com.grancomodin.almalink.model.GralUsr;

public interface IAuthService {

	GralUsr findByUsername(String username);
}
