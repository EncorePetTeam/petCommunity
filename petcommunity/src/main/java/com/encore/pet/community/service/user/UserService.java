package com.encore.pet.community.service.user;

import com.encore.pet.community.controller.user.requests.UserDTO;
import com.encore.pet.community.domain.user.User;

public interface UserService {

    //회원가입
    public int join(UserDTO userDto);

    //로그인
    public boolean login(UserDTO userDto);

    //id 중복확인
    public boolean idCheck(UserDTO userDto);

}
