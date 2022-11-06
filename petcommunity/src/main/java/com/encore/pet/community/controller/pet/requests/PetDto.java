package com.encore.pet.community.controller.pet.requests;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@Builder
public class PetDto {

    private Long petId;
    private String userId;
    private Integer categoryId;
    private String petName;
    private Integer age;
    private String gender;

}
