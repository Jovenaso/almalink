package com.grancomodin.almalink.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
@Entity
public class GralEmpleado {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nombre;
	private String apellido;
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "gral_puesto_id", referencedColumnName = "id")
	private GralPuesto puesto;
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "gral_empresa_id", referencedColumnName = "id")
	private GralEmpresa empresa;
	private Date fecha_alta;
	private Date fecha_actualiza;
	private Date fecha_baja;
	private Long gral_usr_id_alta;
	private Long gral_usr_id_actualiza;
	private Long gral_usr_id_baja;
	private boolean activo;
	

	public GralEmpleado() {
		super();
	}
	
	public GralEmpleado(Long id) {
		super();
		this.id = id;
	}
	public Date getFecha_baja() {
		return fecha_baja;
	}
	public void setFecha_baja(Date fecha_baja) {
		this.fecha_baja = fecha_baja;
	}
	public boolean isActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	public Date getFecha_actualiza() {
		return fecha_actualiza;
	}
	public void setFecha_actualiza(Date fecha_actualiza) {
		this.fecha_actualiza = fecha_actualiza;
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
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public Date getFecha_alta() {
		return fecha_alta;
	}
	public void setFecha_alta(Date fecha_alta) {
		this.fecha_alta = fecha_alta;
	}
	public GralPuesto getPuesto() {
		return puesto;
	}
	public void setPuesto(GralPuesto puesto) {
		this.puesto = puesto;
	}
	public GralEmpresa getEmpresa() {
		return empresa;
	}
	public void setEmpresa(GralEmpresa empresa) {
		this.empresa = empresa;
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
	
	

}
