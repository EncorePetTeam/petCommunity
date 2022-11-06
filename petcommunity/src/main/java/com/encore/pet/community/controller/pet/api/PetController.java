package com.encore.pet.community.controller.pet.api;

import com.encore.pet.community.domain.pet.Pet;
import com.encore.pet.community.domain.pet.PetCategory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("pet")
@RestController
@CrossOrigin("http://localhost:8282")
public class PetController {

    private final Pet pet;
    private final PetCategory petCategory;

    public PetController(Pet pet, PetCategory petCategory){
        this.pet = pet;
        this.petCategory = petCategory;
    }

    @PostMapping("/register_pet")
    public ResponseEntity<Pet> registerPet(@RequestBody Pet pet){
        return ResponseEntity.ok().body(Pet.registerPet(pet));
    }




}
