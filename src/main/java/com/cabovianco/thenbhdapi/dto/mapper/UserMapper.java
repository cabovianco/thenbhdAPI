package com.cabovianco.thenbhdapi.dto.mapper;

import com.cabovianco.thenbhdapi.dto.UserDto;
import com.cabovianco.thenbhdapi.repository.entity.UserEntity;

public class UserMapper {

    public static UserEntity toEntity(UserDto user) {
        return UserEntity.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .build();
    }

    public static UserDto toDto(UserEntity user) {
        return UserDto.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .build();
    }

}
