package com.encore.pet.community.common;

import com.encore.pet.community.controller.user.requests.UserDTO;
import com.encore.pet.community.domain.user.User;

public class UserMapper {


    //UserDTO -> UserEntity
    public static User userDTOtoEntity(UserDTO userDto) {
        return User.builder().id(userDto.getId())
                .password(userDto.getPassword())
                .state(userDto.getState())
                .salt(userDto.getSalt())
                .build();
    }


    // UserDTO -> UserEntity + salt적용
    public static User afterEncryptEntity(UserDTO userDto, String afterEncryptPassword, String salt) {
        return User.builder().id(userDto.getId())
                .password(afterEncryptPassword)
                .salt(salt)
                .state(userDto.getState())
                .build();
    };


    // UserEntity -> UserDTO
    public static UserDTO EntityToUserDTO(User user){
        return UserDTO.builder()
                .id(user.getId())
                .password(user.getPassword())
                .state(user.getState())
                .salt(user.getSalt())
                .build();
    }
}
