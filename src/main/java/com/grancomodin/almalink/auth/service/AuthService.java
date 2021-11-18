package com.grancomodin.almalink.auth.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.grancomodin.almalink.dao.GralUsrDao;
import com.grancomodin.almalink.model.GralUsr;


//Esta es la primera clase para oauth2
//Esta clase sé encarga de hacer la referencia al usuario
@Service
public class AuthService implements UserDetailsService, IAuthService { 
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// Sé encuentra el metodo qué usa la inferfaz IUsuarioDao
	@Autowired
	private GralUsrDao gral_usr_auth;
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// Logger de mensaje de error
	private Logger logger = LoggerFactory.getLogger(AuthService.class);

	@Override
	@Transactional(readOnly = true)
	public GralUsr findByUsername(String username) {
		// TODO Auto-generated method stub
		GralUsr entity = gral_usr_auth.findByEmail(username);
		// entity.setGral_usr_role(gral_usr_role.findByUsrId(entity.getId()));
		
		return entity;
	}

	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// Metodo encargado de validar el usuario qué en primer lugar sé busca
	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// Sé envía el nombre del usuario y retorna todos los registros de usuario
		GralUsr usuario = findByUsername(username);
		if (usuario == null) {
			logger.error("Error en el login, no existe el usuario " + username);
			throw new UsernameNotFoundException("Error en el login, no existe el usuario " + usuario);
		}
		// Se da por hecho qué el usuario existe
		// Sé retorna la instancia del usuario
		List<GrantedAuthority> authorities = new ArrayList<>();

			 
	
		return new User(usuario.getCorreo(), usuario.getPassword(), true, true, true, true, authorities);
		 
	}  
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
}