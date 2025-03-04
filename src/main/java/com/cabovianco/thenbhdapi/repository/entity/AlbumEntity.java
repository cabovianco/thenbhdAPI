package com.cabovianco.thenbhdapi.repository.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Builder
@Getter
@Setter
@Entity
@Table(name = "albums")
@NoArgsConstructor
@AllArgsConstructor
public class AlbumEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String genre;

    @OneToMany(mappedBy = "album", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<SongEntity> songs = new ArrayList<>();

    private LocalDate release;

}
