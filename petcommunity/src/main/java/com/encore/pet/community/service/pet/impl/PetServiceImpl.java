package com.encore.pet.community.service.pet.impl;

import com.encore.pet.community.utils.mapper.PetMapper;
import com.encore.pet.community.controller.pet.requests.RegisterPetRequest;
import com.encore.pet.community.controller.pet.responses.RegisterPetResponse;
import com.encore.pet.community.domain.pet.Pet;
import com.encore.pet.community.domain.pet.PetCategory;
import com.encore.pet.community.domain.user.User;
import com.encore.pet.community.exception.DBNotFoundException;
import com.encore.pet.community.exception.PetNullPointerException;
import com.encore.pet.community.repository.PetCategoryRepository;
import com.encore.pet.community.repository.PetRepository;
import com.encore.pet.community.repository.UserRepository;
import com.encore.pet.community.service.pet.PetService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class PetServiceImpl implements PetService {

    private final PetRepository petRepository;
    private final PetCategoryRepository petCategoryRepository;
    private final UserRepository userRepository;


    public PetServiceImpl(PetRepository petRepository, PetCategoryRepository petCategoryRepository, UserRepository userRepository) {
        this.petRepository = petRepository;
        this.petCategoryRepository = petCategoryRepository;
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public RegisterPetResponse registerPet(RegisterPetRequest registerPetRequest) {
        PetCategory findedCategory = petCategoryRepository
                .findById(registerPetRequest.getCategoryId()).orElseThrow(() -> new DBNotFoundException("Category could not be found"));
        User findedUser = userRepository.findById(registerPetRequest.getUserId()).orElseThrow(() -> new DBNotFoundException("User could not be found"));

        Pet pet = PetMapper.registerPetRequestToEntity(registerPetRequest, findedUser, findedCategory);

        Pet savedPet = petRepository.save(pet);

        return PetMapper.entityToRegisterPetResponse(savedPet);
    }

}
