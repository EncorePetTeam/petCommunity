package com.encore.pet.community.domain.pet;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum PetGender {
    MALE, FEMALE;

    @JsonCreator
    public static PetGender from(String s){
        return PetGender.valueOf(s.toUpperCase());
    }
}
