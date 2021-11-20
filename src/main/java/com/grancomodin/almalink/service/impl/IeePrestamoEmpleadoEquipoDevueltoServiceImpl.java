package com.grancomodin.almalink.service.impl;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.grancomodin.almalink.dao.IeePrestamoEmpleadoEquipoDevueltoDao;
import com.grancomodin.almalink.dto.IeePrestamoEmpleadoEquipoDevueltoDto;
import com.grancomodin.almalink.generic.BusquedaListaPaginar;
import com.grancomodin.almalink.generic.StatusProcessService;
import com.grancomodin.almalink.model.IeePrestamoEmpleadoEquipo;
import com.grancomodin.almalink.model.IeePrestamoEmpleadoEquipoDevuelto;
import com.grancomodin.almalink.service.IeePrestamoEmpleadoEquipoDevueltoService;
@Service
public class IeePrestamoEmpleadoEquipoDevueltoServiceImpl implements IeePrestamoEmpleadoEquipoDevueltoService{
	@Autowired
	private IeePrestamoEmpleadoEquipoDevueltoDao dao;
	@Override
	public StatusProcessService getById(Long id) {
		// TODO Auto-generated method stub
		StatusProcessService sps = null;
		try {
			IeePrestamoEmpleadoEquipoDevueltoDto dto = dao.findByIdDto(id);
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
	public StatusProcessService post(IeePrestamoEmpleadoEquipoDevueltoDto post) {
		// TODO Auto-generated method stub
		StatusProcessService sps = null;
		try {
			IeePrestamoEmpleadoEquipoDevuelto create = new IeePrestamoEmpleadoEquipoDevuelto();
			create.setComentarios(post.getComentarios());
			create.setFoto_evidencia(post.getFoto_evidencia());
			create.setPrestamo(new IeePrestamoEmpleadoEquipo(post.getId()));
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
	public StatusProcessService put(IeePrestamoEmpleadoEquipoDevueltoDto put) {
		// TODO Auto-generated method stub
		StatusProcessService sps = null;
		try {
			IeePrestamoEmpleadoEquipoDevuelto update = dao.findById(put.getId()).orElse(null);
			update.setComentarios(update.getComentarios());
			update.setFoto_evidencia(update.getFoto_evidencia());
			update.setPrestamo(new IeePrestamoEmpleadoEquipo(update.getId()));
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
			IeePrestamoEmpleadoEquipoDevuelto baja = dao.findById(id).orElse(null);
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
