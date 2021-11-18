package com.grancomodin.almalink.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableGlobalMethodSecurity(securedEnabled = true)
@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter { 
 
	@Autowired
	private UserDetailsService usuarioService;

	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	@Bean("authenticationManager")
	@Override
	protected AuthenticationManager authenticationManager() throws Exception {
		return super.authenticationManager();
	}

	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// autowired buscará la clase qué implementa la interfaz
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// AutenticationManagerBuilder
	// Se registra en el authenticationmanager usuarioService para autenticar
	@Override
	@Autowired
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(this.usuarioService).passwordEncoder(passwordEncoder());
	}

	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	@Override
	public void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http.authorizeRequests().anyRequest().authenticated().and().csrf().disable().sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}

	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	@Bean()
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}  
}
