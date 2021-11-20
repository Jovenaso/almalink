package com.grancomodin.almalink.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.grancomodin.almalink.dto.GralEmpleadoDto;
import com.grancomodin.almalink.generic.StatusProcessService;
import com.grancomodin.almalink.service.GralEmpleadoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("empleado")
@Api(value = "empleado")
public class EmpleadoController {
	@Autowired
	private GralEmpleadoService service;

	private Map<String, Object> response = null;
	@ApiOperation(value = "Baja", notes = "")
	@ApiResponses({
			@ApiResponse(code = HttpServletResponse.SC_OK, message = "La transacción sé ha realizado correctamente"),
			@ApiResponse(code = HttpServletResponse.SC_NOT_FOUND, message = "Ha ocurrido un error durante la consulta a la base de datos"),
			@ApiResponse(code = HttpServletResponse.SC_UNSUPPORTED_MEDIA_TYPE, message = "Ha ocurrido un error al momento de descomprimir una imagen"),
			@ApiResponse(code = HttpServletResponse.SC_INTERNAL_SERVER_ERROR, message = "Ha ocurrido un error inesperado durante la operación"),
			@ApiResponse(code = HttpServletResponse.SC_UNAUTHORIZED, message = "Es necesario estar autenticado para acceder a este recurso"),
			@ApiResponse(code = HttpServletResponse.SC_FORBIDDEN, message = "El recurso no está disponible para éste usuario") })
	@GetMapping("/get/{id}")
	public ResponseEntity<?> get(@PathVariable Long id) {
		response = new HashMap<>();
		StatusProcessService status = service.getById(id);
		response.put("contenido", status.getContenido());
		response.put("mensaje", status.getMensaje());
		return new ResponseEntity<>(response, status.getHttpStatus());
	}
	@ApiOperation(value = "busqueda", notes = "")
	@ApiResponses({
			@ApiResponse(code = HttpServletResponse.SC_OK, message = "La transacción sé ha realizado correctamente"),
			@ApiResponse(code = HttpServletResponse.SC_NOT_FOUND, message = "Ha ocurrido un error durante la consulta a la base de datos"),
			@ApiResponse(code = HttpServletResponse.SC_UNSUPPORTED_MEDIA_TYPE, message = "Ha ocurrido un error al momento de descomprimir una imagen"),
			@ApiResponse(code = HttpServletResponse.SC_INTERNAL_SERVER_ERROR, message = "Ha ocurrido un error inesperado durante la operación"),
			@ApiResponse(code = HttpServletResponse.SC_UNAUTHORIZED, message = "Es necesario estar autenticado para acceder a este recurso"),
			@ApiResponse(code = HttpServletResponse.SC_FORBIDDEN, message = "El recurso no está disponible para éste usuario") })
	@PostMapping("/busqueda")
	public ResponseEntity<?> busqueda(@RequestBody Map<String, Object> conditions) {
		response = new HashMap<>();
		StatusProcessService status = service.busqueda(conditions);
		response.put("contenido", status.getContenido());
		response.put("mensaje", status.getMensaje());
		return new ResponseEntity<>(response, status.getHttpStatus());
	}
	@ApiOperation(value = "Baja", notes = "")
	@ApiResponses({
			@ApiResponse(code = HttpServletResponse.SC_OK, message = "La transacción sé ha realizado correctamente"),
			@ApiResponse(code = HttpServletResponse.SC_NOT_FOUND, message = "Ha ocurrido un error durante la consulta a la base de datos"),
			@ApiResponse(code = HttpServletResponse.SC_UNSUPPORTED_MEDIA_TYPE, message = "Ha ocurrido un error al momento de descomprimir una imagen"),
			@ApiResponse(code = HttpServletResponse.SC_INTERNAL_SERVER_ERROR, message = "Ha ocurrido un error inesperado durante la operación"),
			@ApiResponse(code = HttpServletResponse.SC_UNAUTHORIZED, message = "Es necesario estar autenticado para acceder a este recurso"),
			@ApiResponse(code = HttpServletResponse.SC_FORBIDDEN, message = "El recurso no está disponible para éste usuario") })
	@PostMapping("/post")
	public ResponseEntity<?> post(@RequestBody GralEmpleadoDto dto) {
		response = new HashMap<>();
		StatusProcessService status = service.post(dto);
		response.put("mensaje", status.getMensaje());
		return new ResponseEntity<>(response, status.getHttpStatus());
	}
	@ApiOperation(value = "Baja", notes = "")
	@ApiResponses({
			@ApiResponse(code = HttpServletResponse.SC_OK, message = "La transacción sé ha realizado correctamente"),
			@ApiResponse(code = HttpServletResponse.SC_NOT_FOUND, message = "Ha ocurrido un error durante la consulta a la base de datos"),
			@ApiResponse(code = HttpServletResponse.SC_UNSUPPORTED_MEDIA_TYPE, message = "Ha ocurrido un error al momento de descomprimir una imagen"),
			@ApiResponse(code = HttpServletResponse.SC_INTERNAL_SERVER_ERROR, message = "Ha ocurrido un error inesperado durante la operación"),
			@ApiResponse(code = HttpServletResponse.SC_UNAUTHORIZED, message = "Es necesario estar autenticado para acceder a este recurso"),
			@ApiResponse(code = HttpServletResponse.SC_FORBIDDEN, message = "El recurso no está disponible para éste usuario") })
	@PutMapping("/put")
	public ResponseEntity<?> put(@RequestBody GralEmpleadoDto dto) {
		response = new HashMap<>();
		StatusProcessService status = service.put(dto);
		response.put("mensaje", status.getMensaje());
		return new ResponseEntity<>(response, status.getHttpStatus());
	}

	@ApiOperation(value = "Baja", notes = "")
	@ApiResponses({
			@ApiResponse(code = HttpServletResponse.SC_OK, message = "La transacción sé ha realizado correctamente"),
			@ApiResponse(code = HttpServletResponse.SC_NOT_FOUND, message = "Ha ocurrido un error durante la consulta a la base de datos"),
			@ApiResponse(code = HttpServletResponse.SC_UNSUPPORTED_MEDIA_TYPE, message = "Ha ocurrido un error al momento de descomprimir una imagen"),
			@ApiResponse(code = HttpServletResponse.SC_INTERNAL_SERVER_ERROR, message = "Ha ocurrido un error inesperado durante la operación"),
			@ApiResponse(code = HttpServletResponse.SC_UNAUTHORIZED, message = "Es necesario estar autenticado para acceder a este recurso"),
			@ApiResponse(code = HttpServletResponse.SC_FORBIDDEN, message = "El recurso no está disponible para éste usuario") })
	@DeleteMapping("/baja/{id}")
	public ResponseEntity<?> baja(@PathVariable Long id) {
		response = new HashMap<>();
		StatusProcessService status = service.baja(id);
		response.put("mensaje", status.getMensaje());
		return new ResponseEntity<>(response, status.getHttpStatus());
	}
}
