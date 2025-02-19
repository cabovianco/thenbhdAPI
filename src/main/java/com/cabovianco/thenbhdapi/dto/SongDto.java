package com.cabovianco.thenbhdapi.dto;

import jakarta.validation.constraints.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class SongDto {

    @Null
    private Long id;

    @NotNull(message = "Album ID can not be null.")
    private Long albumId;

    @NotEmpty(message = "Name can not be empty or null.")
    private String name;

    @NotNull(message = "Duration in seconds can not be null.")
    @Min(value = 0, message = "Min duration must be zero.")
    private Integer durationInSeconds;

}
