package com.encore.pet.community.pet.entity;

import com.encore.pet.community.domain.pet.Pet;
import com.encore.pet.community.domain.pet.PetCategory;
import com.encore.pet.community.domain.pet.PetGender;
import com.encore.pet.community.domain.pet.PetGenderNeutral;
import com.encore.pet.community.domain.user.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("펫 엔티티 테스트")
class PetTest {

    @Test
    @DisplayName("펫 등록 테스트 - 정상")
    void registerPetTest() {
        //given
        Long id = 1L;
        String userId = "test";
        User user = new User(userId);
        String petCategoryId = "00";
        PetCategory petCategory = new PetCategory(petCategoryId, "개", "진돗개");
        String petName = "hunki";
        Integer age = 3;
        PetGender gender = PetGender.MALE;
        PetGenderNeutral neutral = PetGenderNeutral.NEUTRAL;
        //when
        Pet pet = Pet.builder().user(user).petCategory(petCategory).petName(petName)
                .age(age).gender(gender).petGenderNeutral(neutral).build();
        //then
        Assertions.assertThat(pet.getUser()).isEqualTo(user);
    }

}