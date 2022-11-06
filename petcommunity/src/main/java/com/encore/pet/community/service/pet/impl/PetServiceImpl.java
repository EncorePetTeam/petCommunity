package com.encore.pet.community.service.pet.impl;

import com.encore.pet.community.exception.PetNullPointerException;
import com.encore.pet.community.controller.pet.requests.PetDto;
import com.encore.pet.community.domain.pet.Pet;
import com.encore.pet.community.repository.PetCategoryRepository;
import com.encore.pet.community.repository.PetRepository;
import com.encore.pet.community.service.pet.PetService;
import com.encore.pet.community.user.repository.UserRepository;
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
    public PetDto registerPet(PetDto petDto) {

        Pet pet = Pet.builder().
        PetDto registerPet = Pet.registerPet(petDto);
        petRepository.save(registerPet);

        return registerPet;
    }

    @Override
    @Transactional
    public PetDto returnPetDtoById(int petId) {

        Optional<Pet> pet = petRepository.findById(Pet.of(petId));

        if (pet.isEmpty()){
            throw new PetNullPointerException("해당 반려동물을 찾을 수 없습니다");
        }


        return null;
    }
}
