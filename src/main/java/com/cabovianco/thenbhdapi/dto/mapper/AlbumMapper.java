package com.cabovianco.thenbhdapi.dto.mapper;

import com.cabovianco.thenbhdapi.dto.AlbumDto;
import com.cabovianco.thenbhdapi.repository.entity.AlbumEntity;

import java.util.List;

public class AlbumMapper {

    public static AlbumEntity toEntity(AlbumDto album) {
        return AlbumEntity.builder()
                .name(album.getName())
                .genre(album.getGenre())
                .songs(List.of())
                .release(album.getRelease())
                .build();
    }

    public static AlbumDto toDto(AlbumEntity album) {
        return AlbumDto.builder()
                .id(album.getId())
                .name(album.getName())
                .genre(album.getGenre())
                .songs(album.getSongs().stream().map(SongMapper::toDto).toList())
                .release(album.getRelease())
                .build();
    }

}
