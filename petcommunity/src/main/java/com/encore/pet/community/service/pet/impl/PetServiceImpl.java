//package com.encore.pet.community.service.pet.impl;
//
//import com.encore.pet.community.exception.PetNullPointerException;
//import com.encore.pet.community.controller.pet.requests.PetRequestDTO;
//import com.encore.pet.community.domain.pet.Pet;
//import com.encore.pet.community.repository.PetCategoryRepository;
//import com.encore.pet.community.repository.PetRepository;
//import com.encore.pet.community.repository.UserRepository;
//import com.encore.pet.community.service.pet.PetService;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.Optional;
//
//@Service
//public class PetServiceImpl implements PetService {
//
//    private final PetRepository petRepository;
//    private final PetCategoryRepository petCategoryRepository;
//    private final UserRepository userRepository;
//
//
//    public PetServiceImpl(PetRepository petRepository, PetCategoryRepository petCategoryRepository, UserRepository userRepository) {
//        this.petRepository = petRepository;
//        this.petCategoryRepository = petCategoryRepository;
//        this.userRepository = userRepository;
//    }
//
//    public Long registerPet(PetRequestDTO petRequestDTO){
//
//
//
//    }
//
//    @Override
//    @Transactional
//    public PetRequestDTO returnPetDtoById(int petId) {
//
//        Optional<Pet> pet = petRepository.findById(Pet.of(petId));
//
//        if (pet.isEmpty()){
//            throw new PetNullPointerException("해당 반려동물을 찾을 수 없습니다");
//        }
//
//
//        return null;
//    }
//}
