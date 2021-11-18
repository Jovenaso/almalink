package com.grancomodin.almalink.service.impl;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.grancomodin.almalink.dao.GralUsrDao;
import com.grancomodin.almalink.dto.GralUsrDto;
import com.grancomodin.almalink.generic.StatusProcessService;
import com.grancomodin.almalink.model.GralUsr;
import com.grancomodin.almalink.service.GralUsrService;
@Service
public class GralUsrServiceImpl implements GralUsrService{
	@Autowired
	private GralUsrDao dao;
	@Override
	public StatusProcessService getById(Long id) {
		// TODO Auto-generated method stub
		StatusProcessService sps = null;
		try {
			GralUsrDto dto = dao.findByIdDto(id);
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
	public StatusProcessService post(GralUsrDto post) {
		// TODO Auto-generated method stub
		StatusProcessService sps = null;
		try {
			GralUsr create = new GralUsr();
			create.setCorreo(post.getCorreo());
			create.setTipo_usr(post.getTipo_usr());
			create.setFoto(post.getFoto());
			create.setNombre(post.getNombre());
			create.setPassword(post.getPassword());
			create.setFecha_alta(new Date());
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
	public StatusProcessService put(GralUsrDto put) {
		// TODO Auto-generated method stub
		StatusProcessService sps = null;
		try {
			GralUsr create = dao.findById(put.getId()).orElse(null);
			create.setCorreo(put.getCorreo());
			create.setTipo_usr(put.getTipo_usr());
			create.setFoto(put.getFoto());
			create.setNombre(put.getNombre());
			create.setPassword(put.getPassword());
			create.setFecha_actualiza(new Date());
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
	public StatusProcessService baja(Long id) {
		// TODO Auto-generated method stub
		StatusProcessService sps = null;
		try {
			GralUsr baja = dao.findById(id).orElse(null);
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
