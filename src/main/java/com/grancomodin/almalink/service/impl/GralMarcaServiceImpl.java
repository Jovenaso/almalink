package com.grancomodin.almalink.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.grancomodin.almalink.dao.GralMarcaDao;
import com.grancomodin.almalink.dto.GralMarcaDto;
import com.grancomodin.almalink.generic.StatusProcessService;
import com.grancomodin.almalink.model.GralMarca;
import com.grancomodin.almalink.service.GralMarcaService;
@Service
public class GralMarcaServiceImpl implements GralMarcaService{
	@Autowired
	private GralMarcaDao dao;

	@Override
	public StatusProcessService getById(Long id) {
		// TODO Auto-generated method stub
		StatusProcessService sps = null;
		try {
			GralMarcaDto dto = dao.findByIdDto(id);
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
	public StatusProcessService post(GralMarcaDto post) {
		// TODO Auto-generated method stub
		StatusProcessService sps = null;
		try {
			GralMarca create = new GralMarca();
			create.setTitulo(post.getTitulo());
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
	public StatusProcessService put(GralMarcaDto put) {
		// TODO Auto-generated method stub
		StatusProcessService sps = null;
		try {
			GralMarca update = dao.findById(put.getId()).orElse(null);
			update.setTitulo(put.getTitulo());
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
		return null;
	}

}
