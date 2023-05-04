package com.example.userservice.service;

import com.example.userservice.dto.CreateUserRequestDto;
import com.example.userservice.dto.UpdateUserRequestDto;
import com.example.userservice.dto.UserResponseDto;
import com.example.userservice.entity.User;
import com.example.userservice.exception.UserNotFoundException;
import com.example.userservice.mapper.UserMapper;

import com.example.userservice.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor // final olmali yazdigim class
@Slf4j
@Service
public class UserService {



    private final UserMapper userMapper;
    private final UserRepository userRepository;


//    public UserResponseDto createUser(CreateUserRequestDto createUserRequestDto) throws Exception {
//        // burada henüz database kayıt olmadığı için id yok
//        User user = userMapper.toUserFromCreateUserRequestDto(createUserRequestDto);
//        // id olduğu için tekrar user'a atıyoruz
//        user = userRepository.save(user);
//        UserResponseDto userResponseDto = userMapper.toUserResponseDtoFromUser(user);
//        System.out.println(userResponseDto);
//        return userResponseDto;
//    }





    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }



}
