package com.encore.pet.community.utils.mapper;

import com.encore.pet.community.controller.pet.requests.RegisterPetRequest;
import com.encore.pet.community.controller.pet.responses.RegisterPetResponse;
import com.encore.pet.community.domain.pet.Pet;
import com.encore.pet.community.domain.pet.PetCategory;
import com.encore.pet.community.domain.user.User;

public class PetMapper {

    private PetMapper(){}
    public static Pet registerPetRequestToEntity(RegisterPetRequest registerPetRequest, User user, PetCategory petCategory) {
        return Pet.builder().user(user).petCategory(petCategory)
                .petName(registerPetRequest.getPetName()).age(registerPetRequest.getAge())
                .gender(registerPetRequest.getPetGender()).petGenderNeutral(registerPetRequest.getPetGenderNeutral())
                .build();
    }
    public static RegisterPetResponse entityToRegisterPetResponse(Pet pet) {
        return RegisterPetResponse.builder()
                .petId(pet.getId())
                .userId(pet.getUser().getId())
                .categoryId(pet.getPetCategory().getPetCategoryId())
                .petName(pet.getPetName())
                .age(pet.getAge())
                .petGender(pet.getGender())
                .petGenderNeutral(pet.getNeutral())
                .build();
    }
}
