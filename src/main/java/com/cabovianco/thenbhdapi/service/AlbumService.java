package com.cabovianco.thenbhdapi.service;

import com.cabovianco.thenbhdapi.dto.AlbumDto;

import java.util.List;

public interface AlbumService {

    List<AlbumDto> getAllAlbums();

    AlbumDto getAlbumById(Long id);

    AlbumDto addAlbum(AlbumDto album);

    AlbumDto updateAlbum(Long id, AlbumDto updatedAlbum);

    void deleteAlbumById(Long id);

}
