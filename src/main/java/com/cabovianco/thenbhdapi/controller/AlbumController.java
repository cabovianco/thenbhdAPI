package com.cabovianco.thenbhdapi.controller;

import com.cabovianco.thenbhdapi.dto.AlbumDto;
import com.cabovianco.thenbhdapi.service.AlbumService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/albums")
public class AlbumController {

    private final AlbumService albumService;

    @Autowired
    public AlbumController(AlbumService albumService) {
        this.albumService = albumService;
    }

    @GetMapping
    ResponseEntity<List<AlbumDto>> getAllAlbums() {
        return ResponseEntity.ok(albumService.getAllAlbums());
    }

    @GetMapping("/{id}")
    ResponseEntity<AlbumDto> getAlbumById(@PathVariable Long id) {
        return ResponseEntity.ok(albumService.getAlbumById(id));
    }

    @PostMapping
    ResponseEntity<AlbumDto> addAlbum(@Valid @RequestBody AlbumDto album) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(albumService.addAlbum(album));
    }

    @PutMapping("/{id}")
    ResponseEntity<AlbumDto> updateAlbum(@PathVariable Long id, @Valid @RequestBody AlbumDto album) {
        return ResponseEntity.ok(albumService.updateAlbum(id, album));
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteAlbumById(@PathVariable Long id) {
        albumService.deleteAlbumById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }

}
