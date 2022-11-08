package com.encore.pet.community.service.pet;

import com.encore.pet.community.controller.pet.requests.RegisterPetRequest;
import com.encore.pet.community.controller.pet.responses.RegisterPetResponse;

public interface PetService {
    RegisterPetResponse registerPet(RegisterPetRequest registerPetRequest);

}
