package com.grancomodin.almalink.dto;

import java.io.Serializable;
import java.util.Date;


import com.grancomodin.almalink.model.GralEmpresa;
import com.grancomodin.almalink.model.GralPuesto;

public class GralEmpleadoDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String nombre;
	private String apellido;
	private Long puesto_id;
	private String puesto_titulo;
	private Long gral_empresa_id;
	private Long gral_usr_id;
	
	
	
	public GralEmpleadoDto(Long id, String nombre, String apellido, Long puesto_id) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.puesto_id = puesto_id;
	}
	public GralEmpleadoDto(Long id, String nombre, String apellido, String puesto_titulo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.puesto_titulo = puesto_titulo;
	}
	
	public String getPuesto_titulo() {
		return puesto_titulo;
	}


	public void setPuesto_titulo(String puesto_titulo) {
		this.puesto_titulo = puesto_titulo;
	}


	public Long getId() {
		return id;
	}
	public Long getGral_usr_id() {
		return gral_usr_id;
	}
	public void setGral_usr_id(Long gral_usr_id) {
		this.gral_usr_id = gral_usr_id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public Long getGral_empresa_id() {
		return gral_empresa_id;
	}
	public void setGral_empresa_id(Long gral_empresa_id) {
		this.gral_empresa_id = gral_empresa_id;
	}
	public Long getPuesto_id() {
		return puesto_id;
	}
	public void setPuesto_id(Long puesto_id) {
		this.puesto_id = puesto_id;
	}
	

}
