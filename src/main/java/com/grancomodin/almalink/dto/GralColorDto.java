package com.grancomodin.almalink.dto;

import java.io.Serializable;
public class GralColorDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String titulo;
	
	
	public GralColorDto(Long id, String titulo) {
		super();
		this.id = id;
		this.titulo = titulo;
	}
	public GralColorDto() {
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
