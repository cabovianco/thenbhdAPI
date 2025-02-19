package com.cabovianco.thenbhdapi.security;

import com.cabovianco.thenbhdapi.dto.UserDto;
import com.cabovianco.thenbhdapi.dto.mapper.UserMapper;
import com.cabovianco.thenbhdapi.repository.UserRepository;
import com.cabovianco.thenbhdapi.repository.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User " + username + " not found."));

        UserDto userDto = UserMapper.toDto(user);

        return User.builder()
                .username(userDto.getUsername())
                .password(userDto.getPassword())
                .build();
    }

}
