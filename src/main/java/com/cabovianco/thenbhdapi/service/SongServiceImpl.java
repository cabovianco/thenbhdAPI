package com.cabovianco.thenbhdapi.service;

import com.cabovianco.thenbhdapi.dto.SongDto;
import com.cabovianco.thenbhdapi.dto.mapper.SongMapper;
import com.cabovianco.thenbhdapi.exception.AlbumNotFoundException;
import com.cabovianco.thenbhdapi.exception.SongNotFoundException;
import com.cabovianco.thenbhdapi.repository.AlbumRepository;
import com.cabovianco.thenbhdapi.repository.SongRepository;
import com.cabovianco.thenbhdapi.repository.entity.AlbumEntity;
import com.cabovianco.thenbhdapi.repository.entity.SongEntity;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongServiceImpl implements SongService {

    private final SongRepository songRepository;
    private final AlbumRepository albumRepository;

    @Autowired
    public SongServiceImpl(SongRepository songRepository, AlbumRepository albumRepository) {
        this.songRepository = songRepository;
        this.albumRepository = albumRepository;
    }

    @Override
    public List<SongDto> getAllSongs() {
        return songRepository.findAll(Sort.by(Sort.Direction.ASC, "id"))
                .stream().map(SongMapper::toDto).toList();
    }

    @Override
    @SneakyThrows
    public SongDto getSongById(Long id) {
        SongEntity song = songRepository.findById(id)
                .orElseThrow(() -> new SongNotFoundException(id));

        return SongMapper.toDto(song);
    }

    @Override
    @SneakyThrows
    public SongDto addSong(SongDto song) {
        AlbumEntity album = albumRepository.findById(song.getAlbumId())
                .orElseThrow(() -> new AlbumNotFoundException(song.getAlbumId()));

        SongEntity songEntity = SongMapper.toEntity(song);
        songEntity.setAlbum(album);

        return SongMapper.toDto(songRepository.save(songEntity));
    }

    @Override
    @SneakyThrows
    public SongDto updateSong(Long id, SongDto updatedSong) {
        SongEntity song = songRepository.findById(id)
                .orElseThrow(() -> new SongNotFoundException(id));

        song.setAlbumId(updatedSong.getAlbumId());
        song.setName(updatedSong.getName());
        song.setDurationInSeconds(updatedSong.getDurationInSeconds());

        AlbumEntity album = albumRepository.findById(song.getAlbumId())
                        .orElseThrow(() -> new AlbumNotFoundException(song.getId()));

        song.setAlbum(album);

        return SongMapper.toDto(songRepository.save(song));
    }

    @Override
    public void deleteSongById(Long id) {
        songRepository.deleteById(id);
    }

}
