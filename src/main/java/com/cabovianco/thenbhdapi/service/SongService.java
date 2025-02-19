package com.cabovianco.thenbhdapi.service;

import com.cabovianco.thenbhdapi.dto.SongDto;

import java.util.List;

public interface SongService {

    List<SongDto> getAllSongs();

    SongDto getSongById(Long id);

    SongDto addSong(SongDto song);

    SongDto updateSong(Long id, SongDto updatedSong);

    void deleteSongById(Long id);

}
