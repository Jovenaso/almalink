package com.grancomodin.almalink.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.grancomodin.almalink.dto.GralUsrDto;
import com.grancomodin.almalink.model.GralUsr;

public interface GralUsrDao extends JpaRepository<GralUsr, Long>{

	@Query("select u from GralUsr u WHERE u.correo =:email")
	GralUsr findByEmail(String email);
	@Query("select new com.grancomodin.almalink.dto.GralUsrDto(u.id, u.nombre, u.correo, u.password, u.foto, u.tipo_usr) from GralUsr u WHERE u.id =:id")
	GralUsrDto findByIdDto(Long id);
}
