package com.encore.pet.community.service.pet;

import com.encore.pet.community.controller.pet.requests.PetDto;

public interface PetService {

    PetDto registerPet(PetDto petDto);
    PetDto returnPetDtoById(int petId);


}
