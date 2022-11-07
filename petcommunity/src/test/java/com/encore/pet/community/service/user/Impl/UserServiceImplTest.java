package com.encore.pet.community.service.user.Impl;

import com.encore.pet.community.common.UserMapper;
import com.encore.pet.community.controller.user.requests.UserDTO;
import com.encore.pet.community.domain.user.User;
import com.encore.pet.community.repository.UserRepository;
import com.encore.pet.community.service.user.UserService;
import com.encore.pet.community.utils.Encrypt;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class UserServiceImplTest {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    @Test
    @DisplayName("조인 메서드 테스트 - 정상")
    void join() {
        //given
        String id = "test1";
        String password = "1111";
        int state = 1;
        UserDTO userDto = UserDTO.builder().id(id)
                .password(password)
                .state(state)
                .build();
        int user = userService.join(userDto);
//        Encrypt encrypt = new Encrypt();
//        encrypt.getEncrypt(password,encrypt.getSalt());
//
//        //when
//        UserDTO userDto = UserDTO.builder().id(id).password(encrypt.getSalt()).state(state).salt(encrypt.getEncrypt(password,encrypt.getSalt())).build();
//        //then
//        System.out.println(UserMapper.userDTOtoEntity(userDto).getPassword());
//        System.out.println(UserMapper.userDTOtoEntity(userDto).getSalt());
        Assertions.assertThat((UserMapper.userDTOtoEntity(userDto).getId())).isEqualTo(id);
    }

    @Test
    @DisplayName("로그인 메서드 테스트 - 정상")
    void login() {

        //given
        String id = "test1";
        String password = "1111";
        int state = 1;
        //when
        UserDTO userDto = UserDTO.builder().id(id)
                .password(password)
                .state(state)
                .build();

        //then
//        Assertions.assertThat((UserMapper.EntityToDTO(userDto))).isEqualTo(id).isEqualTo(password);
//        userRepository.findByIdAndPassword(userDto.getId(),userDto.getPassword());
        boolean result = userService.login(userDto);
        System.out.println(result);
    }


    @Test
    @DisplayName("id 중복확인 메서드 테스트 - 정상")
    void idCheck() {

        //given
        String id = "test1";

        //when
        UserDTO userDto = UserDTO.builder().id(id).build();

        //then
        boolean result = userService.idCheck(userDto);
        System.out.println(result);


    }
}