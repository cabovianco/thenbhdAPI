package com.cabovianco.thenbhdapi.repository;

import com.cabovianco.thenbhdapi.repository.entity.SongEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SongRepository extends JpaRepository<SongEntity, Long> {
}
