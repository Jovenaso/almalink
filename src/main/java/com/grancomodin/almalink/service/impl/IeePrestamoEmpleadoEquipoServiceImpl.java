package com.grancomodin.almalink.service.impl;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.grancomodin.almalink.dao.IeePrestamoEmpleadoEquipoDao;
import com.grancomodin.almalink.dto.IeePrestamoEmpleadoEquipoDto;
import com.grancomodin.almalink.generic.BusquedaListaPaginar;
import com.grancomodin.almalink.generic.StatusProcessService;
import com.grancomodin.almalink.model.GralEmpleado;
import com.grancomodin.almalink.model.IeeEquipo;
import com.grancomodin.almalink.model.IeePrestamoEmpleadoEquipo;
import com.grancomodin.almalink.service.IeePrestamoEmpleadoEquipoService;
@Service
public class IeePrestamoEmpleadoEquipoServiceImpl implements IeePrestamoEmpleadoEquipoService{

	@Autowired
	private IeePrestamoEmpleadoEquipoDao dao;
	
	@Override
	public StatusProcessService getById(Long id) {
		// TODO Auto-generated method stub
		StatusProcessService sps = null;
		try {
			IeePrestamoEmpleadoEquipoDto dto = dao.findByIdDto(id);
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

	@Transactional(rollbackFor = { DataAccessException.class, Exception.class })
	@Override
	public StatusProcessService post(IeePrestamoEmpleadoEquipoDto post) {
		// TODO Auto-generated method stub
		StatusProcessService sps = null;
		try {
			IeePrestamoEmpleadoEquipo create = new IeePrestamoEmpleadoEquipo();
			create.setPrestado(post.getPrestado());
			create.setEmpleado(new GralEmpleado(post.getGral_empleado_id()));
			create.setEncargado(new GralEmpleado(post.getGral_encargado_id()));
			create.setEquipo(new IeeEquipo(post.getIee_equipo_id()));
			create.setFecha_prestamo(post.getFecha_devolucion_estimada());
			create.setFecha_devolucion_estimada(post.getFecha_devolucion_estimada());
			create.setActivo(true);
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
	public StatusProcessService put(IeePrestamoEmpleadoEquipoDto put) {
		// TODO Auto-generated method stub
		StatusProcessService sps = null;
		try {
			IeePrestamoEmpleadoEquipo update = dao.findById(put.getId()).orElse(null);
			update.setPrestado(put.getPrestado());
			update.setEmpleado(new GralEmpleado(put.getGral_empleado_id()));
			update.setEncargado(new GralEmpleado(put.getGral_encargado_id()));
			update.setEquipo(new IeeEquipo(put.getIee_equipo_id()));
			update.setFecha_prestamo(put.getFecha_devolucion_estimada());
			update.setFecha_devolucion_estimada(put.getFecha_devolucion_estimada());
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
			IeePrestamoEmpleadoEquipo baja = dao.findById(id).orElse(null);
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
