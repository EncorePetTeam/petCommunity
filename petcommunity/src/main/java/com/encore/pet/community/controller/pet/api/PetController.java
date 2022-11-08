package com.encore.pet.community.controller.pet.api;

import com.encore.pet.community.controller.pet.requests.RegisterPetRequest;
import com.encore.pet.community.controller.pet.responses.RegisterPetResponse;
import com.encore.pet.community.service.pet.PetService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("pet")
@RestController
@CrossOrigin("http://localhost:8282")
public class PetController {
    private final PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }

    @ExceptionHandler({IllegalArgumentException.class})
    public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Please check gender or neutral");
    }

    @PostMapping("/pet")
    public ResponseEntity<RegisterPetResponse> registerPet(@RequestBody RegisterPetRequest registerPetRequest){

        return ResponseEntity.status(HttpStatus.CREATED).body(petService.registerPet(registerPetRequest));
    }




}
