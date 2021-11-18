package com.grancomodin.almalink.dto;

import java.io.Serializable;

public class GralUsrDto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String nombre;
	private String correo;
	private String password;
	private String foto;
	private Short tipo_usr;
	public GralUsrDto() {
		super();
	}
	public GralUsrDto(Long id, String nombre, String correo, String password, String foto, Short tipo_usr) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.correo = correo;
		this.password = password;
		this.foto = foto;
		this.tipo_usr = tipo_usr;
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
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	public Short getTipo_usr() {
		return tipo_usr;
	}
	public void setTipo_usr(Short tipo_usr) {
		this.tipo_usr = tipo_usr;
	}
	
}
