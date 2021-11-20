package com.grancomodin.almalink.dto;

public class GralPuestoDto {
	private Long id;
	private String titulo;
	private String descripcion;
	private Long gral_usr_id;
	
	public GralPuestoDto(Long id, String titulo, String descripcion) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.descripcion = descripcion;
	}
	public GralPuestoDto(Long id, String titulo) {
		super();
		this.id = id;
		this.titulo = titulo;
	}
	public GralPuestoDto() {
		super();
	}
	
	public Long getGral_usr_id() {
		return gral_usr_id;
	}
	public void setGral_usr_id(Long gral_usr_id) {
		this.gral_usr_id = gral_usr_id;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
}
