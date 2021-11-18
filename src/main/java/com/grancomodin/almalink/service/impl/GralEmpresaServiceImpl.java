package com.grancomodin.almalink.service.impl;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.grancomodin.almalink.dao.GralEmpresaDao;
import com.grancomodin.almalink.dto.GralEmpresaDto;
import com.grancomodin.almalink.generic.StatusProcessService;
import com.grancomodin.almalink.model.GralEmpresa;
import com.grancomodin.almalink.service.GralEmpresaService;
@Service
public class GralEmpresaServiceImpl implements GralEmpresaService{

@Autowired
private GralEmpresaDao dao;
	@Override
	public StatusProcessService getById(Long id) {
		// TODO Auto-generated method stub
		StatusProcessService sps = null;
		try {
			GralEmpresaDto dto = dao.findByIdDto(id);
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
	public StatusProcessService post(GralEmpresaDto post) {
		// TODO Auto-generated method stub
		StatusProcessService sps = null;
		try {
			GralEmpresa create = new GralEmpresa();
			create.setNombre(post.getNombre());
			create.setDireccion(post.getDireccion());
			create.setLogo(post.getLogo());
			create.setNombre_comercial(post.getNombre_comercial());
			create.setRfc(post.getNombre_comercial());
			create.setActivo(true);
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
	public StatusProcessService put(GralEmpresaDto put) {
		// TODO Auto-generated method stub
		StatusProcessService sps = null;
		try {
			GralEmpresa update = dao.findById(put.getId()).orElse(null);
			update.setNombre(put.getNombre());
			update.setDireccion(put.getDireccion());
			update.setLogo(put.getLogo());
			update.setNombre_comercial(put.getNombre_comercial());
			update.setRfc(put.getNombre_comercial());
			
			
			// update.setEmpresa(new GralEmpresa(put.getId()));
			update.setFecha_actualiza(new Date());
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
			GralEmpresa baja = dao.findById(id).orElse(null);
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
