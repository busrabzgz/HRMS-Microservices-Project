package com.example.userservice.mapper;

import com.example.userservice.dto.CreateUserRequestDto;
import com.example.userservice.dto.UpdateUserRequestDto;
import com.example.userservice.dto.UserResponseDto;
import com.example.userservice.entity.User;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUserFromCreateUserRequestDto(CreateUserRequestDto userRequestDto);

    @InheritInverseConfiguration
    @Mapping(source = "userId",target = "id")
    User toUserFromUpdateUserRequestDto(UpdateUserRequestDto userRequestDto);

    List<UserResponseDto> toUserResponseDTOsFromUsers(List<User> users);

    UserResponseDto toUserResponseDtoFromUser(User user);
}
