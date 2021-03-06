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


//Esta es la tercera clase qu?? s?? configura para oauth2
//Esta clase se marca como configuraci??n
@Configuration
//Habilitar el Authorization Server
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {
	///////////////////////////////////////////////////////////////////////////////////////////////////////////
	// Por medio del autowired s?? llama al metodo authenticationManager
	// AuthenticationManager est?? ubicado en SpringSecurityConfig
	// Qualifier especifica cual es el beans(metodo registrado) qu?? s?? usar??
	///////////////////////////////////////////////////////////////////////////////////////////////////////////
	@Autowired
	@Qualifier("authenticationManager")
	private AuthenticationManager authenticationManager;
	@Autowired
	private InfoToken infoAdicionalToken;
	

	///////////////////////////////////////////////////////////////////////////////////////////////////////////
	// Este autowired buscar?? automaticamente el metodo qu?? hace uso de la interfaz
	/////////////////////////////////////////////////////////////////////////////////////////////////////////// BCryptPasswordEncoder
	// este metodo est?? ubicado en SpringSecurityConfig
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	///////////////////////////////////////////////////////////////////////////////////////////////////////////
	// Crea el objeto JwtAccessTokenConverter requerido por el metodo y s?? registra
	@Bean
	public JwtAccessTokenConverter accessTokenConverter() {
		JwtAccessTokenConverter jwtAccessTokenConverter = new JwtAccessTokenConverter();// TODO Auto-generated method //
																						// stub
		// Con la llave privada se firma el token
		jwtAccessTokenConverter.setSigningKey(JwtConfig.RSA_PRIVATE);
		// Con la llave publica s?? verifica qu?? el token sea valido
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
	// Se encarga de todo el proceso de autenticaci??n y de validar el token
	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		TokenEnhancerChain tokenEnhancerChain = new TokenEnhancerChain();
		tokenEnhancerChain.setTokenEnhancers(Arrays.asList(infoAdicionalToken, accessTokenConverter()));
		// TODO Auto-generated method stub
		// S?? registra el authenticationManager
		endpoints//.addInterceptor(new MultitenancyInterceptor())
		.tokenGranter(tokenGranter(endpoints))
		.authenticationManager(authenticationManager)
		//.exceptionTranslator(loggingExceptionTranslator())
				// Access token converter es el encargado de manejar varias cosas dentro del
				// token
				// Almacena los datos de autenticaci??n de usuario(username,roles o informaci??n
				// extra )
				// Se encarga de decodificar toda la informaci??n para qu?? el authentication
				// manager por medio de oauth2 pueda realizar el proceso de autenticaci??n
				.accessTokenConverter(accessTokenConverter()).tokenEnhancer(tokenEnhancerChain)
		        ;
	}

	///////////////////////////////////////////////////////////////////////////////////////////////////////////
	// S?? configuran los permisos de las rutas de acceso de los recursos
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
	// S?? configura los datos de autenticaci??n del cliente o los clientes
	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		// TODO Auto-generated method stub
		// S?? configura el nombre de la aplicaci??n cliente
		clients.inMemory().withClient("ApiBase")
				// S?? configura la contrase??a de la aplicaci??n y se encripta
				.secret(passwordEncoder.encode("123456"))
				// permisos de la aplicaci??n cliente
				.scopes("read", "write")
				// S?? asigna el tipo de autenticaci??n del token
				.authorizedGrantTypes("password", "refresh_token")
				// Duraci??n del token general
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
