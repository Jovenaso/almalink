package com.grancomodin.almalink.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class IeeEquipo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nombre;
	private String codigo_barra;
	private String referencia;
	private String unidad_medida;
	private String foto;
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "gral_color_id", referencedColumnName = "id")
	private GralColor color;
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "gral_marca_id", referencedColumnName = "id")
	private GralMarca marca;
	private BigDecimal precio;
	private String ubicacion;
	private Integer cantidad;
	private Integer prestado;
	private Date fecha_alta;
	private Date fecha_actualiza;
	private Date fecha_baja;
	private Long gral_usr_id_alta;
	private Long gral_usr_id_actualiza;
	private Long gral_usr_id_baja;
	private boolean activo;
	
	
	public IeeEquipo(Long id) {
		super();
		this.id = id;
	}
	public IeeEquipo() {
		super();
	}
	public boolean isActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	public Date getFecha_baja() {
		return fecha_baja;
	}
	public void setFecha_baja(Date fecha_baja) {
		this.fecha_baja = fecha_baja;
	}
	public Long getGral_usr_id_alta() {
		return gral_usr_id_alta;
	}
	public void setGral_usr_id_alta(Long gral_usr_id_alta) {
		this.gral_usr_id_alta = gral_usr_id_alta;
	}
	public Long getGral_usr_id_actualiza() {
		return gral_usr_id_actualiza;
	}
	public void setGral_usr_id_actualiza(Long gral_usr_id_actualiza) {
		this.gral_usr_id_actualiza = gral_usr_id_actualiza;
	}
	public Long getGral_usr_id_baja() {
		return gral_usr_id_baja;
	}
	public void setGral_usr_id_baja(Long gral_usr_id_baja) {
		this.gral_usr_id_baja = gral_usr_id_baja;
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
	public GralColor getColor() {
		return color;
	}
	public void setColor(GralColor color) {
		this.color = color;
	}
	public GralMarca getMarca() {
		return marca;
	}
	public void setMarca(GralMarca marca) {
		this.marca = marca;
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
	public Integer getPrestado() {
		return prestado;
	}
	public void setPrestado(Integer prestado) {
		this.prestado = prestado;
	}
	public Date getFecha_alta() {
		return fecha_alta;
	}
	public void setFecha_alta(Date fecha_alta) {
		this.fecha_alta = fecha_alta;
	}
	public Date getFecha_actualiza() {
		return fecha_actualiza;
	}
	public void setFecha_actualiza(Date fecha_actualiza) {
		this.fecha_actualiza = fecha_actualiza;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	
	
	
	
	
}
