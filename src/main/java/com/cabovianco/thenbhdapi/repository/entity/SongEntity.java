package com.cabovianco.thenbhdapi.repository.entity;

import jakarta.persistence.*;
import lombok.*;

@Builder
@Getter
@Setter
@Entity
@Table(name = "songs")
@NoArgsConstructor
@AllArgsConstructor
public class SongEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long albumId;

    @ManyToOne
    @JoinColumn(name = "album")
    private AlbumEntity album;

    private String name;

    private Integer durationInSeconds;

}
