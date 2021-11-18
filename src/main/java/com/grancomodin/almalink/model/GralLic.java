package com.grancomodin.almalink.model;

import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class GralLic {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Timestamp vigencia;
	private Timestamp alta;
	private boolean activo;
	private Short max_usr;
	private Short current_usr;
	private String serial_code_crypt;
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "gral_usr_id", referencedColumnName = "id")
	private GralUsr usuario_lic;
	private Short max_app;
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "gral_tipo_lic_id", referencedColumnName = "id")
	private GralTipoLic tipo_lic;
	@ManyToMany(cascade = 
            CascadeType.ALL
    )
    @JoinTable(
            name = "GralLicApp",
            joinColumns = {@JoinColumn(name = "gral_lic_id")},
            inverseJoinColumns = {@JoinColumn(name = "gral_app_id")}
    )
    private Set<GralApp> apps_licencia;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Timestamp getVigencia() {
		return vigencia;
	}
	public void setVigencia(Timestamp vigencia) {
		this.vigencia = vigencia;
	}
	public Timestamp getAlta() {
		return alta;
	}
	public void setAlta(Timestamp alta) {
		this.alta = alta;
	}
	public boolean isActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	public Short getMax_usr() {
		return max_usr;
	}
	public void setMax_usr(Short max_usr) {
		this.max_usr = max_usr;
	}
	public Short getCurrent_usr() {
		return current_usr;
	}
	public void setCurrent_usr(Short current_usr) {
		this.current_usr = current_usr;
	}
	public String getSerial_code_crypt() {
		return serial_code_crypt;
	}
	public void setSerial_code_crypt(String serial_code_crypt) {
		this.serial_code_crypt = serial_code_crypt;
	}
	public GralUsr getUsuario_lic() {
		return usuario_lic;
	}
	public void setUsuario_lic(GralUsr usuario_lic) {
		this.usuario_lic = usuario_lic;
	}
	public Short getMax_app() {
		return max_app;
	}
	public void setMax_app(Short max_app) {
		this.max_app = max_app;
	}
	public GralTipoLic getTipo_lic() {
		return tipo_lic;
	}
	public void setTipo_lic(GralTipoLic tipo_lic) {
		this.tipo_lic = tipo_lic;
	}
	public Set<GralApp> getApps_licencia() {
		return apps_licencia;
	}
	public void setApps_licencia(Set<GralApp> apps_licencia) {
		this.apps_licencia = apps_licencia;
	}
	
	
}
