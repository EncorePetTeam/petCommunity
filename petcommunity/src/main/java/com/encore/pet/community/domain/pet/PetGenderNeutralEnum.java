package com.encore.pet.community.domain.pet;

public enum PetGenderNeutralEnum {

    NEUTRAL(0),
    NOT_NEUTRAL(1);

    private int value;

    PetGenderNeutralEnum(int value) {
        this.value = value;
    }
}
