package com.encore.pet.community.controller.pet.requests;

import com.encore.pet.community.domain.pet.PetGender;
import com.encore.pet.community.domain.pet.PetGenderNeutral;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@Builder
public class PetRequestDTO {

    private Long petId;
    private String userId;
    private Integer categoryId;
    private String petName;
    private Integer age;
    private PetGender petGender;
    private PetGenderNeutral petGenderNeutral;

}
