package com.cabovianco.thenbhdapi.service;

import com.cabovianco.thenbhdapi.dto.AlbumDto;
import com.cabovianco.thenbhdapi.dto.mapper.AlbumMapper;
import com.cabovianco.thenbhdapi.exception.AlbumNotFoundException;
import com.cabovianco.thenbhdapi.repository.AlbumRepository;
import com.cabovianco.thenbhdapi.repository.entity.AlbumEntity;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumServiceImpl implements AlbumService {

    private final AlbumRepository albumRepository;

    @Autowired
    public AlbumServiceImpl(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    @Override
    public List<AlbumDto> getAllAlbums() {
        return albumRepository.findAll(Sort.by(Sort.Direction.ASC, "id"))
                .stream().map(AlbumMapper::toDto).toList();
    }

    @Override
    @SneakyThrows
    public AlbumDto getAlbumById(Long id) {
        AlbumEntity album = albumRepository.findById(id)
                .orElseThrow(() -> new AlbumNotFoundException(id));

        return AlbumMapper.toDto(album);
    }

    @Override
    @SneakyThrows
    public AlbumDto addAlbum(AlbumDto album) {
        return AlbumMapper.toDto(albumRepository.save(AlbumMapper.toEntity(album)));
    }

    @Override
    @SneakyThrows
    public AlbumDto updateAlbum(Long id, AlbumDto updatedAlbum) {
        AlbumEntity album = albumRepository.findById(id)
                        .orElseThrow(() -> new AlbumNotFoundException(id));

        album.setName(updatedAlbum.getName());
        album.setGenre(updatedAlbum.getGenre());
        album.setRelease(updatedAlbum.getRelease());

        return AlbumMapper.toDto(albumRepository.save(album));
    }

    @Override
    public void deleteAlbumById(Long id) {
        albumRepository.deleteById(id);
    }

}
