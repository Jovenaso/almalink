package com.grancomodin.almalink.auth;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


//Esta clase nos permite agregar información al token
@Component
public class InfoToken implements TokenEnhancer {

	@Transactional(readOnly = true)
	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
		
		Map<String, Object> info = new HashMap<>();
		// Sé agrega al hashmap los datos de usuario
		//info.put("Mensaje", "Bienvenido ".concat(authentication.getName()));
		

		///////////////////////////////////////////////////////////////////////////////////////////////////////////////
		// Asignar el info al objeto access token
		((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(info);
		return accessToken;
	}  

}
