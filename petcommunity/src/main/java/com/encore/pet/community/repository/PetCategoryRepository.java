package com.encore.pet.community.repository;

import com.encore.pet.community.domain.pet.PetCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetCategoryRepository extends JpaRepository<PetCategory, PetCategory> {

}
