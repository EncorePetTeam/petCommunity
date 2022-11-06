package com.encore.pet.community.domain.pet;

import com.encore.pet.community.domain.user.User;
import lombok.*;

import javax.persistence.*;

import static lombok.AccessLevel.*;

@ToString
@Entity
@Setter(PROTECTED)
@Getter
@Table(name = "pet")
@NoArgsConstructor(access = PROTECTED)
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "user_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private User user;
    // inner join할 때 optional = false
    // user_id로 pet_id를 찾기 떄문에 inner join 임.

    @JoinColumn(name = "category_id",nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private PetCategory petCategory;

    @Column(nullable = false)
    private String petName;

    @Column(nullable = false)
    private Integer age;

    @Column(nullable = false)
    private PetGenderEnum gender;

    @Column(nullable = false)
    private PetGenderNeutralEnum neutral;

    @Builder
    public Pet(User user, PetCategory petCategory, String petName, Integer age, PetGenderEnum gender) {
        this.user = user;
        this.petCategory = petCategory;
        this.petName = petName;
        this.age = age;
        this.gender = gender;
    }


}
