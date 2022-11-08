package com.encore.pet.community.domain.pet;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum PetGenderNeutral {

    NEUTRAL(0),
    NOT_NEUTRAL(1);

    private int value;

    PetGenderNeutral(int value) {
        this.value = value;
    }

    @JsonCreator
    public static PetGenderNeutral from(String s){
        return PetGenderNeutral.valueOf(s.toUpperCase());
    }

}
