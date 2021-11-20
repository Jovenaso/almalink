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
import com.grancomodin.almalink.dto.GralEmpleadoDto;
import com.grancomodin.almalink.generic.BusquedaListaPaginar;
import com.grancomodin.almalink.model.GralEmpleado;

public class GralEmpleadoDaoImpl {
	@Autowired
	private EntityManager entityManager;
	Expression<String> upper;
	
	public BusquedaListaPaginar busqueda(Map<String, Object> conditions) {
		
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<GralEmpleadoDto> criteria = builder.createQuery(GralEmpleadoDto.class);
		Root<GralEmpleado> root = criteria.from(GralEmpleado.class);
		criteria.multiselect(root.get("id"), root.get("nombre"), root.get("apellido"), root.get("puesto").get("titulo"));
		List<Predicate> predicates = new ArrayList<>();
		
		conditions.forEach((field, value) -> {
			switch (field) {
			case "nombre":
				upper = builder.upper(root.get(field));
				predicates.add(builder.like(upper, "%" + value.toString().toUpperCase() + "%"));
				break;
			case "apellido":
				upper = builder.upper(root.get(field));
				predicates.add(builder.like(upper, "%" + value.toString().toUpperCase() + "%"));
				break;
			case "puesto_titulo":
				upper = builder.upper(root.get("puesto").get("titulo"));
				predicates.add(builder.like(upper, "%" + value.toString().toUpperCase() + "%"));
				break;
			case "puesto_id":
				if (value != null) {
					if (!value.toString().equals("0")) {
						predicates.add(builder.equal(root.get("puesto").get("id"), value));
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

		List<GralEmpleadoDto> result = entityManager.createQuery(criteria).setFirstResult(0)
				.setMaxResults(1000).getResultList();
		CriteriaQuery<Long> countQuery = builder.createQuery(Long.class);
		Root<GralEmpleado> rootCount = countQuery.from(GralEmpleado.class);
		countQuery.select(builder.count(rootCount))
				.where(builder.and(predicates.toArray(new Predicate[predicates.size()])));
		Long count = entityManager.createQuery(countQuery).getSingleResult();
		BusquedaListaPaginar blp = new BusquedaListaPaginar();
		blp.setLista(result);
		blp.setTotalItems(count);
		return blp;
	}
}
