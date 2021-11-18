package com.grancomodin.almalink.model;

import java.util.Date;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
@Entity
public class IeePrestamoEmpleadoEquipo {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	
	public IeePrestamoEmpleadoEquipo(Long id) {
		super();
		this.id = id;
	}
	public IeePrestamoEmpleadoEquipo() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	// @Id
	@ManyToOne
	@JoinColumn(name = "gral_equipo_id")
	// @Where(clause = "ctb = true")
	private IeeEquipo equipo;

	// @Id
	@ManyToOne
	@JoinColumn(name = "gral_empleado_id")
	//@JsonIgnore
	private GralEmpleado empleado;
	private Short prestado;
	private Date fecha_prestamo;
	private Date fecha_devolucion_estimada;

	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "gral_encargado_id", referencedColumnName = "id")
	private GralEmpleado encargado;
	private Date fecha_alta;
	private Date fecha_actualiza;
	private Date fecha_baja;
	private Long gral_usr_id_alta;
	private Long gral_usr_id_actualiza;
	private Long gral_usr_id_baja;
	private boolean activo;
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

	public IeeEquipo getEquipo() {
		return equipo;
	}

	public void setEquipo(IeeEquipo equipo) {
		this.equipo = equipo;
	}

	public GralEmpleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(GralEmpleado empleado) {
		this.empleado = empleado;
	}

	public Short getPrestado() {
		return prestado;
	}

	public void setPrestado(Short prestado) {
		this.prestado = prestado;
	}


	public Date getFecha_prestamo() {
		return fecha_prestamo;
	}

	public void setFecha_prestamo(Date fecha_prestamo) {
		this.fecha_prestamo = fecha_prestamo;
	}

	public Date getFecha_devolucion_estimada() {
		return fecha_devolucion_estimada;
	}

	public void setFecha_devolucion_estimada(Date fecha_devolucion_estimada) {
		this.fecha_devolucion_estimada = fecha_devolucion_estimada;
	}

	public GralEmpleado getEncargado() {
		return encargado;
	}

	public void setEncargado(GralEmpleado encargado) {
		this.encargado = encargado;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof IeePrestamoEmpleadoEquipo)) {
			return false;
		}
		IeePrestamoEmpleadoEquipo that = (IeePrestamoEmpleadoEquipo) o;
		return Objects.equals(equipo.getId(), that.equipo.getId())
				&& Objects.equals(empleado.getId(), that.empleado.getId());
	}

	@Override
	public int hashCode() {
		return Objects.hash(equipo.getId(), empleado.getId(), prestado, fecha_prestamo,
				fecha_devolucion_estimada, encargado.getId());
	}

}
