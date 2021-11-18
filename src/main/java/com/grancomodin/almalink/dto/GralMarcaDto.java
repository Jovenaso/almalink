package com.grancomodin.almalink.dto;

public class GralMarcaDto {
	private Long id;
	private String titulo;
	public GralMarcaDto(Long id, String titulo) {
		super();
		this.id = id;
		this.titulo = titulo;
	}
	public GralMarcaDto() {
		super();
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
}
