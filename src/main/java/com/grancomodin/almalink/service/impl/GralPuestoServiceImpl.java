package com.grancomodin.almalink.service.impl;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.grancomodin.almalink.dao.GralPuestoDao;
import com.grancomodin.almalink.dto.GralPuestoDto;
import com.grancomodin.almalink.generic.BusquedaListaPaginar;
import com.grancomodin.almalink.generic.StatusProcessService;
import com.grancomodin.almalink.model.GralPuesto;
import com.grancomodin.almalink.service.GralPuestoService;
@Service
public class GralPuestoServiceImpl implements GralPuestoService{
	@Autowired
	private GralPuestoDao dao;

	@Override
	public StatusProcessService getById(Long id) {
		// TODO Auto-generated method stub
		StatusProcessService sps = null;
		try {
			GralPuestoDto dto = dao.findByIdDto(id);
			if (dto != null) {
				sps = new StatusProcessService("Operación exitosa", HttpStatus.CREATED);
				sps.setContenido(dto);
			} else {
				sps = new StatusProcessService("No existe un registro con el id "+id, HttpStatus.CONFLICT);
			}

		} catch (DataAccessException ex) {
			ex.printStackTrace();
			sps = new StatusProcessService("Ocurrió un error relacionado con la base de datos, "+ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

		} catch (Exception ex) {
			ex.printStackTrace();
			sps = new StatusProcessService("Ocurrió un error inesperado", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return sps;
	}

	@Transactional(rollbackFor = {DataAccessException.class, Exception.class})
	@Override
	public StatusProcessService post(GralPuestoDto post) {
		// TODO Auto-generated method stub
		StatusProcessService sps = null;
		try {
			GralPuesto create = new GralPuesto();
			create.setTitulo(post.getTitulo());
			create.setDescripcion(post.getDescripcion());
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

	@Transactional(rollbackFor = {DataAccessException.class, Exception.class})
	@Override
	public StatusProcessService put(GralPuestoDto put) {
		// TODO Auto-generated method stub
		StatusProcessService sps = null;
		try {
			GralPuesto update = dao.findById(put.getId()).orElse(null);
			update.setTitulo(put.getTitulo());
			update.setDescripcion(put.getDescripcion());
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

	@Transactional(rollbackFor = {DataAccessException.class, Exception.class})
	@Override
	public StatusProcessService baja(Long id) {
		// TODO Auto-generated method stub
		StatusProcessService sps = null;
		try {
			GralPuesto baja = dao.findById(id).orElse(null);
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
	@Override
	public StatusProcessService busqueda(Map<String, Object> conditions) {
		// TODO Auto-generated method stub
		StatusProcessService sps = null;
		try {
			BusquedaListaPaginar blp = dao.busqueda(conditions);
			sps = new StatusProcessService("Operación exitosa", HttpStatus.CREATED);
			sps.setContenido(blp);
			
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
