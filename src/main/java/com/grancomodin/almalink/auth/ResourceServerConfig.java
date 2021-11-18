package com.grancomodin.almalink.auth;

import java.util.Arrays;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

//Este es el servidor de recursos
@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter { 
	// Metodo qué nos permite implementar todas las reglas de seguridad de las rutas
	// Aquí sé administraría todo lo referente a los permisos
	@Override
	public void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http.authorizeRequests()
		        .antMatchers(HttpMethod.PUT, "/ctb_tc/updateTc").permitAll()
		.anyRequest().permitAll().and().cors().configurationSource(corsConfigurationSource())
				;
	}

	// Configuración del cors
	// Cors es un mecanismo qué utiliza las cabeceras http, los headers para
	// permitir qué un cliente
	// qué está en otro dominio, en otro lugar distinto al backend tenga permiso
	// para acceder a los recursos del backend
	// recursos protegidos en este caso por spring security y particularmente por
	// oauth2
	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration configuration = new CorsConfiguration();
		// Por medio de configuration de cors, puedo dar acceso al dominio donde está la
		// aplicación de angular
		// a realizar transferencias http GET,POST,PUT,DELETE,OPTIONS,
		configuration.setAllowedOrigins(Arrays.asList("*"));
		configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
		configuration.setAllowCredentials(true);
		configuration.setAllowedHeaders(Arrays.asList("Content-Type", "Authorization", "sub-domain"));
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);
		return source;
	}

	@Bean
	public FilterRegistrationBean<CorsFilter> corsFilter() {
		FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<>(
				new CorsFilter(corsConfigurationSource()));
		bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
		return bean;
	}  

}
