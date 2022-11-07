package com.encore.pet.community.repository;

import com.encore.pet.community.domain.pet.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository extends JpaRepository<Pet, Long> {


}
