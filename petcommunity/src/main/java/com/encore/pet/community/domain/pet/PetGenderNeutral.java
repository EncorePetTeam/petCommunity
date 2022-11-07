package com.encore.pet.community.domain.pet;

public enum PetGenderNeutral {

    NEUTRAL(0),
    NOT_NEUTRAL(1);

    private int value;

    PetGenderNeutral(int value) {
        this.value = value;
    }
}
