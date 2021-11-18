package com.grancomodin.almalink.dto;

import java.io.Serializable;

public class GralEmpresaDto implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String nombre;
	private String nombre_comercial;
	private String rfc;
	private String direccion;
	private String logo;
	
	
	
	public GralEmpresaDto(Long id, String nombre, String nombre_comercial, String rfc, String direccion, String logo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.nombre_comercial = nombre_comercial;
		this.rfc = rfc;
		this.direccion = direccion;
		this.logo = logo;
	}
	public Long getId() {
		return id;
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
	public String getNombre_comercial() {
		return nombre_comercial;
	}
	public void setNombre_comercial(String nombre_comercial) {
		this.nombre_comercial = nombre_comercial;
	}
	public String getRfc() {
		return rfc;
	}
	public void setRfc(String rfc) {
		this.rfc = rfc;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
