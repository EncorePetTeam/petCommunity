package com.encore.pet.community.common;

import com.encore.pet.community.controller.user.requests.UserDTO;
import com.encore.pet.community.domain.user.User;

public class UserMapper {


    //dto -> entity
    public static User userDTOtoEntity(UserDTO userDto) {
        return User.builder().id(userDto.getId())
                .password(userDto.getPassword())
                .state(userDto.getState())
                .salt(userDto.getSalt())
                .build();
    }


    // DTO -> Entity + salt적용
    public static User afterEncryptEntity(UserDTO userDto, String afterEncryptPassword, String salt) {
        return User.builder().id(userDto.getId())
                .password(afterEncryptPassword)
                .salt(salt)
                .state(userDto.getState())
                .build();
    };


    // Entity -> DTO
    public static UserDTO EntityToDTO(User user){
        return UserDTO.builder()
                .id(user.getId())
                .password(user.getPassword())
                .state(user.getState())
                .salt(user.getSalt())
                .build();
    }
}
