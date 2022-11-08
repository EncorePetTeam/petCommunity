package com.encore.pet.community.controller.pet.requests;

import com.encore.pet.community.domain.pet.PetGender;
import com.encore.pet.community.domain.pet.PetGenderNeutral;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class RegisterPetRequest {

    private final String userId;
    private final String categoryId;
    private final String petName;
    private final Integer age;
    private final PetGender petGender;
    private final PetGenderNeutral petGenderNeutral;

    public RegisterPetRequest(String userId, String categoryId, String petName, Integer age, PetGender petGender, PetGenderNeutral petGenderNeutral) {
        this.userId = userId;
        this.categoryId = categoryId;
        this.petName = petName;
        this.age = age;
        this.petGender = petGender;
        this.petGenderNeutral = petGenderNeutral;
    }
}
