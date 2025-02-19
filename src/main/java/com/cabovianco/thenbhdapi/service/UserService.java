package com.cabovianco.thenbhdapi.service;

import com.cabovianco.thenbhdapi.dto.UserDto;

public interface UserService {

    void registerUser(UserDto user);

    void deleteAllUsers();

}
