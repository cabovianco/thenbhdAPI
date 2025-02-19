package com.cabovianco.thenbhdapi.dto.mapper;

import com.cabovianco.thenbhdapi.dto.SongDto;
import com.cabovianco.thenbhdapi.repository.entity.SongEntity;

public class SongMapper {

    public static SongEntity toEntity(SongDto song) {
        return SongEntity.builder()
                .albumId(song.getAlbumId())
                .name(song.getName())
                .durationInSeconds(song.getDurationInSeconds())
                .build();
    }

    public static SongDto toDto(SongEntity song) {
        return SongDto.builder()
                .id(song.getId())
                .albumId(song.getAlbumId())
                .name(song.getName())
                .durationInSeconds(song.getDurationInSeconds())
                .build();
    }

}
