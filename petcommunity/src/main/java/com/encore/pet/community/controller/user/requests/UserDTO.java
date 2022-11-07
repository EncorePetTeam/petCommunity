package com.encore.pet.community.controller.user.requests;


import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
public final class UserDTO {
    @NotBlank(message = "id를 입력해주세요")
    // 영문, 숫자 4글자 이상 12글자 이하
    @Pattern(regexp = " /^[A-Za-z0-9]{4,12}$/")
    final private String id;
    @NotBlank(message = "password를 입력해주세요")
    // 문자, 숫자, 특수문자 포함한 정규식 8자이상
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$", message = "올바른 형식으로 입력해주세요")
    final private String password;
    final private int state;
    final private String salt;

    //빌더
    @Builder
    public UserDTO(String id, String password, int state, String salt) {
        this.id = id;
        this.password = password;
        this.state = state;
        this.salt = salt;
    }



}

