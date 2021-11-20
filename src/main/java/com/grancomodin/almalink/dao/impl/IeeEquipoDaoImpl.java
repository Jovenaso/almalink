package com.grancomodin.almalink.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;

import com.grancomodin.almalink.dto.GralPuestoDto;
import com.grancomodin.almalink.dto.IeeEquipoDto;
import com.grancomodin.almalink.generic.BusquedaListaPaginar;
import com.grancomodin.almalink.model.GralPuesto;
import com.grancomodin.almalink.model.IeeEquipo;

public class IeeEquipoDaoImpl {
	@Autowired
	private EntityManager entityManager;
	Expression<String> upper;
	
	public BusquedaListaPaginar busqueda(Map<String, Object> conditions) {
		
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<IeeEquipoDto> criteria = builder.createQuery(IeeEquipoDto.class);
		Root<IeeEquipo> root = criteria.from(IeeEquipo.class);
		criteria.multiselect(root.get("id"), 
				root.get("nombre"), 
				root.get("codigo_barra"), 
				root.get("referencia"), 
				root.get("unidad_medida"), 
				root.get("color").get("titulo"), 
				root.get("marca").get("titulo"), 
				root.get("precio"), 
				root.get("ubicacion"), 
				root.get("cantidad"));
		List<Predicate> predicates = new ArrayList<>();
		
		conditions.forEach((field, value) -> {
			switch (field) {
			case "nombre":
				upper = builder.upper(root.get(field));
				predicates.add(builder.like(upper, "%" + value.toString().toUpperCase() + "%"));
				break;
			case "codigo_barra":
				upper = builder.upper(root.get(field));
				predicates.add(builder.like(upper, "%" + value.toString().toUpperCase() + "%"));
				break;
			case "referencia":
				upper = builder.upper(root.get(field));
				predicates.add(builder.like(upper, "%" + value.toString().toUpperCase() + "%"));
				break;
			case "unidad_medida":
				upper = builder.upper(root.get(field));
				predicates.add(builder.like(upper, "%" + value.toString().toUpperCase() + "%"));
				break;
			case "gral_color_titulo":
				upper = builder.upper(root.get("color").get("titulo"));
				predicates.add(builder.like(upper, "%" + value.toString().toUpperCase() + "%"));
				break;
			case "gral_marca_titulo":
				upper = builder.upper(root.get("marca").get("titulo"));
				predicates.add(builder.like(upper, "%" + value.toString().toUpperCase() + "%"));
				break;
			case "ubicacion":
				upper = builder.upper(root.get(field));
				predicates.add(builder.like(upper, "%" + value.toString().toUpperCase() + "%"));
				break;
			case "precio":
				if (value != null) {
					if (!value.toString().equals("0")) {
						predicates.add(builder.equal(root.get(field), value));
					}
				}
				break;
			case "cantidad":
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

		List<IeeEquipoDto> result = entityManager.createQuery(criteria).setFirstResult(0)
				.setMaxResults(1000).getResultList();
		CriteriaQuery<Long> countQuery = builder.createQuery(Long.class);
		Root<IeeEquipo> rootCount = countQuery.from(IeeEquipo.class);
		countQuery.select(builder.count(rootCount))
				.where(builder.and(predicates.toArray(new Predicate[predicates.size()])));
		Long count = entityManager.createQuery(countQuery).getSingleResult();
		BusquedaListaPaginar blp = new BusquedaListaPaginar();
		blp.setLista(result);
		blp.setTotalItems(count);
		return blp;
	}
}
