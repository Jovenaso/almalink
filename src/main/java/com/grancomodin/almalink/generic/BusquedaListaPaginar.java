package com.grancomodin.almalink.generic;

import java.io.Serializable;

public class BusquedaListaPaginar implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long totalItems;
	
	private Object lista;

	public Long getTotalItems() {
		return totalItems;
	}

	public void setTotalItems(Long totalItems) {
		this.totalItems = totalItems;
	}

	public Object getLista() {
		return lista;
	}

	public void setLista(Object lista) {
		this.lista = lista;
	}
	
}
