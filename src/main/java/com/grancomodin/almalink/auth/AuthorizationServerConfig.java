package com.grancomodin.almalink.auth;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.OAuth2RequestFactory;
import org.springframework.security.oauth2.provider.TokenGranter;
import org.springframework.security.oauth2.provider.code.AuthorizationCodeServices;
import org.springframework.security.oauth2.provider.error.DefaultWebResponseExceptionTranslator;
import org.springframework.security.oauth2.provider.error.WebResponseExceptionTranslator;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;


//Esta es la tercera clase qué sé configura para oauth2
//Esta clase se marca como configuración
@Configuration
//Habilitar el Authorization Server
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {
	///////////////////////////////////////////////////////////////////////////////////////////////////////////
	// Por medio del autowired sé llama al metodo authenticationManager
	// AuthenticationManager está ubicado en SpringSecurityConfig
	// Qualifier especifica cual es el beans(metodo registrado) qué sé usará
	///////////////////////////////////////////////////////////////////////////////////////////////////////////
	@Autowired
	@Qualifier("authenticationManager")
	private AuthenticationManager authenticationManager;
	@Autowired
	private InfoToken infoAdicionalToken;
	

	///////////////////////////////////////////////////////////////////////////////////////////////////////////
	// Este autowired buscará automaticamente el metodo qué hace uso de la interfaz
	/////////////////////////////////////////////////////////////////////////////////////////////////////////// BCryptPasswordEncoder
	// este metodo está ubicado en SpringSecurityConfig
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	///////////////////////////////////////////////////////////////////////////////////////////////////////////
	// Crea el objeto JwtAccessTokenConverter requerido por el metodo y sé registra
	@Bean
	public JwtAccessTokenConverter accessTokenConverter() {
		JwtAccessTokenConverter jwtAccessTokenConverter = new JwtAccessTokenConverter();// TODO Auto-generated method //
																						// stub
		// Con la llave privada se firma el token
		jwtAccessTokenConverter.setSigningKey(JwtConfig.RSA_PRIVATE);
		// Con la llave publica sé verifica qué el token sea valido
		jwtAccessTokenConverter.setVerifierKey(JwtConfig.RSA_PUBLICA);

		return jwtAccessTokenConverter;
	}
	
	
	@Bean
    public WebResponseExceptionTranslator loggingExceptionTranslator() {
        return new DefaultWebResponseExceptionTranslator() {
            @Override
            public ResponseEntity<OAuth2Exception> translate(Exception e) throws Exception {
                // This is the line that prints the stack trace to the log. You can customise this to format the trace etc if you like
                e.printStackTrace();

                // Carry on handling the exception
                ResponseEntity<OAuth2Exception> responseEntity = super.translate(e);
                HttpHeaders headers = new HttpHeaders();
                headers.setAll(responseEntity.getHeaders().toSingleValueMap());
                OAuth2Exception excBody = responseEntity.getBody();
                return new ResponseEntity<>(excBody, headers, responseEntity.getStatusCode());
            }
        };
    }
	///////////////////////////////////////////////////////////////////////////////////////////////////////////

	///////////////////////////////////////////////////////////////////////////////////////////////////////////
	// Se encarga de todo el proceso de autenticación y de validar el token
	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		TokenEnhancerChain tokenEnhancerChain = new TokenEnhancerChain();
		tokenEnhancerChain.setTokenEnhancers(Arrays.asList(infoAdicionalToken, accessTokenConverter()));
		// TODO Auto-generated method stub
		// Sé registra el authenticationManager
		endpoints//.addInterceptor(new MultitenancyInterceptor())
		.tokenGranter(tokenGranter(endpoints))
		.authenticationManager(authenticationManager)
		//.exceptionTranslator(loggingExceptionTranslator())
				// Access token converter es el encargado de manejar varias cosas dentro del
				// token
				// Almacena los datos de autenticación de usuario(username,roles o información
				// extra )
				// Se encarga de decodificar toda la información para qué el authentication
				// manager por medio de oauth2 pueda realizar el proceso de autenticación
				.accessTokenConverter(accessTokenConverter()).tokenEnhancer(tokenEnhancerChain)
		        ;
	}

	///////////////////////////////////////////////////////////////////////////////////////////////////////////
	// Sé configuran los permisos de las rutas de acceso de los recursos
	@Override
	public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
		// TODO Auto-generated method stub
		security
				// Metodo que da permiso a cualquier usuario para poder aut
				.tokenKeyAccess("permitAll()")
				// Validar el token
				.checkTokenAccess("isAuthenticated()");
	}
	///////////////////////////////////////////////////////////////////////////////////////////////////////////
	// Sé configura los datos de autenticación del cliente o los clientes
	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		// TODO Auto-generated method stub
		// Sé configura el nombre de la aplicación cliente
		clients.inMemory().withClient("ApiBase")
				// Sé configura la contraseña de la aplicación y se encripta
				.secret(passwordEncoder.encode("123456"))
				// permisos de la aplicación cliente
				.scopes("read", "write")
				// Sé asigna el tipo de autenticación del token
				.authorizedGrantTypes("password", "refresh_token")
				// Duración del token general
				.accessTokenValiditySeconds((3600) * 24)

				.refreshTokenValiditySeconds((3600) * 24);
	}
	public TokenGranter tokenGranter(AuthorizationServerEndpointsConfigurer endpoints) {

        ClientDetailsService clientDetails = endpoints.getClientDetailsService();
        AuthorizationServerTokenServices tokenServices = endpoints.getTokenServices();
        AuthorizationCodeServices authorizationCodeServices = endpoints.getAuthorizationCodeServices();
        OAuth2RequestFactory requestFactory = endpoints.getOAuth2RequestFactory();
        

        return new CustomTokenGranter(authenticationManager, tokenServices, clientDetails,
                requestFactory);
}
}
