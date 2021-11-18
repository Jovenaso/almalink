package com.grancomodin.almalink.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.grancomodin.almalink.dao.GralEmpleadoDao;
import com.grancomodin.almalink.dto.GralEmpleadoDto;
import com.grancomodin.almalink.generic.StatusProcessService;
import com.grancomodin.almalink.model.GralEmpleado;
import com.grancomodin.almalink.model.GralEmpresa;
import com.grancomodin.almalink.model.GralPuesto;
import com.grancomodin.almalink.service.GralEmpleadoService;
@Service
public class GralEmpleadoServiceImpl implements GralEmpleadoService{
@Autowired
private GralEmpleadoDao dao;
	@Override
	public StatusProcessService getById(Long id) {
		// TODO Auto-generated method stub
		StatusProcessService sps = null;
		try {
			GralEmpleadoDto dto = dao.findByIdDto(id);
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
	public StatusProcessService post(GralEmpleadoDto post) {
		// TODO Auto-generated method stub
		StatusProcessService sps = null;
		try {
			GralEmpleado create = new GralEmpleado();
			create.setApellido(post.getApellido());
			create.setNombre(post.getNombre());
			create.setPuesto(new GralPuesto(post.getPuesto_id()));
			create.setEmpresa(new GralEmpresa(post.getGral_empresa_id()));
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
	public StatusProcessService put(GralEmpleadoDto put) {
		// TODO Auto-generated method stub
		StatusProcessService sps = null;
		try {
			GralEmpleado update = dao.findById(put.getId()).orElse(null);
			update.setApellido(put.getApellido());
			update.setNombre(put.getNombre());
			update.setPuesto(new GralPuesto(put.getId()));
			// update.setEmpresa(new GralEmpresa(put.getId()));
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
			GralEmpleado baja = dao.findById(id).orElse(null);
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
