package com.cabovianco.thenbhdapi.controller;

import com.cabovianco.thenbhdapi.dto.SongDto;
import com.cabovianco.thenbhdapi.service.SongService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/songs")
public class SongController {

    private final SongService songService;

    @Autowired
    public SongController(SongService songService) {
        this.songService = songService;
    }

    @GetMapping
    ResponseEntity<List<SongDto>> getAllSongs() {
        return ResponseEntity.ok(songService.getAllSongs());
    }

    @GetMapping("/{id}")
    ResponseEntity<SongDto> getSongById(@PathVariable Long id) {
        return ResponseEntity.ok(songService.getSongById(id));
    }

    @PostMapping
    ResponseEntity<SongDto> addSong(@Valid @RequestBody SongDto song) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(songService.addSong(song));
    }

    @PutMapping("/{id}")
    ResponseEntity<SongDto> updateSong(@PathVariable Long id, @Valid @RequestBody SongDto song) {
        return ResponseEntity.ok(songService.updateSong(id, song));
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteSongById(@PathVariable Long id) {
        songService.deleteSongById(id);
        return ResponseEntity.noContent().build();
    }

}
