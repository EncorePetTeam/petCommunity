package com.encore.pet.community.service.pet;

import com.encore.pet.community.controller.pet.requests.PetRequestDTO;

public interface PetService {
    PetRequestDTO returnPetDtoById(int petId);


}
