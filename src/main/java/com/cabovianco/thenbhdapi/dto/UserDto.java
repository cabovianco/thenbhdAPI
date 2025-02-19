package com.cabovianco.thenbhdapi.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class UserDto {

    private String username;

    private String password;

}
