package com.grancomodin.almalink.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.grancomodin.almalink.dao.IeeEquipoDao;
import com.grancomodin.almalink.dto.IeeEquipoDto;
import com.grancomodin.almalink.generic.StatusProcessService;
import com.grancomodin.almalink.model.GralColor;
import com.grancomodin.almalink.model.GralMarca;
import com.grancomodin.almalink.model.IeeEquipo;
import com.grancomodin.almalink.service.IeeEquipoService;

@Service
public class IeeEquipoServiceImpl implements IeeEquipoService {
	@Autowired
	private IeeEquipoDao dao;

	@Override
	public StatusProcessService getById(Long id) {
		// TODO Auto-generated method stub
		StatusProcessService sps = null;
		try {
			IeeEquipoDto dto = dao.findByIdDto(id);
			if (dto != null) {
				sps = new StatusProcessService("Operación exitosa", HttpStatus.CREATED);
				sps.setContenido(dto);
			} else {
				sps = new StatusProcessService("No existe un registro con el id " + id, HttpStatus.CONFLICT);
			}

		} catch (DataAccessException ex) {
			ex.printStackTrace();
			sps = new StatusProcessService("Ocurrió un error relacionado con la base de datos, " + ex.getMessage(),
					HttpStatus.INTERNAL_SERVER_ERROR);

		} catch (Exception ex) {
			ex.printStackTrace();
			sps = new StatusProcessService("Ocurrió un error inesperado", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return sps;
	}

	@Transactional(rollbackFor = { DataAccessException.class, Exception.class })
	@Override
	public StatusProcessService post(IeeEquipoDto post) {
		// TODO Auto-generated method stub
		StatusProcessService sps = null;
		try {
			IeeEquipo create = new IeeEquipo();
			create.setCantidad(post.getCantidad());
			create.setCodigo_barra(post.getCodigo_barra());
			create.setFoto(post.getFoto());
			create.setPrecio(post.getPrecio());
			create.setPrestado(0);
			create.setUnidad_medida(post.getUnidad_medida());
			create.setUbicacion(post.getUbicacion());
			create.setReferencia(post.getReferencia());
			create.setMarca(new GralMarca(post.getGral_marca_id()));
			create.setColor(new GralColor(post.getGral_color_id()));
			create.setNombre(post.getNombre());
			create.setActivo(true);
			create.setCodigo_barra(post.getCodigo_barra());
			create.setFecha_alta(new Date());
			create.setGral_usr_id_alta(post.getGral_usr_id());
			dao.save(create);
			sps = new StatusProcessService("Operación exitosa", HttpStatus.CREATED);
			
		} catch (DataAccessException ex) {
			ex.printStackTrace();
			sps = new StatusProcessService("Ocurrió un error relacionado con la base de datos, "+ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

		} catch (Exception ex) {
			ex.printStackTrace();
			sps = new StatusProcessService("Ocurrió un error inesperado", HttpStatus.INTERNAL_SERVER_ERROR);

		}
		return sps;
	}

	@Transactional(rollbackFor = { DataAccessException.class, Exception.class })
	@Override
	public StatusProcessService put(IeeEquipoDto put) {
		// TODO Auto-generated method stub
		StatusProcessService sps = null;
		try {
			IeeEquipo update = dao.findById(put.getId()).orElse(null);
			update.setCantidad(put.getCantidad());
			update.setCodigo_barra(put.getCodigo_barra());
			update.setFoto(put.getFoto());
			update.setPrecio(put.getPrecio());
			//update.setPrestado(0);
			update.setUnidad_medida(put.getUnidad_medida());
			update.setUbicacion(put.getUbicacion());
			update.setReferencia(put.getReferencia());
			update.setMarca(new GralMarca(put.getGral_marca_id()));
			update.setColor(new GralColor(put.getGral_color_id()));
			update.setNombre(put.getNombre());
			//update.setActivo(true);
			update.setCodigo_barra(put.getCodigo_barra());
			update.setFecha_actualiza(new Date());
			update.setGral_usr_id_actualiza(put.getGral_usr_id());
			dao.save(update);
			sps = new StatusProcessService("Operación exitosa", HttpStatus.CREATED);
			
		} catch (DataAccessException ex) {
			ex.printStackTrace();
			sps = new StatusProcessService("Ocurrió un error relacionado con la base de datos, "+ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

		} catch (Exception ex) {
			ex.printStackTrace();
			sps = new StatusProcessService("Ocurrió un error inesperado", HttpStatus.INTERNAL_SERVER_ERROR);

		}
		return sps;
	}

	@Transactional(rollbackFor = { DataAccessException.class, Exception.class })
	@Override
	public StatusProcessService baja(Long id) {
		// TODO Auto-generated method stub
		StatusProcessService sps = null;
		try {
			IeeEquipo baja = dao.findById(id).orElse(null);
			baja.setActivo(false);
			baja.setFecha_baja(new Date());
			dao.save(baja);
			sps = new StatusProcessService("Operación exitosa", HttpStatus.CREATED);
			
		} catch (DataAccessException ex) {
			ex.printStackTrace();
			sps = new StatusProcessService("Ocurrió un error relacionado con la base de datos, "+ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

		} catch (Exception ex) {
			ex.printStackTrace();
			sps = new StatusProcessService("Ocurrió un error inesperado", HttpStatus.INTERNAL_SERVER_ERROR);

		}
		return sps;
	}

}
