package com.cabovianco.thenbhdapi.repository;

import com.cabovianco.thenbhdapi.repository.entity.AlbumEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumRepository extends JpaRepository<AlbumEntity, Long> {
}
