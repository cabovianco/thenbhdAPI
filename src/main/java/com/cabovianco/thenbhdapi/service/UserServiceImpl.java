package com.cabovianco.thenbhdapi.service;

import com.cabovianco.thenbhdapi.dto.UserDto;
import com.cabovianco.thenbhdapi.dto.mapper.UserMapper;
import com.cabovianco.thenbhdapi.repository.UserRepository;
import com.cabovianco.thenbhdapi.repository.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void registerUser(UserDto user) {
        UserEntity userEntity = UserMapper.toEntity(user);
        userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
        userRepository.save(userEntity);
    }

    @Override
    public void deleteAllUsers() {
        userRepository.deleteAll();
    }

}
