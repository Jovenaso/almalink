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
import com.grancomodin.almalink.dto.GralMarcaDto;
import com.grancomodin.almalink.generic.BusquedaListaPaginar;
import com.grancomodin.almalink.model.GralMarca;

public class GralMarcaDaoImpl {
	@Autowired
	private EntityManager entityManager;
	Expression<String> upper;
	
	public BusquedaListaPaginar busqueda(Map<String, Object> conditions) {
		
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<GralMarcaDto> criteria = builder.createQuery(GralMarcaDto.class);
		Root<GralMarca> root = criteria.from(GralMarca.class);
		criteria.multiselect(root.get("id"), root.get("titulo"));
		List<Predicate> predicates = new ArrayList<>();
		
		conditions.forEach((field, value) -> {
			switch (field) {
			case "titulo":
				upper = builder.upper(root.get(field));
				predicates.add(builder.like(upper, "%" + value.toString().toUpperCase() + "%"));
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

		List<GralMarcaDto> result = entityManager.createQuery(criteria).setFirstResult(0)
				.setMaxResults(1000).getResultList();
		CriteriaQuery<Long> countQuery = builder.createQuery(Long.class);
		Root<GralMarca> rootCount = countQuery.from(GralMarca.class);
		countQuery.select(builder.count(rootCount))
				.where(builder.and(predicates.toArray(new Predicate[predicates.size()])));
		Long count = entityManager.createQuery(countQuery).getSingleResult();
		BusquedaListaPaginar blp = new BusquedaListaPaginar();
		blp.setLista(result);
		blp.setTotalItems(count);
		return blp;
	}
}
