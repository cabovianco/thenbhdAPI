package com.cabovianco.thenbhdapi.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Builder
@Getter
@Setter
public class AlbumDto {

    @Null
    private Long id;

    @NotEmpty(message = "Name can not be empty or null.")
    private String name;

    @NotEmpty(message = "Genre can not be empty or null.")
    private String genre;

    @Null
    private List<SongDto> songs;

    @NotNull(message = "Release can not be null.")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate release;

}
