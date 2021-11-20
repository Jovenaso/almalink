package com.grancomodin.almalink.dto;

import java.io.Serializable;
import java.math.BigDecimal;


public class IeeEquipoDto implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String nombre;
	private String codigo_barra;
	private String referencia;
	private String unidad_medida;
	private String foto;
	private Long gral_color_id;
	private Long gral_marca_id;
	private String gral_color_titulo;
	private String gral_marca_titulo;
	private BigDecimal precio;
	private String ubicacion;
	private Integer cantidad;
	private Long gral_empresa_id;
	private Long gral_usr_id;
	
	public IeeEquipoDto(Long id, String nombre, String codigo_barra, String referencia, String unidad_medida,
			String foto, Long gral_color_id, Long gral_marca_id, BigDecimal precio, String ubicacion,
			Integer cantidad) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.codigo_barra = codigo_barra;
		this.referencia = referencia;
		this.unidad_medida = unidad_medida;
		this.foto = foto;
		this.gral_color_id = gral_color_id;
		this.gral_marca_id = gral_marca_id;
		this.precio = precio;
		this.ubicacion = ubicacion;
		this.cantidad = cantidad;
	}
	public IeeEquipoDto(Long id, String nombre, String codigo_barra, String referencia, String unidad_medida, String gral_color_titulo, String gral_marca_titulo, BigDecimal precio, String ubicacion,
			Integer cantidad) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.codigo_barra = codigo_barra;
		this.referencia = referencia;
		this.unidad_medida = unidad_medida;
		this.foto = foto;
		this.gral_color_titulo = gral_color_titulo;
		this.gral_marca_titulo = gral_marca_titulo;
		this.precio = precio;
		this.ubicacion = ubicacion;
		this.cantidad = cantidad;
	}
	
	
	
	public String getGral_color_titulo() {
		return gral_color_titulo;
	}
	public void setGral_color_titulo(String gral_color_titulo) {
		this.gral_color_titulo = gral_color_titulo;
	}
	public String getGral_marca_titulo() {
		return gral_marca_titulo;
	}
	public void setGral_marca_titulo(String gral_marca_titulo) {
		this.gral_marca_titulo = gral_marca_titulo;
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
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCodigo_barra() {
		return codigo_barra;
	}
	public void setCodigo_barra(String codigo_barra) {
		this.codigo_barra = codigo_barra;
	}
	public String getReferencia() {
		return referencia;
	}
	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}
	public String getUnidad_medida() {
		return unidad_medida;
	}
	public void setUnidad_medida(String unidad_medida) {
		this.unidad_medida = unidad_medida;
	}
	public Long getGral_color_id() {
		return gral_color_id;
	}
	public void setGral_color_id(Long gral_color_id) {
		this.gral_color_id = gral_color_id;
	}
	public Long getGral_marca_id() {
		return gral_marca_id;
	}
	public void setGral_marca_id(Long gral_marca_id) {
		this.gral_marca_id = gral_marca_id;
	}
	public BigDecimal getPrecio() {
		return precio;
	}
	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}
	public String getUbicacion() {
		return ubicacion;
	}
	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	public Long getGral_empresa_id() {
		return gral_empresa_id;
	}
	public void setGral_empresa_id(Long gral_empresa_id) {
		this.gral_empresa_id = gral_empresa_id;
	}
	
	
	
	
}
