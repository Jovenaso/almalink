package com.grancomodin.almalink.model;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
@Entity
public class GralUsr {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nombre;
	private String correo;
	private String password;
	private String foto;
	private Short tipo_usr;
	private Timestamp ultimo_acceso;
	private Date fecha_alta;
	private Date fecha_actualiza;
	private Date fecha_baja;
	private boolean activo;

	@ManyToMany(cascade = 
            CascadeType.ALL
    )
    @JoinTable(
            name = "GralUsrLic",
            joinColumns = {@JoinColumn(name = "gral_usr_id")},
            inverseJoinColumns = {@JoinColumn(name = "gral_lic_id")}
    )
    private Set<GralLic> licencia;
	@ManyToMany(cascade = 
            CascadeType.ALL
    )
    @JoinTable(
            name = "GralUsrEmpresa",
            joinColumns = {@JoinColumn(name = "gral_usr_id")},
            inverseJoinColumns = {@JoinColumn(name = "gral_empresa_id")}
    )
    private Set<GralEmpresa> empresa;
	@ManyToMany(cascade = 
            CascadeType.ALL
    )
    @JoinTable(
            name = "GralUsrEmpleado",
            joinColumns = {@JoinColumn(name = "gral_usr_id")},
            inverseJoinColumns = {@JoinColumn(name = "gral_empleado_id")}
    )
    private Set<GralEmpleado> empleado;
	
	
	public boolean isActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
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
	public Date getFecha_baja() {
		return fecha_baja;
	}
	public void setFecha_baja(Date fecha_baja) {
		this.fecha_baja = fecha_baja;
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
	public Timestamp getUltimo_acceso() {
		return ultimo_acceso;
	}
	public void setUltimo_acceso(Timestamp ultimo_acceso) {
		this.ultimo_acceso = ultimo_acceso;
	}
	public Set<GralLic> getLicencia() {
		return licencia;
	}
	public void setLicencia(Set<GralLic> licencia) {
		this.licencia = licencia;
	}
	public Set<GralEmpresa> getEmpresa() {
		return empresa;
	}
	public void setEmpresa(Set<GralEmpresa> empresa) {
		this.empresa = empresa;
	}
	public Set<GralEmpleado> getEmpleado() {
		return empleado;
	}
	public void setEmpleado(Set<GralEmpleado> empleado) {
		this.empleado = empleado;
	}
	
	
	
}
