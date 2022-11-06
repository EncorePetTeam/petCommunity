package com.encore.pet.community.pet.entity;

import com.encore.pet.community.domain.pet.PetCategory;
import com.encore.pet.community.domain.user.User;
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
        PetCategory petCategory = new PetCategory()
        //when

        //then
    }

}