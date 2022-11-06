package com.encore.pet.community.domain.pet;

public enum PetCategoryEnum {

    DOG(0),
    CAT(1);

    private int value;


    PetCategoryEnum(int value) {
        this.value = value;
    }
}
