package com.grancomodin.almalink.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.grancomodin.almalink.dto.GralColorDto;
import com.grancomodin.almalink.model.GralColor;

public interface GralColorDao extends JpaRepository<GralColor, Long> {
	@Query("select new com.grancomodin.almalink.dto.GralColorDto(gc.id,gc.titulo) from GralColor gc where gc.id = ?1")
	GralColorDto findByIdDto(Long id);
}
