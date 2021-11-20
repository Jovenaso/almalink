package com.grancomodin.almalink.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.springframework.beans.factory.annotation.Autowired;
import com.grancomodin.almalink.dto.IeePrestamoEmpleadoEquipoDto;
import com.grancomodin.almalink.generic.BusquedaListaPaginar;
import com.grancomodin.almalink.model.IeePrestamoEmpleadoEquipo;

public class IeePrestamoEmpleadoEquipoDaoImpl {
	@Autowired
	private EntityManager entityManager;
	Expression<String> upper;
	
	public BusquedaListaPaginar busqueda(Map<String, Object> conditions) {
		//Long id, String iee_equipo_nombre, String gral_empleado_nombre, Short prestado,
		//Date fecha_prestamo, Date fecha_devolucion_estimada, String gral_encargado_nombre
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<IeePrestamoEmpleadoEquipoDto> criteria = builder.createQuery(IeePrestamoEmpleadoEquipoDto.class);
		Root<IeePrestamoEmpleadoEquipo> root = criteria.from(IeePrestamoEmpleadoEquipo.class);
		criteria.multiselect(root.get("id"), root.get("equipo").get("nombre"), root.get("empleado").get("nombre"), 
				root.get("prestado"), root.get("fecha_prestamo"), root.get("fecha_devolucion_estimada"), root.get("encargado").get("nombre"));
		List<Predicate> predicates = new ArrayList<>();
		
		conditions.forEach((field, value) -> {
			switch (field) {
			case "titulo":
				upper = builder.upper(root.get(field));
				predicates.add(builder.like(upper, "%" + value.toString().toUpperCase() + "%"));
				break;
			case "iee_equipo_nombre":
				upper = builder.upper(root.get("equipo").get("nombre"));
				predicates.add(builder.like(upper, "%" + value.toString().toUpperCase() + "%"));
				break;
			case "gral_empleado_nombre":
				upper = builder.upper(root.get("empleado").get("nombre"));
				predicates.add(builder.like(upper, "%" + value.toString().toUpperCase() + "%"));
				break;
			case "gral_encargado_nombre":
				upper = builder.upper(root.get("encargado").get("nombre"));
				predicates.add(builder.like(upper, "%" + value.toString().toUpperCase() + "%"));
				break;
			case "prestado":
				if (value != null) {
					if (!value.toString().equals("0")) {
						predicates.add(builder.equal(root.get(field), value));
					}
				}
				break;
			case "id":
				if (value != null) {
					if (!value.toString().equals("0")) {
						predicates.add(builder.equal(root.get(field), value));
					}
				}
				break;
			}
		});

		criteria.where(builder.and(predicates.toArray(new Predicate[predicates.size()])));

		List<IeePrestamoEmpleadoEquipoDto> result = entityManager.createQuery(criteria).setFirstResult(0)
				.setMaxResults(1000).getResultList();
		CriteriaQuery<Long> countQuery = builder.createQuery(Long.class);
		Root<IeePrestamoEmpleadoEquipo> rootCount = countQuery.from(IeePrestamoEmpleadoEquipo.class);
		countQuery.select(builder.count(rootCount))
				.where(builder.and(predicates.toArray(new Predicate[predicates.size()])));
		Long count = entityManager.createQuery(countQuery).getSingleResult();
		BusquedaListaPaginar blp = new BusquedaListaPaginar();
		blp.setLista(result);
		blp.setTotalItems(count);
		return blp;
	}
}
