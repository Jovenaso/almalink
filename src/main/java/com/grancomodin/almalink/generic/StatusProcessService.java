package com.grancomodin.almalink.generic;

import org.springframework.http.HttpStatus;

public class StatusProcessService {
	private Object contenido;
	private String mensaje = "";
	private HttpStatus httpStatus;
	
	public StatusProcessService(String mensaje, HttpStatus httpStatus) {
		super();
		this.mensaje = mensaje;
		this.httpStatus = httpStatus;
	}
	
	public Object getContenido() {
		return contenido;
	}

	public void setContenido(Object contenido) {
		this.contenido = contenido;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}

	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
}
